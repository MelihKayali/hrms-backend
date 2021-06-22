package kodlama.io.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_confirm_job_advert")
@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
public class EmployeeConfirmJobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeUser employeeUser;
	
	@ManyToOne
	@JoinColumn(name="job_advert_id")
	private JobAdvert jobAdvert;
	
	@Column(name="confirm")
	private boolean confirm;
}
