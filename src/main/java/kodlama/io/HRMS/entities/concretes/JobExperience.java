package kodlama.io.HRMS.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resume_job_exp")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotBlank(message="Bos Geçilemez")
	@Column(name="company_name")
	private String companyName;
	
	@ManyToOne(targetEntity =JobPosition.class)
	@JoinColumn(name="position_id",referencedColumnName = "id")
	private JobPosition jobPosition;
	
	@Column(name="started_date")
	private Date startedDate;
	
	//@NotBlank(message="Bos Geçilemez")
	@Column(name="ended_date")
	private Date endedDate;
	
	//@NotBlank(message="Bos Geçilemez")
	@Column(name="created_date")
	private Date createdDate;
}
