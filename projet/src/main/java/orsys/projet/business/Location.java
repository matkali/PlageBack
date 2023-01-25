package orsys.projet.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private LocalDateTime dateHeureDebut;
	
	@NonNull
	private LocalDateTime dateHeureFin;
	
	private double montantAReglerEnEuros;
	
	@Column(length=500)
	private String remarque;
	
	@ManyToOne
	private Locataire locataire;
	
	@ManyToOne
	private Concessionnaire concessionnaire;
	
	@ManyToOne
	private Statut statut;
	
	@ManyToMany(mappedBy="locations")
	private List<Parasol> parasols;
}
