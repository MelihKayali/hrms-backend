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

import kodlama.io.HRMS.business.abstracts.EmployeeUserService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;


@RestController
@RequestMapping("/api/employeeuser")
public class EmployeeUsersController {

	private EmployeeUserService employeeUserService;
	
	@Autowired
	public EmployeeUsersController(EmployeeUserService employeeUserService) {
		super();
		this.employeeUserService = employeeUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployeeUser>> getAll(){
		return this.employeeUserService.getAll();
	}
	
	@PutMapping()
	public DataResult<List<EmployeeUser>> condfirmedEmployer(EmployeeUser employeeUser){
		return this.condfirmedEmployer(employeeUser);
		
	}
	
	
	   @PostMapping("/add")
	    public Result add(@Valid @RequestBody EmployeeUser employeeUser) {
	    	return this.employeeUserService.add(employeeUser);
	    }
}
