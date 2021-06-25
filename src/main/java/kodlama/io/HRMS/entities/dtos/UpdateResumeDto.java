package kodlama.io.HRMS.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResumeDto {
	private int id;
	private String githubLink;
	private String linkedLink;
	private String photo;
	private String description;
}
