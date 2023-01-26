package orsys.projet.service;

import java.time.LocalDateTime;
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

	Location enregisterLocation(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, List<Parasol> parasols,
			Locataire locataire, Concessionnaire concessionnaire);

	Location enregisterLocation(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, List<Parasol> parasols,
			Locataire locataire, Concessionnaire concessionnaire, String remarque);

	boolean supprimerLocation(Long id);

	List<Location> recupererLocationParStatut(Statut statut);

	Location changerStatutLocation(Long id, Statut statut);

	Location changerParasolsLocation(Long id, List<Parasol> parasols);

	Location changerMontantLocation(Long id, double montant);
	
	List<Location> recupererLocation();
	
	List<Location> recupererLocationParClient(Locataire locataire);
}
