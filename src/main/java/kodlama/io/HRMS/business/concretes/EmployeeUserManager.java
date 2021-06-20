package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmployeeUserService;
import kodlama.io.HRMS.business.concretes.helper.EmployeeUserCheckHelper;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.EmployeeUserDao;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;
import kodlama.io.HRMS.entities.concretes.EmployerUser;

@Service
public class EmployeeUserManager implements EmployeeUserService{
	
	private  EmployeeUserDao employeeUserDao;
	
	@Autowired
	public EmployeeUserManager(EmployeeUserDao employeeUserDao) {
		super();
		this.employeeUserDao = employeeUserDao;
	}

	@Override
	public DataResult<List<EmployeeUser>> getAll() {
		return new SuccessDataResult<List<EmployeeUser>>(this.employeeUserDao.findAll());
	}

	@Override
	public DataResult<Boolean> confirmedEmployer(EmployeeUser employeeUser, EmployerUser confirmedEmployerUser) {
		return new SuccessDataResult<>(EmployeeUserCheckHelper.confirmEmployer(confirmedEmployerUser));
	}

	@Override
	public Result add(EmployeeUser employeeUser) {
		this.employeeUserDao.save(employeeUser);
		return new SuccessResult("Kayıt Başarılı");
	}
	


}
