package orsys.projet.service;

import java.util.List;

import orsys.projet.business.File;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.dto.ParasolDto;

public interface ParasolService {
	Parasol enregisterParasol(Parasol parasol);

	Parasol enregisterParasol(ParasolDto parasol);
	
	Parasol enregisterParasol(byte numEmplacement, File file);

	boolean supprimerParasol(Long id);
	
	Parasol ajouterLocationAParasol(Location location);
	
	Parasol changerNumEmplacementParasol(byte numEmplacement);
	
	Parasol changerFileParasol(File file);
	
	Parasol changerPositionParasol(byte numEmplacement, File file);
	
	List<Parasol> recupererParasol();
}
