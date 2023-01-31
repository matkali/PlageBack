package orsys.projet.service;

import java.time.LocalDate;
import java.util.List;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.business.Statut;
import orsys.projet.dto.LocationDto;

public interface LocationService {
	Location enregisterLocation(Location location);

	Location enregisterLocation(LocationDto location);

	Location enregisterLocation(LocalDate dateDebut, LocalDate dateFin, List<Parasol> parasols,
			Locataire locataire,Statut statut, Concessionnaire concessionnaire);

	Location enregisterLocation(LocalDate dateDebut, LocalDate dateFin, List<Parasol> parasols,
			Locataire locataire, Statut statut, Concessionnaire concessionnaire, String remarque);

	boolean supprimerLocation(Long id);
	
	Location recupererLocationParId(Long id);

	List<Location> recupererLocationParStatut(Statut statut);

	Location changerStatutLocation(Long id, Statut statut);

	Location changerParasolsLocation(Long id, List<Parasol> parasols);

	Location changerMontantLocation(Long id, double montant);
	
	List<Location> recupererLocation();
	
	List<Location> recupererLocationParClient(Locataire locataire);
	
	List<Location> recupererLocationParClientID(Long id);
}
