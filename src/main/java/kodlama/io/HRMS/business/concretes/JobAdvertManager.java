package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CheckNullFieldService checkNullFieldService,
			DtoConverterService dtoConverterService) {
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
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id));
	}

	@Override
	public Result onJobAdvert(int JobAdvertId) {
		JobAdvert jobAdvert = this.jobAdvertDao.getById(JobAdvertId);
		jobAdvert.setActive(true);

		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş İlanı Açıldı");
	}

	@Override
	public Result offJobAdvert(int JobAdvertId) {
		JobAdvert jobAdvert = this.jobAdvertDao.getById(JobAdvertId);
		jobAdvert.setActive(false);

		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş İlanı Kapandı");
	}

	@Override
	public DataResult<List<JobAdvert>> getByActiveIsWithCityFiltering(int pageNo, int pageSize, int... cityIds) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<>(
				this.jobAdvertDao.getByActiveIsWithCityFiltering(pageable, cityIds).getContent());
	}

	@Override
	public DataResult<List<JobAdvert>> getByActiveIsAndWorkingTimeFiltering(int pageNo, int pageSize,
			int... workingTimes) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<>(
				this.jobAdvertDao.getByActiveIsAndWorkingTimeFiltering(pageable, workingTimes).getContent());
	}

	@Override
	public DataResult<List<JobAdvert>> getByActiveIsWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIs(pageable).getContent());
	}

}
