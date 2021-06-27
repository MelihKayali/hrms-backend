package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.core.results.DataResult;
import kodlama.io.HRMS.core.results.Result;
import kodlama.io.HRMS.entities.concretes.Language;
import kodlama.io.HRMS.entities.concretes.Resume;
import kodlama.io.HRMS.entities.dtos.ResumeAddDto;
import kodlama.io.HRMS.entities.dtos.ResumeGetDto;
import kodlama.io.HRMS.entities.dtos.ResumeUpdateDto;
import kodlama.io.HRMS.entities.dtos.UpdateResumeDto;

public interface ResumeService {
	Result add(ResumeAddDto resumeAddDto);
	DataResult<List<Resume>> getAll();
	DataResult<List<ResumeGetDto>> findAllByCandidateId(int id);
	Result addPicture(MultipartFile file, int resumeId);
	 Result update(ResumeUpdateDto resumeUpdateDto);
	 Result updateUpdatedDate(int resumeId);
	Result updateResume(UpdateResumeDto updateResumeDto);
	
	
	//DataResult<List<UpdateResumeDto>> updateResume(int ResumeId , int LanguageId , int EducationId ,  int JobExperienceId);
	
	
	//Result confirmJobAdvert(int jobAdvertId , int  employeeUserId ,  int employeeConfirmJobAdvertId);
}
