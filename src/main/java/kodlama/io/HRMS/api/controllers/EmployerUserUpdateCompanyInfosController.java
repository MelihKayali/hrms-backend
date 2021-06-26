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

import kodlama.io.HRMS.business.abstracts.EmployerUserUpdateCompanyInfoService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.EmployerUserUpdateCompanyInfo;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateCompanyInfoDto;

@RestController
@RequestMapping("/api/EmployerUserUpdateCompanyInfo")
public class EmployerUserUpdateCompanyInfosController {

	private EmployerUserUpdateCompanyInfoService employerUserUpdateCompanyInfoService;

	@Autowired
	public EmployerUserUpdateCompanyInfosController(
			EmployerUserUpdateCompanyInfoService employerUserUpdateCompanyInfoService) {
		super();
		this.employerUserUpdateCompanyInfoService = employerUserUpdateCompanyInfoService;
	}

	@GetMapping("/getall")
	public DataResult<List<EmployerUserUpdateCompanyInfo>> getAll() {
		return this.employerUserUpdateCompanyInfoService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody EmployerUserUpdateCompanyInfoDto employerUserUpdateCompanyInfoDto) {
		return this.employerUserUpdateCompanyInfoService.add(employerUserUpdateCompanyInfoDto);
	}
	
	@PutMapping("/confirmChange")
	public Result confirmChange(int EmployerUserUpdateCompanyInfoId , int employerUserId) {
		return this.employerUserUpdateCompanyInfoService.confirmChange(EmployerUserUpdateCompanyInfoId, employerUserId);
	}
	
	
	@PutMapping("/refuseChange")
	Result refuseChange(int EmployerUserUpdateCompanyInfoId , int employerUserId) {
		return this.employerUserUpdateCompanyInfoService.refuseChange(EmployerUserUpdateCompanyInfoId, employerUserId);
	}

}
