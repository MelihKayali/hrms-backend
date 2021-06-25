package kodlama.io.HRMS.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationUpdateDto {
	private int id;
    private int resumeId;
    private int graduateId;
    private String schoolName;
    private String schoolDepartment;
    private Date startedDate;
    private Date endedDate;
}
