package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Graduate;

public interface GraduateService {
	Result add(Graduate graduate);
	DataResult<List<Graduate>> getAll();	
}
