package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.EmployerUserUpdateCompanyInfo;

public interface EmployerUserUpdateCompanyInfoDao extends JpaRepository<EmployerUserUpdateCompanyInfo, Integer>{

}
