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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
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
	
	@NonNull
	@ManyToOne
	private Locataire locataire;
	
	@NonNull
	@ManyToOne
	private Concessionnaire concessionnaire;
	
	@NonNull
	@ManyToOne
	private Statut statut;
	
	@NonNull
	@ManyToMany
	private List<Parasol> parasols;
}
