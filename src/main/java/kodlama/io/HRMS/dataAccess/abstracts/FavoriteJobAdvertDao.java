package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.HRMS.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertDao extends JpaRepository<FavoriteJobAdvert, Integer> {
	@Query("From  FavoriteJobAdvert where jobAdvert is False")
	FavoriteJobAdvert findByFavoriteJobAdvertFalse();
}
