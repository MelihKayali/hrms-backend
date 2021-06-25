package kodlama.io.HRMS.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceUpdateDto {
	private int id;
    private int resumeId;
    private String companyName;
    private int jobPositionId;
    private Date startedDate;
    private Date endedDate;
}
