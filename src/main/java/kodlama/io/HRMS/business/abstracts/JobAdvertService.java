package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	Result delete(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getAll();
	DataResult<JobAdvert> getById();
	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();
	DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc();
	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
}
