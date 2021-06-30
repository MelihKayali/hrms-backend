package kodlama.io.HRMS.core.Business;

import kodlama.io.HRMS.core.results.Result;

public class BusinessEngine {
	 public static Result run(Result ...logics){
	        for (Result logic : logics){
	            if (!logic.isSuccess()){
	                return logic;
	            }
	        }

	        return null;
	    }
}
