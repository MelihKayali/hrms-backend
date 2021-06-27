package kodlama.io.HRMS.business.concretes;

import java.time.LocalDate;
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
import kodlama.io.HRMS.dataAccess.abstracts.EducationDao;
import kodlama.io.HRMS.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.HRMS.dataAccess.abstracts.LanguageDao;
import kodlama.io.HRMS.dataAccess.abstracts.ResumeDao;
import kodlama.io.HRMS.entities.concretes.Language;
import kodlama.io.HRMS.entities.concretes.Resume;
import kodlama.io.HRMS.entities.dtos.ResumeAddDto;
import kodlama.io.HRMS.entities.dtos.ResumeGetDto;
import kodlama.io.HRMS.entities.dtos.ResumeUpdateDto;
import kodlama.io.HRMS.entities.dtos.UpdateResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	private CloudinaryService cloudinaryService;
	private LanguageDao languageDao;
	private EducationDao educationDao;
	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,DtoConverterService dtoConverterService,CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
		this.cloudinaryService = cloudinaryService;
		this.languageDao = languageDao;
		this.educationDao = educationDao;
		this.jobExperienceDao = jobExperienceDao;
		
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
		Resume Cv = resumeDao.getById(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
		
	}

	@Override
	public Result updateResume(UpdateResumeDto updateResumeDto) {
		Resume resume = this.resumeDao.getById(updateResumeDto.getId());
		resume.setGithubLink(updateResumeDto.getGithubLink());
		resume.setDescription(updateResumeDto.getDescription());
		resume.setLinkedLink(updateResumeDto.getLinkedLink());
		resume.setPhoto(updateResumeDto.getPhoto());
		
		
		this.resumeDao.save(resume);
		return new SuccessResult("Cv güncellendi");
	}

	@Override
	public Result update(ResumeUpdateDto resumeUpdateDto) {
		 Resume tempResume = this.resumeDao.getById(resumeUpdateDto.getId());
	        tempResume.setGithubLink(resumeUpdateDto.getGithubLink());
	        tempResume.setLinkedLink(resumeUpdateDto.getLinkedinLink());
	        tempResume.setPhoto(resumeUpdateDto.getPhoto());
	        tempResume.setDescription(resumeUpdateDto.getDescription());

	        this.resumeDao.save(tempResume);

	        return new SuccessResult("Updated");
	}

	@Override
	public Result updateUpdatedDate(int resumeId) {
		Resume tempResume = this.resumeDao.getById(resumeId);
        tempResume.setUpdatedDate(LocalDate.now());
        this.resumeDao.save(tempResume);

        return new SuccessResult("Updated");
	}



}
