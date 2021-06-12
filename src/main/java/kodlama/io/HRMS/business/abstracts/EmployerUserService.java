package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.EmployerUser;

public interface EmployerUserService {
	DataResult<List<EmployerUser>> getAll();
	DataResult<List<EmployerUser>> findbyEmail(String email);
	Result add(EmployerUser employerUser);
}
