package kodlama.io.HRMS.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDto {
	 @JsonIgnore
	    private int id;
	    private int employerId;
	    private int jobPositionId;
	    private int cityId;
	    private String advertDescription;
	    private int minSalary;
	    private int maxSalary;
	    private short openPosition;
	    private Date createdDate;
	    private Date deadline;
}
