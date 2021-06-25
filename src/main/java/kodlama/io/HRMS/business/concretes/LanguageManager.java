package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.LanguageService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.LanguageDao;
import kodlama.io.HRMS.entities.concretes.Language;
import kodlama.io.HRMS.entities.dtos.LanguageDto;
import kodlama.io.HRMS.entities.dtos.LanguageUpdateDto;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao,DtoConverterService dtoConverterService) {
		super();
		this.languageDao = languageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(LanguageDto languageDto) {
		this.languageDao.save((Language) dtoConverterService.dtoClassConverter(languageDto, Language.class));
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<LanguageDto>> getAll() {
		return new SuccessDataResult<List<LanguageDto>>
		(this.dtoConverterService.dtoConverter(languageDao.findAll(),LanguageDto.class), "Data Listelendi");
	}

	@Override
	public Result updateLanguage(LanguageUpdateDto languageUpdateDto) {
		Language language = this.languageDao.getById(languageUpdateDto.getId());
		
		language.setLanguage(languageUpdateDto.getLanguage());
		language.setLangLevel(languageUpdateDto.getLangLavel());
		
		return new SuccessResult("Güncellendi");
	}

}
