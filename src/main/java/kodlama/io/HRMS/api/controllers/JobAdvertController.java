package kodlama.io.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.JobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobAdvertDto jobAdvertDto) {
		return this.jobAdvertService.add(jobAdvertDto);
	}

	@GetMapping("/getall")
	DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}

	@GetMapping("/getbyId")
	DataResult<JobAdvert> getById(@RequestParam int id) {
		return this.jobAdvertService.getById(id);
	}

	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}

	@GetMapping("/findallbyorderbypublished")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc() {
		return this.jobAdvertService.findAllByOrderByPublishedAtDesc();
	}

	@GetMapping("/getallopenjobadvert")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}

	@PutMapping("onJobAdvert")
	public Result onJobAdvert(@Valid @RequestParam int jobAdvertId) {
		return this.jobAdvertService.onJobAdvert(jobAdvertId);
	}

	@PutMapping("offJobAdvert")
	public Result offJobAdvert(@Valid @RequestParam int jobAdvertId) {
		return this.jobAdvertService.offJobAdvert(jobAdvertId);
	}

	@GetMapping("/getbyactiveiswithcityfiltering")
	public DataResult<List<JobAdvert>> getByActiveIsWithCityFiltering(@Valid @RequestParam int pageNo,
			@Valid @RequestParam int pageSize, @Valid @RequestParam int... cityIds) {
		return this.jobAdvertService.getByActiveIsWithCityFiltering(pageNo, pageSize, cityIds);
	}

	@GetMapping("/getbyactiveisandworkingtime")
	public DataResult<List<JobAdvert>> getByActiveIsAndWorkingTimeFiltering(@Valid @RequestParam int pageNo,
			@Valid @RequestParam int pageSize, @Valid @RequestParam int... workingTimes) {
		return this.jobAdvertService.getByActiveIsAndWorkingTimeFiltering(pageNo, pageSize, workingTimes);
	}

	@GetMapping("/getbyactiveiswithpagination")
	public DataResult<List<JobAdvert>> getByActiveIsWithPagination(
			@Valid @RequestParam(required = false, defaultValue = "1") int pageNo,
			@Valid @RequestParam(required = false, defaultValue = "10") int pageSize) {
		return this.jobAdvertService.getByActiveIsWithPagination(pageNo, pageSize);
	}

}
