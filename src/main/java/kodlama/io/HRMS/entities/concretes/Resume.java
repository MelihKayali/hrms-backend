package kodlama.io.HRMS.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = CandidateUser.class)
	@JoinColumn(name="candidate_id",referencedColumnName = "id", nullable = false)
	private  CandidateUser candidateId;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linked_link")
	private String linkedLink;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "resume")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	 
	
}
