package kodlama.io.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	JobAdvert findById(int id);

	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> getAllOpenJobAdvertList();

	@Query("From JobAdvert where isOpen = true Order By publishedAt Desc")
	List<JobAdvert> findAllByOrderByPublishedAtDesc();

	@Query("From JobAdvert where isOpen = true and employer_id =:id")
	List<JobAdvert> getAllOpenJobAdvertByEmployer(int id);

	@Query(value = "FROM JobAdvert jobAdvert where jobAdvert.isActive = true and jobAdvert.city.id in :cityIds ORDER BY jobAdvert.id")
	Page<JobAdvert> getByActiveIsWithCityFiltering(Pageable pageable, int... cityIds);

	@Query(value = "FROM JobAdvert jobAdvert where jobAdvert.isActive = true and jobAdvert.workingTime.id in :workingTimes ORDER BY jobAdvert.id")
	Page<JobAdvert> getByActiveIsAndWorkingTimeFiltering(Pageable pageable, int... workingTimes);

	@Query("FROM JobAdvert where isActive = true and employerUser.id=:employerUserId")
	List<JobAdvert> getByActiveIsAndEmployer_Id(int employerUserId);

}
