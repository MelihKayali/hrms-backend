package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	boolean existsByEmail(String email);
}
