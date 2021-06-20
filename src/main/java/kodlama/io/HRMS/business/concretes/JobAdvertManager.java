package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.JobAdvertService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.results.adapters.CheckNullFieldService;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;
	private CheckNullFieldService checkNullFieldService;
	private DtoConverterService dtoConverterService;
	
	
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CheckNullFieldService checkNullFieldService , DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.checkNullFieldService = checkNullFieldService;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		this.jobAdvertDao.save((JobAdvert) dtoConverterService.dtoClassConverter(jobAdvertDto, JobAdvert.class));
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public Result delete(JobAdvertDto jobAdvertDto) {
		this.jobAdvertDao.delete((JobAdvert) dtoConverterService.dtoClassConverter(jobAdvertDto, JobAdvert.class));
		return new SuccessDataResult<JobAdvert>("İş başvurusu silindi");
	}

	@Override
	public Result update(JobAdvertDto jobAdvertDto) {
		this.jobAdvertDao.save((JobAdvert) dtoConverterService.dtoClassConverter(jobAdvertDto, JobAdvert.class));
		return new SuccessDataResult<JobAdvert>("İş başvurusu güncellendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<JobAdvert> getById() {
		return  new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(0));
	}

	
	

}
