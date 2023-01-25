package orsys.projet.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Locataire extends Utilisateur{
	private LocalDateTime dateHeureInscription;
	
	@ManyToOne
	private LienDeParente lienDeParente;
	
	@ManyToOne
	private Pays pays;
	
	@OneToMany(mappedBy = "locataire", fetch = FetchType.EAGER)
	private List<Location> locations;
	
}
