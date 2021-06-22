package kodlama.io.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.EmployeeConfirmJobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.EmployeeConfirmJobAdvert;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.EmployeeConfirmJobAdvertDto;

@RestController
@RequestMapping("/api/confirmJobAdverts")
@CrossOrigin
public class EmployeeConfirmJobAdvertsController {
	
	private EmployeeConfirmJobAdvertService employeeConfirmJobAdvertsService;
	
	@Autowired
	public EmployeeConfirmJobAdvertsController(EmployeeConfirmJobAdvertService employeeConfirmJobAdvertsService) {
		super();
		this.employeeConfirmJobAdvertsService = employeeConfirmJobAdvertsService;
	}


	@PutMapping("/confirmjobadvert")
	public Result confirmJobAdvert(@RequestParam int  jobAdvertId ,@RequestParam int employeeUserId ,@RequestParam int employeeConfirmJobAdvertId) {
		return this.employeeConfirmJobAdvertsService.confirmJobAdvert(jobAdvertId, employeeUserId, employeeConfirmJobAdvertId);			
	}
	
	
	@GetMapping("/employeeconfirmjobadvert")
	public DataResult<EmployeeConfirmJobAdvert> getById(int id){
		return this.employeeConfirmJobAdvertsService.getById(id);
	}
	
	
	@PostMapping("/add")
	public Result add( EmployeeConfirmJobAdvertDto employeeConfirmJobAdvertDto) {
		return this.employeeConfirmJobAdvertsService.add(employeeConfirmJobAdvertDto);
	}
	
}
