package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.FavoriteJobAdvert;
import kodlama.io.HRMS.entities.dtos.FavoriteJobAdvertDto;


public interface FavoriteJobAdvertService {
	DataResult<List<FavoriteJobAdvert>> getAll();
	Result favoriteJobAdvert(int jobAdvertId , int candidateUserId , int favoriteJobAdvertId);
	DataResult<FavoriteJobAdvert> add(FavoriteJobAdvert favoriteJobAdvert);
    Result delete(int favoriteJobAdvertId);
    DataResult<List<FavoriteJobAdvert>> getAllByCandidateUser(int candidateUserId);
}
