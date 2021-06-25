package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.FavoriteJobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.FavoriteJobAdvert;

@RestController
@RequestMapping("/api/favoritejobadverts")
public class FavoriteJobAdvertsController {

	private FavoriteJobAdvertService favoriteJobAdvertService;

	@Autowired
	public FavoriteJobAdvertsController(FavoriteJobAdvertService favoriteJobAdvertService) {
		super();
		this.favoriteJobAdvertService = favoriteJobAdvertService;
	}

	@GetMapping("/getall")
	public DataResult<List<FavoriteJobAdvert>> getAll() {
		return this.favoriteJobAdvertService.getAll();
	}

	@PutMapping("/updateJobAdvert")
	public Result favoriteJobAdvert(int jobAdvertId, int candidateUserId, int favoriteJobAdvertId) {
		return this.favoriteJobAdvertService.favoriteJobAdvert(jobAdvertId, candidateUserId, favoriteJobAdvertId);
	}
}
