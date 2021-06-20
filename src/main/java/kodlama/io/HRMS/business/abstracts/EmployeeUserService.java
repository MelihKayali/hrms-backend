package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;
import kodlama.io.HRMS.entities.concretes.EmployerUser;

public interface EmployeeUserService {
	Result add(EmployeeUser employeeUser);
	DataResult<List<EmployeeUser>> getAll();
	DataResult<Boolean> confirmedEmployer(EmployeeUser employeeUser,EmployerUser confirmedEmployerUser);
}
