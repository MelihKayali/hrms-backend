package kodlama.io.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EducationService;
import kodlama.io.HRMS.business.abstracts.JobExperienceService;
import kodlama.io.HRMS.business.abstracts.LanguageService;
import kodlama.io.HRMS.business.abstracts.ResumeService;
import kodlama.io.HRMS.business.abstracts.ResumeUpdateService;
import kodlama.io.HRMS.business.abstracts.TechnologyService;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;
import kodlama.io.HRMS.entities.dtos.JobExperienceUpdateDto;
import kodlama.io.HRMS.entities.dtos.LanguageUpdateDto;
import kodlama.io.HRMS.entities.dtos.TechnologyUpdateDto;
import kodlama.io.HRMS.entities.dtos.UpdateResumeDto;

@Service
public class ResumeUpdateManager implements ResumeUpdateService {

	private ResumeService resumeService;
	private EducationService educationService;
	private JobExperienceService jobExperienceService;
	private LanguageService languageService;
	private TechnologyService technologyService;
	
	@Autowired
	public ResumeUpdateManager(ResumeService resumeService, EducationService educationService,
			JobExperienceService jobExperienceService, LanguageService languageService,
			TechnologyService technologyService) {
		super();
		this.resumeService = resumeService;
		this.educationService = educationService;
		this.jobExperienceService = jobExperienceService;
		this.languageService = languageService;
		this.technologyService = technologyService;
	}

	@Override
	public Result updateResume(UpdateResumeDto resumeUpdateDto) {
		return resumeService.updateResume(resumeUpdateDto);
	}

	@Override
	public Result updateEducation(EducationUpdateDto educationUpdateDto) {
		this.educationService.updateEducation(educationUpdateDto);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result updateJobExperience(JobExperienceUpdateDto jobExperienceUpdateDto) {
		this.jobExperienceService.updateJobExperience(jobExperienceUpdateDto);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result updateLanguage(LanguageUpdateDto languageUpdateDto) {
		this.languageService.updateLanguage(languageUpdateDto);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result updateTechnology(TechnologyUpdateDto technologyUpdateDto) {
		this.technologyService.updateTechnology(technologyUpdateDto);
		return new SuccessResult("Güncellendi");
	}
	
}
