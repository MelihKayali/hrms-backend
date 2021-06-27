package kodlama.io.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmployerUserUpdateCompanyInfoService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.EmployerUserDao;
import kodlama.io.HRMS.dataAccess.abstracts.EmployerUserUpdateCompanyInfoDao;
import kodlama.io.HRMS.entities.concretes.EmployerUser;
import kodlama.io.HRMS.entities.concretes.EmployerUserUpdateCompanyInfo;
import kodlama.io.HRMS.entities.dtos.EmployerUserUpdateCompanyInfoDto;

@Service
public class EmployerUserUpdateCompanyInfoManager implements EmployerUserUpdateCompanyInfoService{

	private EmployerUserUpdateCompanyInfoDao employerUserUpdateCompanyInfoDao;
	private DtoConverterService dtoConverterService;
	private EmployerUserDao employerUserDao;
	
	@Autowired
	public EmployerUserUpdateCompanyInfoManager(EmployerUserUpdateCompanyInfoDao employerUserUpdateCompanyInfoDao , DtoConverterService dtoConverterService , EmployerUserDao employerUserDao) {
		super();
		this.employerUserUpdateCompanyInfoDao = employerUserUpdateCompanyInfoDao;
		this.dtoConverterService = dtoConverterService;
		this.employerUserDao = employerUserDao;
	}

	@Override
	public DataResult<List<EmployerUserUpdateCompanyInfo>> getAll() {
		return new SuccessDataResult<List<EmployerUserUpdateCompanyInfo>>(this.employerUserUpdateCompanyInfoDao.findAll());
	}

	@Override
	public Result add(EmployerUserUpdateCompanyInfoDto employerUserUpdateCompanyInfoDto) {
		EmployerUserUpdateCompanyInfo employerUserUpdateCompanyInfo = (EmployerUserUpdateCompanyInfo) this.dtoConverterService.dtoClassConverter(employerUserUpdateCompanyInfoDto, EmployerUserUpdateCompanyInfo.class);
		employerUserUpdateCompanyInfo.setCreatedDate(LocalDate.now());
		
		this.employerUserUpdateCompanyInfoDao.save(employerUserUpdateCompanyInfo);
		
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public Result confirmChange(int EmployerUserUpdateCompanyInfoId, int employerUserId) {
		EmployerUserUpdateCompanyInfo employerUserUpdateCompanyInfo = employerUserUpdateCompanyInfoDao.getById(EmployerUserUpdateCompanyInfoId);
		employerUserUpdateCompanyInfo.setEmployerUser(this.employerUserDao.getById(employerUserId));
		employerUserUpdateCompanyInfo.setConfirmDate(LocalDate.now());
		employerUserUpdateCompanyInfo.setConfirmed(true);
		
		this.employerUserUpdateCompanyInfoDao.save(employerUserUpdateCompanyInfo);
		return new SuccessResult("Bilgiler Değiştirildi");
	}

	@Override
	public Result refuseChange(int EmployerUserUpdateCompanyInfoId, int employerUserId) {
		EmployerUserUpdateCompanyInfo employerUserUpdateCompanyInfo = employerUserUpdateCompanyInfoDao.getById(EmployerUserUpdateCompanyInfoId);
		employerUserUpdateCompanyInfo.setEmployerUser(this.employerUserDao.getById(employerUserId));
		
		this.employerUserUpdateCompanyInfoDao.save(employerUserUpdateCompanyInfo);
		return new SuccessResult("Bilgiler Değiştirilmedi");
	}

	@Override
	public DataResult<EmployerUserUpdateCompanyInfo> getById(int EmployerUserUpdateCompanyInfoId) {
		
		return new SuccessDataResult<EmployerUserUpdateCompanyInfo>(this.employerUserUpdateCompanyInfoDao.getById(EmployerUserUpdateCompanyInfoId));
	}

}
