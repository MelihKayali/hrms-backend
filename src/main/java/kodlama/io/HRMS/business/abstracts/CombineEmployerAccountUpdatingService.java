package kodlama.io.HRMS.business.abstracts;

import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateCompanyInfoDto;

public interface CombineEmployerAccountUpdatingService {
	Result makeRequestForAccountDetailsChange(
			EmployerUserUpdateCompanyInfoDto employerUserUpdateCompanyInfoDto);

	Result confirmEmployerAccountChange(int employerUserUpdateCompanyInfoId, int employeeUserId, int employerUserId);

	Result rejectEmployerAccountChange(int employerUserUpdateCompanyInfoId, int employeeUserId);

	Result updateEmployerAccountInformation(int employerUserId, int employerUserUpdateCompanyInfoId);
}
