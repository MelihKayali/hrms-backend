package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.CandidateUser;

public interface CandidateUserDao extends JpaRepository<CandidateUser, Integer>{
	boolean existsByEmail(String email);
	boolean existsByIdentityNumber(String identityNumber);
}
