package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.WorkingPlace;

public interface WorkingPlaceDao extends JpaRepository<WorkingPlace, Integer>{
	
}
