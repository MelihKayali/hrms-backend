package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.EmployeeUser;

public interface EmployeeUserDao extends JpaRepository<EmployeeUser, Integer> {
	boolean existsByEmail(String email);
}
