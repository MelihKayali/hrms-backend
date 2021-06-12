package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	List<Resume> findAllByCandidateUser(int id);
}
