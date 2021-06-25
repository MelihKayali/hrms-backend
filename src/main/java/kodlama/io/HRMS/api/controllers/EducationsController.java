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

import kodlama.io.HRMS.business.abstracts.EducationService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.dtos.EducationDto;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;

@RestController
@RequestMapping("/api/education")
public class EducationsController {
	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	

    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }
    
    @PostMapping("/add")
    public Result add(@Valid @RequestBody EducationDto educationDto) {
    	return this.educationService.add(educationDto);
    }
    
    
    @PutMapping("/update")
    public Result updateEducation(@Valid @RequestBody EducationUpdateDto educationUpdateDto)  {
    	return this.educationService.updateEducation(educationUpdateDto);
    }
}
