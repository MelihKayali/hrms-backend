package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	Result add(JobAdvertDto jobAdvertDto);

	Result delete(JobAdvertDto jobAdvertDto);

	Result update(JobAdvertDto jobAdvertDto);

	DataResult<List<JobAdvert>> getAll();

	Result onJobAdvert(int JobAdvertId);

	Result offJobAdvert(int JobAdvertId);

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

	DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);

	DataResult<List<JobAdvert>> getByActiveIsWithCityFiltering(int pageNo, int pageSize, int... cityIds);

	DataResult<List<JobAdvert>> getByActiveIsAndWorkingTimeFiltering(int pageNo, int pageSize, int... workingTimes);
}
