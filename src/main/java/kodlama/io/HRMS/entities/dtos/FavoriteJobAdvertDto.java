package kodlama.io.HRMS.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteJobAdvertDto {
	@JsonIgnore
	private int id;
	private int jobAdvertId;
	private int candidateUserId;
	private boolean favoriteJobAdvert;
}
