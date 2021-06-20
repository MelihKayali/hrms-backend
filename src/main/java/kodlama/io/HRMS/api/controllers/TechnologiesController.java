package kodlama.io.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.TechnologyService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Technology;
import kodlama.io.HRMS.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("/api/technology")
public class TechnologiesController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	 @GetMapping("/getall")
	    public DataResult<List<Technology>> getAll(){
	        return this.technologyService.getAll();
	    }
	    
	    @PostMapping("/add")
	    public Result add(@Valid @RequestBody TechnologyDto technologyDto) {
	    	return this.technologyService.add(technologyDto);
	    }
}
