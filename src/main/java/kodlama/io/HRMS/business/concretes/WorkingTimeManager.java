package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.HRMS.business.abstracts.WorkingTimeService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.dataAccess.abstracts.WorkingTimeDao;
import kodlama.io.HRMS.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService {
	
	private WorkingTimeDao workingTimeDao;
	
	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll());
	}

	
	
}
