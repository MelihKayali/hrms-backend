package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.EmployeeConfirmJobAdvert;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.EmployeeConfirmJobAdvertDto;

public interface EmployeeConfirmJobAdvertService {
	Result add(EmployeeConfirmJobAdvertDto employeeConfirmJobAdvertDto);
	Result confirmJobAdvert(JobAdvert jobAdvert , EmployeeUser employeeUser ,  EmployeeConfirmJobAdvert employeeConfirmJobAdvert);
	DataResult<EmployeeConfirmJobAdvert> getById(int id);
}
