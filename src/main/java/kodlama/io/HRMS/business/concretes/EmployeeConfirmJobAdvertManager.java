package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmployeeConfirmJobAdvertService;
import kodlama.io.HRMS.business.concretes.helper.ConfirmHelper;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.EmployeeConfirmJobAdvertDao;
import kodlama.io.HRMS.dataAccess.abstracts.EmployeeUserDao;
import kodlama.io.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.HRMS.dataAccess.abstracts.ResumeDao;
import kodlama.io.HRMS.entities.concretes.Education;
import kodlama.io.HRMS.entities.concretes.EmployeeConfirmJobAdvert;
import kodlama.io.HRMS.entities.concretes.EmployeeUser;
import kodlama.io.HRMS.entities.concretes.JobAdvert;
import kodlama.io.HRMS.entities.dtos.EmployeeConfirmJobAdvertDto;

@Service
public class EmployeeConfirmJobAdvertManager implements EmployeeConfirmJobAdvertService {

	private EmployeeConfirmJobAdvertDao employeeConfirmJobAdvertDao;
	private JobAdvertDao jobAdvertDao;
	private DtoConverterService dtoConverterService;
	private EmployeeUserDao employeeUserDao;

	@Autowired
	public EmployeeConfirmJobAdvertManager(EmployeeConfirmJobAdvertDao employeeConfirmJobAdvertDao ,JobAdvertDao jobAdvertDao , EmployeeUserDao employeeUserDao,DtoConverterService dtoConverterService) {
		super();
		this.employeeConfirmJobAdvertDao = employeeConfirmJobAdvertDao;
		this.jobAdvertDao = jobAdvertDao;
		this.employeeUserDao = employeeUserDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<EmployeeConfirmJobAdvert> getById(int id) {
		return new SuccessDataResult<EmployeeConfirmJobAdvert>(this.employeeConfirmJobAdvertDao.getById(id));
	}

	@Override
	public Result confirmJobAdvert(int jobAdvertId, int  employeeUserId ,  int employeeConfirmJobAdvertId) {
	
		JobAdvert jobAdvert = jobAdvertDao.getById(jobAdvertId);
		jobAdvert.setActive(true);
		EmployeeUser employeeUser = employeeUserDao.getById(employeeUserId);
		EmployeeConfirmJobAdvert employeeConfirmJobAdvert = employeeConfirmJobAdvertDao.getById(employeeConfirmJobAdvertId);
		employeeConfirmJobAdvert.setConfirm(true);
		employeeConfirmJobAdvert.setEmployeeUser(employeeUser);
		this.jobAdvertDao.save(jobAdvert);
		this.employeeConfirmJobAdvertDao.save(employeeConfirmJobAdvert);
		return new SuccessResult();
	}

	@Override
	public Result add(EmployeeConfirmJobAdvertDto employeeConfirmJobAdvertDto) {
		this.employeeConfirmJobAdvertDao.save((EmployeeConfirmJobAdvert) dtoConverterService.dtoClassConverter(employeeConfirmJobAdvertDto, EmployeeConfirmJobAdvert.class));
		return new SuccessResult("Kayıt Başarılı");
	}
	
}


	

	
