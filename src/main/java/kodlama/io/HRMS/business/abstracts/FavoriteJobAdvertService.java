package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.FavoriteJobAdvert;
import kodlama.io.HRMS.entities.dtos.FavoriteJobAdvertDto;


public interface FavoriteJobAdvertService {
	Result add(FavoriteJobAdvertDto favoriteJobAdvertDto);
	DataResult<List<FavoriteJobAdvert>> getAll();
	Result favoriteJobAdvert(int jobAdvertId , int candidateUserId , int favoriteJobAdvertId);
	
}
