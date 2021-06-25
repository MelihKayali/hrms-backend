package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;
import kodlama.io.HRMS.entities.concretes.EmployerUser;
import kodlama.io.HRMS.entities.concretes.JobAdvert;

public interface EmployeeUserService {
	Result add(EmployeeUser employeeUser);
	DataResult<List<EmployeeUser>> getAll();
	DataResult<Boolean> confirmedEmployer(EmployeeUser employeeUser,EmployerUser confirmedEmployerUser);
	DataResult<Boolean> confirmedJobAdvert(EmployeeUser employeeUser , JobAdvert jobAdvert);
}
