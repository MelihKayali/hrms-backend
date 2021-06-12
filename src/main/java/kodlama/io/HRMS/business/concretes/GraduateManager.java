package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.GraduateService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.GraduateDao;
import kodlama.io.HRMS.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService {
	
	private GraduateDao graduateDao;
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll());
	}

	@Override
	public Result add(Graduate graduate) {
		if(graduateDao.existsByDescription(graduate.getDescription())) {
			return new ErrorResult("Daha önce eklendi");
		}
		this.graduateDao.save(graduate); 
		return new SuccessResult("Eklendi");
	}

}
