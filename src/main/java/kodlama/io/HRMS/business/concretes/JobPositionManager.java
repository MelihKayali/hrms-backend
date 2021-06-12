package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.JobPositionService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlama.io.HRMS.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private  JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		System.err.println(this.jobPositionDao.findAll());
		return new SuccessDataResult<>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<List<JobPosition>> findByPositionIs(String position) {
		return new SuccessDataResult<>(this.jobPositionDao.findByPosition(position));
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(this.findByPositionIs(jobPosition.getPosition()) != null) {
			return new ErrorResult("Bu iş pozisyonu halihazırda alındı");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Kayıt başarılı");
	}

}
