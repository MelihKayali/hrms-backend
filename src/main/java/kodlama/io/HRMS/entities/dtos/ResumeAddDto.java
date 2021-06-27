package kodlama.io.HRMS.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAddDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private int candidateUserId;
	private String githubLink;
	private String linkedLink;
	private String photo;
	private String description;
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
