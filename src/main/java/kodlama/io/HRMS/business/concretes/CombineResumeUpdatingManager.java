package kodlama.io.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CombineResumeUpdatingService;
import kodlama.io.HRMS.business.abstracts.EducationService;
import kodlama.io.HRMS.business.abstracts.JobExperienceService;
import kodlama.io.HRMS.business.abstracts.LanguageService;
import kodlama.io.HRMS.business.abstracts.ResumeService;
import kodlama.io.HRMS.business.abstracts.TechnologyService;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;
import kodlama.io.HRMS.entities.dtos.JobExperienceUpdateDto;
import kodlama.io.HRMS.entities.dtos.LanguageUpdateDto;
import kodlama.io.HRMS.entities.dtos.ResumeUpdateDto;
import kodlama.io.HRMS.entities.dtos.TechnologyUpdateDto;

@Service
public class CombineResumeUpdatingManager implements CombineResumeUpdatingService {
	
	private  ResumeService resumeService;
    private  EducationService educationService;
    private  JobExperienceService jobExperienceService;
    private  LanguageService languageService;
    private  TechnologyService technologyService;

    @Autowired
    public CombineResumeUpdatingManager(ResumeService resumeService, EducationService educationService, JobExperienceService jobExperienceService, LanguageService languageService, TechnologyService technologyService) {
        this.resumeService = resumeService;
        this.educationService = educationService;
        this.jobExperienceService = jobExperienceService;
        this.languageService = languageService;
        this.technologyService = technologyService;
    }
	
	@Override
	public Result updateResume(ResumeUpdateDto resumeUpdateDto) {
		return resumeService.update(resumeUpdateDto);
	}

	@Override
	public Result updateEducation(EducationUpdateDto educationUpdateDto) {
		this.educationService.updateEducation(educationUpdateDto);
        this.resumeService.updateUpdatedDate(educationUpdateDto.getResumeId());

        return new SuccessResult("Updated");
	}

	@Override
	public Result updateJobExperience(JobExperienceUpdateDto jobExperienceUpdateDto) {
		 this.jobExperienceService.updateJobExperience(jobExperienceUpdateDto);
	        this.resumeService.updateUpdatedDate(jobExperienceUpdateDto.getResumeId());

	        return new SuccessResult("Updated");
	}

	@Override
	public Result updateLanguage(LanguageUpdateDto languageUpdateDto) {
		this.languageService.updateLanguage(languageUpdateDto);
        this.resumeService.updateUpdatedDate(languageUpdateDto.getResumeId());

        return new SuccessResult("Updated");
	}

	@Override
	public Result updateTechnology(TechnologyUpdateDto technologyUpdateDto) {
		 this.technologyService.updateTechnology(technologyUpdateDto);
	        this.resumeService.updateUpdatedDate(technologyUpdateDto.getResumeId());

	        return new SuccessResult("Updated");
	}
	
}
