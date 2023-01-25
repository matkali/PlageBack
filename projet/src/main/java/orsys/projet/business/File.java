package orsys.projet.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name="file")
public class File {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Range(min=1, max=8, message="la rangée est comprise entre 1 et 8")
	private byte numero;
	
	@NonNull
	@Min(value=0, message="Le prix doit être positif")
	private double prixJournalier;
	
	@OneToMany(mappedBy="file", fetch=FetchType.EAGER)
	private List<Parasol> parasols;
}
