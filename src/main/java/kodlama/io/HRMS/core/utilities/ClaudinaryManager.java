package kodlama.io.HRMS.core.utilities;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.ErrorDataResult;
import kodlama.io.HRMS.core.results.SuccessDataResult;

@Service
public class ClaudinaryManager implements CloudinaryService {
	
	private Cloudinary cloudinary;
	
	@Autowired
	public ClaudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> save(MultipartFile file) {
		 try{
	            Map cloudinaryUploader = cloudinary.uploader()
	            		.upload(file.getBytes()
	            ,ObjectUtils.emptyMap());
	            return new SuccessDataResult<Map>(cloudinaryUploader);
	        } 
		 
		 catch (IOException e){
	           e.printStackTrace();
	        }
	        return new ErrorDataResult<Map>();
	}

}
