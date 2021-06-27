package kodlama.io.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CombineEmployerAccountUpdatingService;
import kodlama.io.HRMS.business.abstracts.EmployerUserService;
import kodlama.io.HRMS.business.abstracts.EmployerUserUpdateCompanyInfoService;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.entities.concretes.EmployerUser;
import kodlama.io.HRMS.entities.concretes.EmployerUserUpdateCompanyInfo;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateCompanyInfoDto;

@Service
public class CombineEmployerAccountUpdatingManager implements CombineEmployerAccountUpdatingService {

	private EmployerUserUpdateCompanyInfoService employerUserUpdateCompanyInfoService;
	private EmployerUserService employerUserService;
	
	@Autowired
	public CombineEmployerAccountUpdatingManager(
			EmployerUserUpdateCompanyInfoService employerUserUpdateCompanyInfoService,
			EmployerUserService employerUserService) {
		super();
		this.employerUserUpdateCompanyInfoService = employerUserUpdateCompanyInfoService;
		this.employerUserService = employerUserService;
	}

	
	@Override
	public Result makeRequestForAccountDetailsChange(
			EmployerUserUpdateCompanyInfoDto employerUserUpdateCompanyInfoDto) {
		this.employerUserUpdateCompanyInfoService.add(employerUserUpdateCompanyInfoDto);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result confirmEmployerAccountChange(int employerUserUpdateCompanyInfoId, int employeeUserId,
			int employerUserId) {
		this.employerUserUpdateCompanyInfoService.confirmChange(employerUserUpdateCompanyInfoId, employerUserId);
		this.updateEmployerAccountInformation(employerUserUpdateCompanyInfoId, employerUserId);
		return new SuccessResult("değiştirildi");
	}

	@Override
	public Result rejectEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int employeeUserId) {
		this.employerUserUpdateCompanyInfoService.refuseChange(employerStaffVerifyAccountUpdateId, employeeUserId);
		return new SuccessResult("değiştirilmedi");
	}

	@Override
	public Result updateEmployerAccountInformation(int employerId, int employerUserUpdateCompanyInfoId) {
		EmployerUserUpdateCompanyInfo newAccountDetails = this.employerUserUpdateCompanyInfoService.getById(employerUserUpdateCompanyInfoId).getData();

        EmployerUser newEmployerUserAccountDetails = new EmployerUser();
        newEmployerUserAccountDetails.setId(newAccountDetails.getEmployerUser().getId());
        newEmployerUserAccountDetails.setEmail(newAccountDetails.getAccountInformation().getEmail());
        newEmployerUserAccountDetails.setPassword(newAccountDetails.getAccountInformation().getPassword());
        newEmployerUserAccountDetails.setCompanyName(newAccountDetails.getAccountInformation().getCompanyName());
        newEmployerUserAccountDetails.setWebAddress(newAccountDetails.getAccountInformation().getWebAddress());
        newEmployerUserAccountDetails.setTelephoneNumber(newAccountDetails.getAccountInformation().getPhoneNumber());

        this.employerUserService.update(newEmployerUserAccountDetails);

        return new SuccessResult("Updated");
	}
	
	
	
	
	
	
	
}
