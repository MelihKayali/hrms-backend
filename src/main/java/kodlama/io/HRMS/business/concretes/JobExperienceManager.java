package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.JobExperienceService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.HRMS.entities.concretes.JobExperience;
import kodlama.io.HRMS.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConverterService= dtoConverterService;
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		this.jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto,JobExperience.class ));
		return new SuccessResult("Kayıt başarılı");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<JobExperienceDto>>
		(this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAllByResumeIdOrderByEndedDateDesc(id),JobExperienceDto.class),"Data Listelendi");
	}

}
