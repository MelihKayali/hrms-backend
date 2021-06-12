package kodlama.io.HRMS.business.concretes.helper;

import java.util.List;

import kodlama.io.HRMS.core.results.ErrorResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessResult;

public class UserCheckHelper {
	public static Result checkResult(List<Result> result) {
		StringBuilder message = new StringBuilder();
		
		int counter = 0;
		
		for (Result result2 : result) {
			if(result != null) {
				message.append(result.get(counter).isSuccess());
				counter++;
			}
		}
		
		if(counter>0) {
			return new ErrorResult(message.toString());
		}
		
		return new SuccessResult();
	}
}
