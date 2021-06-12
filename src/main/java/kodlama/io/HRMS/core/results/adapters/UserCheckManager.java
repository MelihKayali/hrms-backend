package kodlama.io.HRMS.core.results.adapters;

import org.springframework.stereotype.Service;

@Service
public class UserCheckManager implements UserCheckService {

	@Override
	public Boolean checkRealPerson(String identityNumber, String firstName, String lastName) {
		return true;
	}

}
