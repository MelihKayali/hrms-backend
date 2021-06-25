package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EducationService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.EducationDao;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.dtos.EducationDto;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public EducationManager(EducationDao educationDao,DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(EducationDto educationDto) {
		this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public Result updateEducation(EducationUpdateDto educationUpdateDto) {
		Education education = this.educationDao.getById(educationUpdateDto.getId());
		
		EducationDto educationDto = (EducationDto) this.dtoConverterService.dtoClassConverter(education, EducationDto.class);
		educationDto.setSchoolName(educationUpdateDto.getSchoolName());
		educationDto.setSchoolDepartment(educationUpdateDto.getSchoolDepartment());
		educationDto.setGraduateId(educationUpdateDto.getGraduateId());
		educationDto.setEndedDate(educationUpdateDto.getEndedDate());
		educationUpdateDto.setStartedDate(educationUpdateDto.getStartedDate());
		
		
		Education updatedEducation = (Education) this.dtoConverterService.dtoClassConverter(educationDto, Education.class);
		
		this.educationDao.save(updatedEducation);
		return new SuccessResult("Güncellendi");
	}

}
