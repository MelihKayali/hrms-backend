package kodlama.io.HRMS.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_user_update_company_info")
public class EmployerUserUpdateCompanyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="employer_user_id")
	private EmployerUser employerUser;
	
	@ManyToOne
	@JoinColumn(name="confirm_employee")
	private EmployeeUser employeeUser;
	
	@Column(name="confirm_date")
	private LocalDate confirmDate;
	
	@Column(name="isConfirmed")
	private boolean isConfirmed = false;
	
	@Column(name="created_date")
	private LocalDate createdDate;
}
