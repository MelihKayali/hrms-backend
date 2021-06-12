package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;

public interface UserService<T> {
	DataResult<List<T>> getAll();
	Result add(T user);
}
