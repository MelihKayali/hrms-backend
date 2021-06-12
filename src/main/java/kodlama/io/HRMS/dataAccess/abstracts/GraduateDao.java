package kodlama.io.HRMS.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.Graduate;

public interface GraduateDao extends JpaRepository<Graduate, Integer> {
	boolean existsByDescription(String description);
}
