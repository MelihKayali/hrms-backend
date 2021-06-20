package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.JobExperience;
import kodlama.io.HRMS.entities.dtos.JobExperienceDto;

public interface JobExperienceService {
	Result add(JobExperienceDto jobExperienceDto);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
}
