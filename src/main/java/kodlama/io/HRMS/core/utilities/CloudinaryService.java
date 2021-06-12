package kodlama.io.HRMS.core.utilities;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.core.results.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);
}
