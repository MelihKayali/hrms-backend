package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.entities.concretes.EmployerUser;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer>{
	List<EmployerUser> findByEmail(String email);
	boolean existsByEmail(String email);
}
