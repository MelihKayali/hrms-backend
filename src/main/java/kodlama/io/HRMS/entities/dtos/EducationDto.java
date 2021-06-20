	package kodlama.io.HRMS.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	private String schoolName;
	@JsonProperty(access = Access.WRITE_ONLY)
	private int graduateId;
	private String graduateDescription;
	private String schoolDepartment;
	private Date startedDate;
	private Date endedDate;
	private Date createdDate;
	
}
