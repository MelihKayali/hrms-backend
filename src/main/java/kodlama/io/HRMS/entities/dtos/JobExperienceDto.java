package kodlama.io.HRMS.entities.dtos;

import java.util.Date;

import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	private String companyName;
	@Past(message="Başlangıç tarihi bugünden sonra olamaz")
	private Date startedDate;
	private Date endedDate;
	private int jobPositionId;
}
