package kodlama.io.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.JobExperienceService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.JobExperience;
import kodlama.io.HRMS.entities.dtos.JobExperienceDto;
import kodlama.io.HRMS.entities.dtos.JobExperienceUpdateDto;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }
    
    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
    	return this.jobExperienceService.add(jobExperienceDto);
    }
    
    @PutMapping("/updateJobExperience")
    public Result updateJobExperience (@Valid @RequestBody JobExperienceUpdateDto jobExperienceUpdateDto) {
    	return this.jobExperienceService.updateJobExperience(jobExperienceUpdateDto);
    }

}
