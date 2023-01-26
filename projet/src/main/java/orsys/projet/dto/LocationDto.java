package orsys.projet.dto;

import java.time.LocalDateTime;
import java.util.List;

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
	LocalDateTime dateHeureDebut;
	
	@NonNull
	LocalDateTime dateHeureFin;
	
	double montantAReglerEnEuros;
	
	@Column(length=500)
	String remarque;
	
}
