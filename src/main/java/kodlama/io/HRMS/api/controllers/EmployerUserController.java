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

import kodlama.io.HRMS.business.abstracts.EmployerUserService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.EmployerUser;
import kodlama.io.HRMS.entities.dtos.EducationUpdateDto;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateDto;

@RestController
@RequestMapping("/api/employeruser")
public class EmployerUserController {
	
	private EmployerUserService employerUserService;
	
	@Autowired
	public EmployerUserController(EmployerUserService employerUserService) {
		super();
		this.employerUserService = employerUserService;
	}
	
	@GetMapping
	public DataResult<List<EmployerUser>> getAll(){
		return this.employerUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUser employerUser) {
		return this.employerUserService.add(employerUser);
	}
	
	@PutMapping("/updateEmployer")
	public Result updateEmployer(@Valid @RequestBody EmployerUserUpdateDto employerUserUpdateDto) {
		return this.employerUserService.updateEmployerUser(employerUserUpdateDto);
	}

}
