package kodlama.io.HRMS.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.business.abstracts.ResumeService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.CloudinaryService;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.ResumeDao;
import kodlama.io.HRMS.entities.concretes.Resume;
import kodlama.io.HRMS.entities.dtos.ResumeAddDto;
import kodlama.io.HRMS.entities.dtos.ResumeGetDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,DtoConverterService dtoConverterService,CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
		this.cloudinaryService = cloudinaryService;
		
	}

	@Override
	public Result add(ResumeAddDto resumeAddDto) {
//		Resume resea = resumeDao.save(resume);
//		ResumeHelper helper = new ResumeHelper();
//		helper.setAllResumeId(resea.getEducations(), resea.getTechnologies(), resea.getLanguages(), resea.getJobExperiences());
		this.resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeAddDto, Resume.class));
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Data Listelendi");
	}


	@Override
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeGetDto>>
		(dtoConverterService.dtoConverter
				(resumeDao.findAll(), ResumeGetDto.class)
				,"Data Listelendi");
	}

	@Override
	public Result addPicture(MultipartFile file, int resumeId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) 
				cloudinaryService.save(file).getData(); 
		String imageUrl= uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
		
	}

}
