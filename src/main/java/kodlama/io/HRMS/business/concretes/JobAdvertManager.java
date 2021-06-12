package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.JobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.adapters.CheckNullFieldService;
import kodlama.io.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.HRMS.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;
	private CheckNullFieldService checkNullFieldService;
	

	public JobAdvertManager(JobAdvertDao jobAdvertDao, CheckNullFieldService checkNullFieldService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.checkNullFieldService = checkNullFieldService;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(!checkNullFieldService(jobAdvert)) {
			return new ErrorResult("Tüm alanları doldurduğunuzdan emin olun");
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult<JobAdvert>("İş başvurusu eklendi");
	}

	private boolean checkNullFieldService(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		this.jobAdvertDao.delete(jobAdvert);
		return new SuccessDataResult<JobAdvert>("İş başvurusu silindi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult<JobAdvert>("İş başvurusu güncellendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<JobAdvert> getById() {
		return  new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(0));
	}

	
	

}
