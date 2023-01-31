package orsys.projet.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.business.Statut;
import orsys.projet.dao.LocationDao;
import orsys.projet.dto.LocationDto;
import orsys.projet.exception.LocationExistanteException;
import orsys.projet.exception.LocationInexistanteException;
import orsys.projet.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDao locationDao;

	@Override
	public Location enregisterLocation(Location location) {
//		if (locationDao.existsById(location.getId())) {
//			throw new LocationExistanteException();
//		} else {
		return locationDao.save(location);
	}

	@Override
	public Location enregisterLocation(LocationDto location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location enregisterLocation(LocalDate dateDebut, LocalDate dateFin, List<Parasol> parasols,
			Locataire locataire, Statut statut, Concessionnaire concessionnaire) {
		return enregisterLocation(new Location(dateDebut, dateFin, locataire, concessionnaire,statut, parasols));
	}

	@Override
	public Location enregisterLocation(LocalDate dateDebut, LocalDate dateFin, List<Parasol> parasols,
			Locataire locataire, Statut statut, Concessionnaire concessionnaire, String remarque) {
		Location location=new Location(dateDebut, dateFin, locataire, concessionnaire, statut, parasols);
		location.setRemarque(remarque);
		return enregisterLocation(location);
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

	@Override
	public List<Location> recupererLocation() {
		return locationDao.findAll();
	}

	@Override
	public List<Location> recupererLocationParClient(Locataire locataire) {
		return locationDao.findLocationByLocataire(locataire);
	}

	@Override
	public Location recupererLocationParId(Long id) {
		return locationDao.findById(id).orElse(null);
	}

	@Override
	public List<Location> recupererLocationParClientID(Long id) {
		return locationDao.findLocationByLocataireId(id);
	}

}
