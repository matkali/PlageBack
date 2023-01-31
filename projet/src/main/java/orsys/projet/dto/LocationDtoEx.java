package orsys.projet.dto;

import java.time.LocalDate;
import java.util.List;

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
public class LocationDtoEx extends LocationDto {
	
	List<ParasolDto> parasols;

	public LocationDtoEx(@NonNull LocalDate dateDebut, @NonNull LocalDate dateFin, double montantAReglerEnEuros, LocataireDto locataire,
			String remarque, @NonNull ConcessionnaireDto concessionnaire, @NonNull StatutDto statut, byte nbParasols) {
		super(dateDebut, dateFin, montantAReglerEnEuros,locataire, remarque, concessionnaire, statut, nbParasols);
	}

}
