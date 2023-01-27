package orsys.projet.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="parasol")
public class Parasol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=-1, max=9, message="Il y a {max+1} parasols par file")
	private byte numEmplacement;
	
	@NonNull
	@ManyToOne
	private File file;
	
	@JsonIgnore
	@ManyToMany(mappedBy="parasols")
	private List<Location> locations;

	public Parasol(@Range(min = -1, max = 9, message = "Il y a {max+1} parasols par file") byte numEmplacement,
			@NonNull File file) {
		super();
		this.numEmplacement = numEmplacement;
		this.file = file;
	}
	
	
	
}
