package kodlama.io.HRMS.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CombineEmployerAccountUpdatingService;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateCompanyInfoDto;

@RestController
@RequestMapping("/api/combineEmployerAccountUpdatingController")
public class CombineEmployerAccountUpdatingController {
	private CombineEmployerAccountUpdatingService combineEmployerAccountUpdatingService;
	
	@Autowired
	public CombineEmployerAccountUpdatingController(
			CombineEmployerAccountUpdatingService combineEmployerAccountUpdatingService) {
		super();
		this.combineEmployerAccountUpdatingService = combineEmployerAccountUpdatingService;
	}
	
	@PostMapping("/makerequestforaccountdetailschange")
    public Result makeRequestForAccountDetailsChange(@Valid @RequestBody EmployerUserUpdateCompanyInfoDto employerUserUpdateCompanyInfoDto) {
        return this.combineEmployerAccountUpdatingService.makeRequestForAccountDetailsChange(employerUserUpdateCompanyInfoDto);
    }

	 @PutMapping("/confirmemployeraccountchange")
	    public Result confirmEmployerAccountChange(@Valid @RequestParam int employerUserUpdateCompanyInfoId, @Valid @RequestParam int employerUserId, @Valid @RequestParam int employeeUserId) {
	        return this.combineEmployerAccountUpdatingService.confirmEmployerAccountChange(employerUserUpdateCompanyInfoId, employerUserId, employeeUserId);
	    }

    @PutMapping("/rejectemployeraccountchange")
    public Result rejectEmployerAccountChange(@Valid @RequestParam int employerUserUpdateCompanyInfoId, @Valid @RequestParam int employerUserId) {
        return this.combineEmployerAccountUpdatingService.rejectEmployerAccountChange(employerUserUpdateCompanyInfoId, employerUserId);
    }
}
