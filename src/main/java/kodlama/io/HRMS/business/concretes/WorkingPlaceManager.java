package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.WorkingPlaceService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.dataAccess.abstracts.WorkingPlaceDao;
import kodlama.io.HRMS.entities.concretes.WorkingPlace;

@Service
public class WorkingPlaceManager implements WorkingPlaceService {

	private WorkingPlaceDao workingPlaceDao;

	@Autowired
	public WorkingPlaceManager(WorkingPlaceDao workingPlaceDao) {
		super();
		this.workingPlaceDao = workingPlaceDao;
	}

	@Override
	public DataResult<List<WorkingPlace>> getAll() {
		return new SuccessDataResult<List<WorkingPlace>>(this.workingPlaceDao.findAll());
	}
}
