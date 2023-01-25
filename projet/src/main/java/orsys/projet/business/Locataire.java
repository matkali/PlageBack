package orsys.projet.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Locataire extends Utilisateur{
	@NonNull
	@PastOrPresent
	private LocalDateTime dateHeureInscription;
	
	@ManyToOne
	private LienDeParente lienDeParente;
	
	@ManyToOne
	@NonNull
	private Pays pays;
	
	@OneToMany(mappedBy = "locataire", fetch = FetchType.EAGER)
	private List<Location> locations;
	
}
