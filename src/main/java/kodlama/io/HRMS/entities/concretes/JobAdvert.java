package kodlama.io.HRMS.entities.concretes;

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
@Table(name="job_adverts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="employer_id")
//	private int employerId;
//	
//	@Column(name="position_id")
//	private int possitionId;
//	
//	@Column(name="city_id")
//	private int cityId;
	
	@Column(name="job_descrition")
	private String jobDescrition;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="open_position")
	private short openPosition;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="is_active")
	private boolean isActive = false;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private EmployerUser employerUser;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
}
