package kodlama.io.HRMS.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_users")
public class CandidateUser extends User{
	
	@Column(name="id")
	private int id;
	
	@NotBlank(message="İsim alanı boş bırakılamaz")
	@Size(min = 3, message="İsim alanında en az 3 karakter kullanmamız gerekiyor")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Soyisim alanı boş bırakılamaz")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="TC Kimlik Numarası alanı boş bırakılamaz")
	@Size(min = 11, max = 11, message="TC Kimlik hane no 11 karakterli olmalıdır")
	@Column(name="identity_number")
	private String identityNumber;
	
	//@NotBlank(message="Doğum yılı alanı boş olamaz")
	@Column(name="date_of_birth")
	private Date datOfBirth;
}
