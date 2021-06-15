package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.City;
import kodlama.io.HRMS.entities.concretes.Education;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
