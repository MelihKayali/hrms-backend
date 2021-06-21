package kodlama.io.HRMS.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeConfirmJobAdvertDto {
	@JsonIgnore
	private int id;
	private int employeeUserId;
	private int jobAdvertId;
}
