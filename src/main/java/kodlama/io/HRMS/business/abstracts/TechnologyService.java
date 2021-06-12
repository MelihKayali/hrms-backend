package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Technology;
import kodlama.io.HRMS.entities.dtos.TechnologyDto;

public interface TechnologyService {
	Result add(Technology technology);
	DataResult<List<Technology>> getAll();
}
