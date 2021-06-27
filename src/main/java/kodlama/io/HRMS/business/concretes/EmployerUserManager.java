package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmailService;
import kodlama.io.HRMS.business.abstracts.EmployerUserService;
import kodlama.io.HRMS.business.concretes.helper.EmployeeUserCheckHelper;
import kodlama.io.HRMS.business.concretes.helper.EmployerUserCheckHelper;
import kodlama.io.HRMS.business.concretes.helper.UserCheckHelper;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.EmployerUserDao;
import kodlama.io.HRMS.entities.concretes.EmployerUser;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateDto;

@Service
public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;
	private EmailService emailService;
	
	
	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao, EmailService emailService) {
		super();
		this.employerUserDao = employerUserDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll());
	}

	@Override
	public DataResult<List<EmployerUser>> findbyEmail(String email) {
		return new SuccessDataResult<List<EmployerUser>>((List<EmployerUser>) this.employerUserDao.findByEmail(email));
				
	}

	@Override
	public Result add(EmployerUser employerUser) {
		var checkEmail = this.findbyEmail(employerUser.getEmail()).getData().size() !=0;
		var checkFields = !EmployerUserCheckHelper.AllFieldsAreRequired(employerUser);
		var employeeConfirm = !EmployerUserCheckHelper.confirmEmployer(employerUser);
		
		if(checkEmail || checkFields || employeeConfirm) {
			String message = "";
			
			if(checkEmail) {
				message += "Bu email mevcuttur.";
			}
			
			if(checkFields) {
				message +="Tüm alanları doldurmak zorunludur.";
			}
			
			if(employeeConfirm) {
				message +="Başvurunuz çalışanlar tarafından reddedilmiştir.";
			}
			
			return new ErrorResult(message);
		}
		
		this.employerUserDao.save(employerUser);
		return new SuccessResult(this.emailService.sendEmail(employerUser).getMessage());
	}


	@Override
	public Result update(EmployerUser employerUser) {
		 EmployerUser tempEmployerUser = this.employerUserDao.getOne(employerUser.getId());

	        tempEmployerUser.setEmail(employerUser.getEmail());
	        tempEmployerUser.setCompanyName(employerUser.getCompanyName());
	        tempEmployerUser.setWebAddress(employerUser.getWebAddress());
	        tempEmployerUser.setTelephoneNumber(employerUser.getTelephoneNumber());
	        tempEmployerUser.setPassword(employerUser.getPassword());

	        this.employerUserDao.save(tempEmployerUser);

	        return new SuccessResult("Updated");
	}

}
