package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.WorkingTimeService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingtimes")
public class WorkingTimesController {
private WorkingTimeService workingTimeService;
	
	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	}
	

    @GetMapping("/getall")
    public DataResult<List<WorkingTime>> getAll(){
        return this.workingTimeService.getAll();
    }
}
