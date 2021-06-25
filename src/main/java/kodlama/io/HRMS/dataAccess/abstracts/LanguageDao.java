package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.Language;
import kodlama.io.HRMS.entities.concretes.Resume;

public interface LanguageDao extends JpaRepository<Language, Integer> {
//	Resume getByName(String string);
}
