package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateUser;

public interface CandidateUserService {
	DataResult<List<CandidateUser>> getAll();
	Result add(CandidateUser candidateUser);
}
