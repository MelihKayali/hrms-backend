package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.TechnologyService;
import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.core.results.SuccessDataResult;
import kodlama.io.HRMS.core.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.DtoConverterService;
import kodlama.io.HRMS.dataAccess.abstracts.TechnologyDao;
import kodlama.io.HRMS.entities.concretes.Technology;
import kodlama.io.HRMS.entities.dtos.TechnologyDto;
import kodlama.io.HRMS.entities.dtos.TechnologyUpdateDto;

@Service
public class TechnologyManager implements TechnologyService {
	
	private TechnologyDao technologyDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao , DtoConverterService dtoConverterService ) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		this.technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Kayıt başarılı");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll());
	}

	@Override
	public Result updateTechnology(TechnologyUpdateDto technologyUpdateDto) {
		Technology technology = this.technologyDao.getById(technologyUpdateDto.getId());
		
		technology.setDescription(technologyUpdateDto.getDescription());
		
		return new SuccessResult("Güncellendi");
	}

}
