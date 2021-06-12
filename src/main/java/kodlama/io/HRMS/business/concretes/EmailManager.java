package kodlama.io.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmailService;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.entities.concretes.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email gönderildi : " +user.getEmail());
	}

}
