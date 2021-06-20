package kodlama.io.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.LanguageService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Language;
import kodlama.io.HRMS.entities.dtos.LanguageDto;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	 @GetMapping("/getall")
	    public DataResult<List<LanguageDto>> getAll(){
	        return this.languageService.getAll();
	    }
	    
	    @PostMapping("/add")
	    public Result add(@Valid @RequestBody LanguageDto languageDto) {
	    	return this.languageService.add(languageDto);
	    }
}
