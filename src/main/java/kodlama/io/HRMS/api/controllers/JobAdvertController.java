package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.JobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	
	@GetMapping("/getall")
	DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getbyıd")
	DataResult<JobAdvert> getById(){
		return this.jobAdvertService.getById();
	}
	
	
	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList(){
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}
	
	@GetMapping("/findallbyorderbypublished")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc(){
		return this.jobAdvertService.findAllByOrderByPublishedAtDesc();
	}
		
	@GetMapping("/getallopenjobadvert")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id){
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}
	
}
	
	

