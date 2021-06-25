package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.FavoriteJobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateUserDao;
import kodlama.io.HRMS.dataAccess.abstracts.FavoriteJobAdvertDao;
import kodlama.io.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.HRMS.entities.concretes.CandidateUser;
import kodlama.io.HRMS.entities.concretes.FavoriteJobAdvert;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.FavoriteJobAdvertDto;

@Service
public class FavoriteJobAdvertManager implements FavoriteJobAdvertService {

	
	private FavoriteJobAdvertDao favoriteJobAdvertDao;
	private CandidateUserDao candidateUserDao;
	private JobAdvertDao jobAdvertDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public FavoriteJobAdvertManager(FavoriteJobAdvertDao favoriteJobAdvertDao , CandidateUserDao candidateUserDao , JobAdvertDao jobAdvertDao , DtoConverterService dtoConverterService) {
		super();
		this.favoriteJobAdvertDao = favoriteJobAdvertDao;
		this.candidateUserDao = candidateUserDao;
		this.jobAdvertDao = jobAdvertDao;
		this.dtoConverterService = dtoConverterService;
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
	
	@Override
	public Result add(FavoriteJobAdvertDto favoriteJobAdvertDto) {
		this.favoriteJobAdvertDao.save((FavoriteJobAdvert) dtoConverterService.dtoClassConverter(favoriteJobAdvertDto, FavoriteJobAdvert.class));
		return new SuccessResult("Başarılı");
	}

	

}
