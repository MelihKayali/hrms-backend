package kodlama.io.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlama.io.HRMS.business.abstracts.JobPositionService;
import kodlama.io.HRMS.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private  JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }
    
    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobPosition jobPosition) {
    	return this.jobPositionService.add(jobPosition);
    }
}
