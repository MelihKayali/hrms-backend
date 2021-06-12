package kodlama.io.HRMS.core.results.helpers;

import java.util.List;

import kodlama.io.HRMS.dataAccess.abstracts.EducationDao;
import kodlama.io.HRMS.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.HRMS.dataAccess.abstracts.LanguageDao;
import kodlama.io.HRMS.dataAccess.abstracts.TechnologyDao;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.JobExperience;
import kodlama.io.HRMS.entities.concretes.Language;
import kodlama.io.HRMS.entities.concretes.Resume;
import kodlama.io.HRMS.entities.concretes.Technology;

public class ResumeHelper {
	private EducationDao educationDao;
	private TechnologyDao technologyDao;
	private LanguageDao languageDao;
	private JobExperienceDao jobExperienceDao;
	
	
	public void setAllResumeId(List<Education> edu ,List<Technology> tech,List<Language> lang,List<JobExperience> exp) {
		SetResumEId(edu, null);
		SetResumLId(lang, null);
		SetResumTId(tech, null);
		SetResumJId(exp, null);
	}

	public ResumeHelper(EducationDao educationDao, TechnologyDao technologyDao, LanguageDao languageDao,
			JobExperienceDao jobExperienceDao) {
		super();
		this.educationDao = educationDao;
		this.technologyDao = technologyDao;
		this.languageDao = languageDao;
		this.jobExperienceDao = jobExperienceDao;
	}

	private void SetResumEId(List<Education> mapResume, Resume resumee) {
		for (Education data : mapResume) {
			data.setResume(resumee);
			educationDao.save(data);
		}
	}

	private void SetResumTId(List<Technology> mapResume, Resume resumee) {
		for (Technology data : mapResume) {
			data.setResume(resumee);
			technologyDao.save(data);
		}
	}

	private void SetResumLId(List<Language> mapResume, Resume resumee) {
		for (Language data : mapResume) {
			data.setResume(resumee);
			languageDao.save(data);
		}
	}

	private void SetResumJId(List<JobExperience> mapResume, Resume resumee) {
		for (JobExperience data : mapResume) {
			data.setResume(resumee);
			jobExperienceDao.save(data);
		}
	}

}
