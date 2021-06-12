package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.dtos.EducationDto;

public interface EducationService {
	Result add(Education education);
	DataResult<List<Education>> getAll();
}
