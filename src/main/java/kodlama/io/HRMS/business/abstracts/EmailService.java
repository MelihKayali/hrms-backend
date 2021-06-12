package kodlama.io.HRMS.business.abstracts;

import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.User;

public interface EmailService {
	Result sendEmail(User user);
}
