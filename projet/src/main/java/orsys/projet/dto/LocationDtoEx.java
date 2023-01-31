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
	@NonNull
	LocataireDto locataire;

	@NonNull
	List<ParasolDto> parasols;

	public LocationDtoEx(@NonNull LocalDate dateDebut, @NonNull LocalDate dateFin, double montantAReglerEnEuros,
			String remarque, @NonNull ConcessionnaireDto concessionnaire, @NonNull StatutDto statut, byte nbParasols, LocataireDto locataire) {
		super(dateDebut, dateFin, montantAReglerEnEuros, remarque, concessionnaire, statut, nbParasols);
	}

}
