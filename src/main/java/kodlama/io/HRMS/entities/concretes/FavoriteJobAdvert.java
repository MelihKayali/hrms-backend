package kodlama.io.HRMS.entities.concretes;

import java.time.LocalDate;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="favorite_job_advert")
public class FavoriteJobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="job_advert_id")
	private JobAdvert jobAdvert;
	
	@ManyToOne
	@JoinColumn(name="candidate_user_id")
	private CandidateUser candidateUser;
	
	@Column(name="favorite_job_advert")
	private boolean favoriteJobAdvert = false;
	
    @Column(name = "created_date")
    private LocalDate createdDate;
    
}
