package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.WorkingPlaceService;
import kodlama.io.HRMS.business.abstracts.WorkingTimeService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.entities.concretes.WorkingPlace;
import kodlama.io.HRMS.entities.concretes.WorkingTime;

@RestController
@RequestMapping("api/workingplaces")
public class WorkingPlacesController {
private WorkingPlaceService workingPlaceService;
	
	@Autowired
	public WorkingPlacesController(WorkingPlaceService workingPlaceService) {
		super();
		this.workingPlaceService = workingPlaceService;
	}
	

    @GetMapping("/getall")
    public DataResult<List<WorkingPlace>> getAll(){
        return this.workingPlaceService.getAll();
    }
}
