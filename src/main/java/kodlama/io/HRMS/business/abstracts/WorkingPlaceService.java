package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.entities.concretes.WorkingPlace;


public interface WorkingPlaceService {
	DataResult<List<WorkingPlace>> getAll();
}
