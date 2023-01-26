package orsys.projet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import orsys.projet.business.File;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.dao.LocationDao;
import orsys.projet.dao.ParasolDao;
import orsys.projet.dto.ParasolDto;
import orsys.projet.exception.ParasolExistantException;
import orsys.projet.exception.ParasolInexistantException;
import orsys.projet.service.ParasolService;

public class ParasolServiceImpl implements ParasolService {

	@Autowired
	private ParasolDao parasolDao;
	@Autowired 
	private LocationDao locationDao;

	@Override
	public Parasol enregisterParasol(Parasol parasol) {
		if (parasolDao.existsById(parasol.getId())) {
			throw new ParasolExistantException();
		}
		return parasolDao.save(parasol);
	}

	@Override
	public Parasol enregisterParasol(ParasolDto parasol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parasol enregisterParasol(byte numEmplacement, File file) {
		return enregisterParasol(new Parasol(numEmplacement,file));
	}

	@Override
	public boolean supprimerParasol(Long id) {
		if (parasolDao.existsById(id)) {
			parasolDao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Parasol ajouterLocationAParasol(Long id, Location location) {
		Parasol parasol=parasolDao.findById(id).orElse(null);
		if(parasol==null) {
			throw new ParasolInexistantException();
		} else {
			List<Location> locations = parasol.getLocations();
			if (parasol.getLocations()==null) {
				locations = new ArrayList<>();
			}
			locations.add(location);
			parasol.setLocations(locations);
		}
		return parasolDao.save(parasol);
	}

	@Override
	public List<Parasol> recupererParasol() {
		return parasolDao.findAll();
	}

}
