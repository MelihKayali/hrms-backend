package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	List<Education> findAllByResumeIdOrderByEndedDateDesc(int id);
}
