package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CandidateUserService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateUser;

@RestController
@RequestMapping("/api/candidateuser")
public class CandidateUsersController {
	
	private CandidateUserService candidateUserService;
	
	@Autowired
	public CandidateUsersController(CandidateUserService candidateUserService) {
		super();
		this.candidateUserService = candidateUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateUser>> getAll(){
		return this.candidateUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateUser candidateUser) {
		return this.candidateUserService.add(candidateUser);
	}

}
