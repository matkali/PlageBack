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

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name="parasol")
public class Parasol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Range(min=-1, max=36, message="Il y a 36 parasols par file")
	private byte numEmplacement;
	
	@NonNull
	@ManyToOne
	private File file;
	
	@ManyToMany
	private List<Location> locations;
	
	
}
