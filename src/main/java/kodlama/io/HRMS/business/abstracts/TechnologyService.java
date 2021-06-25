package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Technology;
import kodlama.io.HRMS.entities.dtos.TechnologyDto;
import kodlama.io.HRMS.entities.dtos.TechnologyUpdateDto;

public interface TechnologyService {
	Result add(TechnologyDto technologyDto);
	DataResult<List<Technology>> getAll();
	Result updateTechnology(TechnologyUpdateDto technologyUpdateDto);
	
}
