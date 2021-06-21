package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.HRMS.entities.concretes.EmployeeConfirmJobAdvert;

public interface EmployeeConfirmJobAdvertDao extends JpaRepository<EmployeeConfirmJobAdvert, Integer> {
	
	List<EmployeeConfirmJobAdvert> findByEmployeeUserId(int id);
	List<EmployeeConfirmJobAdvert> findAllByJobAdvertId(int id);
	@Query("From EmployeeConfirmJobAdvert where employeeUser is Null")
	EmployeeConfirmJobAdvert getByEmployeeUserIsNull();
	
}
