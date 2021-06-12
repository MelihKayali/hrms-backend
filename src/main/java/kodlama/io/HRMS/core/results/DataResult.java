package kodlama.io.HRMS.core.results;

public class DataResult<T> extends Result {
	private T data;
	
	public DataResult(T data ,boolean success, String message) {
		super(success, message);
		this.data = data;
	}
	
	public DataResult(T data ,boolean success) {
		super(success);
		this.data = data;
	}
	
	public T data() {
		return this.data;
	}
	
	

}
