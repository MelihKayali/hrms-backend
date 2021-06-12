package kodlama.io.HRMS.core.results.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.HRMS.entities.concretes.JobAdvert;

@Service
public class CheckNullFieldManager implements CheckNullFieldService {

	@Override
	public Boolean checkNullFieldService(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		return false;
	}

}
