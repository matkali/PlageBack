package orsys.projet.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDto {
	
	
	@NonNull
	LocalDate dateDebut;

	@NonNull
	LocalDate dateFin;

	double montantAReglerEnEuros;

	@Column(length = 500)
	String remarque;

	@NonNull
	@ManyToOne
	ConcessionnaireDto concessionnaire;

	@NonNull
	@ManyToOne
	StatutDto statut;

	byte nbParasols;

}
