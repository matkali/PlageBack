package orsys.projet.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDto {
	@NonNull
	LocalDate dateDebut;
	
	@NonNull
	LocalDate dateFin;
	
	double montantAReglerEnEuros;
	
	@Column(length=500)
	String remarque;
	
}
