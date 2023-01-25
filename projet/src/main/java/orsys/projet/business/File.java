package orsys.projet.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
@Table(name="file")
public class File {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=1, max=8)
	private byte numero;
	
	private double prixJournalier;
	
	@OneToMany(mappedBy="file", fetch=FetchType.EAGER)
	private List<Parasol> parasols;
}
