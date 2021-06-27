package kodlama.io.HRMS.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CombineResumeUpdatingService;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;
import kodlama.io.HRMS.entities.dtos.JobExperienceUpdateDto;
import kodlama.io.HRMS.entities.dtos.LanguageUpdateDto;
import kodlama.io.HRMS.entities.dtos.ResumeUpdateDto;
import kodlama.io.HRMS.entities.dtos.TechnologyUpdateDto;

@RestController
@RequestMapping("/api/combineResumesupdatingcontroller")
public class CombineResumesUpdatingController {
	
	private CombineResumeUpdatingService combineResumeUpdatingService;
	
	@Autowired
	public CombineResumesUpdatingController(CombineResumeUpdatingService combineResumeUpdatingService) {
		super();
		this.combineResumeUpdatingService = combineResumeUpdatingService;
	}
	
	@PutMapping("/updateresume")
    public Result updateResume(@Valid @RequestBody ResumeUpdateDto resumeUpdateDto){
        return this.combineResumeUpdatingService.updateResume(resumeUpdateDto);
    }

    @PutMapping("/updateeducation")
    public Result updateEducation(@Valid @RequestBody EducationUpdateDto educationUpdateDto){
        return this.combineResumeUpdatingService.updateEducation(educationUpdateDto);
    }

    @PutMapping("/updatejobexperience")
    public Result updateJobExperience(@Valid @RequestBody JobExperienceUpdateDto jobExperienceUpdateDto){
        return this.combineResumeUpdatingService.updateJobExperience(jobExperienceUpdateDto);
    }

    @PutMapping("/updatelanguage")
    public Result updateLanguage(@Valid @RequestBody LanguageUpdateDto languageUpdateDto){
        return this.combineResumeUpdatingService.updateLanguage(languageUpdateDto);
    }

    @PutMapping("/updatetechnology")
    public Result updateTechnology(@Valid @RequestBody TechnologyUpdateDto technologyUpdateDto){
        return this.combineResumeUpdatingService.updateTechnology(technologyUpdateDto);
    }
	
}
