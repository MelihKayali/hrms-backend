package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateUserService;
import kodlama.io.HRMS.business.abstracts.EmailService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.results.adapters.UserCheckService;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateUserDao;
import kodlama.io.HRMS.entities.concretes.CandidateUser;
@Service
public class CandidateUserManager implements CandidateUserService {

	private CandidateUserDao candidateUserDao;
	private EmailService emailService;
	private UserCheckService userCheckService;


	@Autowired
	public CandidateUserManager(CandidateUserDao candidateUserDao, EmailService emailService,
			UserCheckService userCheckService) {
		super();
		this.candidateUserDao = candidateUserDao;
		this.emailService = emailService;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<List<CandidateUser>> getAll() {
		return new SuccessDataResult<List<CandidateUser>>(this.candidateUserDao.findAll());
	}

	@Override
	public Result add(CandidateUser candidateUser) {
	var checkEmail = this.candidateUserDao.existsByEmail(candidateUser.getEmail());
	var checkIdentityNumber = this.candidateUserDao.existsByIdentityNumber(candidateUser.getIdentityNumber());
	var checkRealUser = this.userCheckService.checkRealPerson(candidateUser.getIdentityNumber(),
				candidateUser.getFirstName(), candidateUser.getLastName());

	if (checkEmail || checkIdentityNumber || checkRealUser) {
			String message = "";

			if (checkEmail) {
				message += "Bu email sistemde kayıtlı";
				
			}	
			if(checkIdentityNumber) {
			message += "Bu Kimlik numarası sistemde kayıtlı";
				
			}
			if(checkRealUser) {
				message += "Gerçek kullanıcı değil";
			}
			return new ErrorResult(message);
	}
		
		this.candidateUserDao.save(candidateUser);
		return new SuccessResult(this.emailService.sendEmail(candidateUser).getMessage());
	}

}
