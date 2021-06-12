package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CityService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.dataAccess.abstracts.CityDao;
import kodlama.io.HRMS.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {

		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

}
