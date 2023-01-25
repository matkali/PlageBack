package orsys.projet.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.business.Statut;
import orsys.projet.dto.LocationDto;
import orsys.projet.service.LocationService;

public class LocationServiceImpl implements LocationService {

	@Override
	public Location enregisterLocation(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location enregisterLocation(LocationDto location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location enregisterLocation(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, List<Parasol> parasols,
			Locataire locataire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location enregisterLocation(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, List<Parasol> parasols,
			Locataire locataire, String remarque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimerLocation(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Location> recupererLocationParStatut(Statut statut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location changerStatutLocation(Long id, Statut statut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location changerParasolsLocation(Long id, List<Parasol> parasols) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location changerMontantLocation(Long id, double montant) {
		// TODO Auto-generated method stub
		return null;
	}

}
