package kodlama.io.HRMS.business.abstracts;

import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;
import kodlama.io.HRMS.entities.dtos.JobExperienceUpdateDto;
import kodlama.io.HRMS.entities.dtos.LanguageUpdateDto;
import kodlama.io.HRMS.entities.dtos.ResumeUpdateDto;
import kodlama.io.HRMS.entities.dtos.TechnologyUpdateDto;

public interface CombineResumeUpdatingService {
	 Result updateResume(ResumeUpdateDto resumeUpdateDto);
	    Result updateEducation(EducationUpdateDto educationUpdateDto);
	    Result updateJobExperience(JobExperienceUpdateDto jobExperienceUpdateDto);
	    Result updateLanguage(LanguageUpdateDto languageUpdateDto);
	    Result updateTechnology(TechnologyUpdateDto technologyUpdateDto);
}
