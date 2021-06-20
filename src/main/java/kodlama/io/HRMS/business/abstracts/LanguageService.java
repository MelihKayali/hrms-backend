package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.dtos.LanguageDto;

public interface LanguageService {
	Result add(LanguageDto languageDto);
	DataResult<List<LanguageDto>> getAll();

}
