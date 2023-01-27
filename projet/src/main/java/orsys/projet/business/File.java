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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="file")
@NoArgsConstructor
public class File {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=1, max=8, message="la rangée est comprise entre 1 et 8")
	private byte numero;

	@Min(value=0, message="Le prix doit être positif")
	private double prixJournalier;
	
	@JsonIgnore
	@OneToMany(mappedBy="file", fetch=FetchType.EAGER)
	private List<Parasol> parasols;
	

	public File(@Range(min = 1, max = 8, message = "la rangée est comprise entre 1 et 8") byte numero,
			@Min(value = 0, message = "Le prix doit être positif") double prixJournalier) {
		super();
		this.numero = numero;
		this.prixJournalier = prixJournalier;
	}
}
