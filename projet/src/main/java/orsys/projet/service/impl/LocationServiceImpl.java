package orsys.projet.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.business.Statut;
import orsys.projet.dao.LocationDao;
import orsys.projet.dto.LocationDto;
import orsys.projet.exception.LocationInexistanteException;
import orsys.projet.service.LocationService;

public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDao locationDao;

	@Override
	public Location enregisterLocation(Location location) {
		return locationDao.save(location);
	}

	@Override
	public Location enregisterLocation(LocationDto location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location enregisterLocation(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, List<Parasol> parasols,
			Locataire locataire, Concessionnaire concessionnaire) {
		return locationDao.save(new Location(dateHeureDebut, dateHeureFin, locataire, concessionnaire, parasols));
	}

	@Override
	public Location enregisterLocation(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, List<Parasol> parasols,
			Locataire locataire, Concessionnaire concessionnaire, String remarque) {
		Location location=new Location(dateHeureDebut, dateHeureFin, locataire, concessionnaire, parasols);
		location.setRemarque(remarque);
		return locationDao.save(location);
	}

	@Override
	public boolean supprimerLocation(Long id) {
		if (locationDao.existsById(id)) {
			locationDao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Location> recupererLocationParStatut(Statut statut) {
		return locationDao.findLocationByStatut(statut);
	}

	@Override
	public Location changerStatutLocation(Long id, Statut statut) {
		Location location=locationDao.findById(id).orElse(null);
		if(location==null) {
			throw new LocationInexistanteException();
		}
		location.setStatut(statut);
		return locationDao.save(location);
	}

	@Override
	public Location changerParasolsLocation(Long id, List<Parasol> parasols) {
		Location location=locationDao.findById(id).orElse(null);
		if(location==null) {
			throw new LocationInexistanteException();
		}
		location.setParasols(parasols);
		return locationDao.save(location);
	}

	@Override
	public Location changerMontantLocation(Long id, double montant) {
		Location location=locationDao.findById(id).orElse(null);
		if(location==null) {
			throw new LocationInexistanteException();
		}
		location.setMontantAReglerEnEuros(montant);
		return locationDao.save(location);
	}

}
