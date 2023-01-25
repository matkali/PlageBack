package orsys.projet.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Statut;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDto {
	@NonNull
	private LocalDateTime dateHeureDebut;
	
	@NonNull
	private LocalDateTime dateHeureFin;
	
	private double montantAReglerEnEuros;
	
	@Column(length=500)
	private String remarque;
	
	private Concessionnaire concessionnaire;
	
	private Statut statut;
}
