package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.EmployerUserUpdateCompanyInfo;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateCompanyInfoDto;

public interface EmployerUserUpdateCompanyInfoService {
	DataResult<List<EmployerUserUpdateCompanyInfo>> getAll();
	Result add(EmployerUserUpdateCompanyInfoDto employerUserUpdateCompanyInfoDto);
	Result confirmChange(int EmployerUserUpdateCompanyInfoId , int employerUserId);
	Result refuseChange(int EmployerUserUpdateCompanyInfoId , int employerUserId);
}
