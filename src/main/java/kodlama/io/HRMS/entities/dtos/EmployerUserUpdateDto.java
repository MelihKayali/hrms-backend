package kodlama.io.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUserUpdateDto {
	private int id;
	private String email;
	private String password;
	private String companyName;
	private String webAdress;
	private String telephoneNumber;
}
