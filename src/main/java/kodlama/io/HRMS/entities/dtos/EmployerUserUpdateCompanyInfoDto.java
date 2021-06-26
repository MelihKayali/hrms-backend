package kodlama.io.HRMS.entities.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUserUpdateCompanyInfoDto {
	@JsonIgnore
	private int id;
	private int employerUserId;
	private int employeeUserId;
}
