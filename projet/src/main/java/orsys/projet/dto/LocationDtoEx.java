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

	public LocationDtoEx(Long id,@NonNull LocalDate dateDebut, @NonNull LocalDate dateFin, double montantAReglerEnEuros, LocataireDto locataire,
			String remarque, ConcessionnaireDto concessionnaire, StatutDto statut, byte nbParasols) {
		super(id,dateDebut, dateFin, montantAReglerEnEuros,locataire, remarque, concessionnaire, statut, nbParasols);
	}
	
	public LocationDtoEx(Long id,@NonNull LocalDate dateDebut, @NonNull LocalDate dateFin, double montantAReglerEnEuros, 
			String remarque, @NonNull ConcessionnaireDto concessionnaire, StatutDto statut, byte nbParasols, List<ParasolDto> parasolsList, LocataireDto locataire) {
		super(id,dateDebut, dateFin, montantAReglerEnEuros,locataire, remarque, concessionnaire, statut, nbParasols);
		this.parasols = parasolsList;
	}

}