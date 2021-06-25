package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.FavoriteJobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateUserDao;
import kodlama.io.HRMS.dataAccess.abstracts.FavoriteJobAdvertDao;
import kodlama.io.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.HRMS.entities.concretes.CandidateUser;
import kodlama.io.HRMS.entities.concretes.FavoriteJobAdvert;
import kodlama.io.HRMS.entities.concretes.JobAdvert;

@Service
public class FavoriteJobAdvertManager implements FavoriteJobAdvertService {

	
	private FavoriteJobAdvertDao favoriteJobAdvertDao;
	private CandidateUserDao candidateUserDao;
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public FavoriteJobAdvertManager(FavoriteJobAdvertDao favoriteJobAdvertDao , CandidateUserDao candidateUserDao , JobAdvertDao jobAdvertDao) {
		super();
		this.favoriteJobAdvertDao = favoriteJobAdvertDao;
		this.candidateUserDao = candidateUserDao;
		this.jobAdvertDao = jobAdvertDao;
	}
	@Override
	public DataResult<List<FavoriteJobAdvert>> getAll() {
		
		return new SuccessDataResult<List<FavoriteJobAdvert>>(this.favoriteJobAdvertDao.findAll());
	}

	@Override
	public Result favoriteJobAdvert(int jobAdvertId, int candidateUserId, int favoriteJobAdvertId) {
		JobAdvert jobAdvert = jobAdvertDao.getById(jobAdvertId);
		jobAdvert.setActive(true);
		CandidateUser candidateUser = candidateUserDao.getById(candidateUserId);
		FavoriteJobAdvert favoriteJobAdvert = favoriteJobAdvertDao.getById(favoriteJobAdvertId);
		favoriteJobAdvert.setFavoriteJobAdvert(true);
		favoriteJobAdvert.setCandidateUser(candidateUser);
		
		this.jobAdvertDao.save(jobAdvert);
		this.favoriteJobAdvertDao.save(favoriteJobAdvert);
		
		return new SuccessResult("Favorilere eklendi");
	}

	

}
