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
	
	Parasol ajouterLocationAParasol(Long id, Location location);
	
	List<Parasol> recupererParasol();
	
	Parasol recupererParasolParNumEtFile(byte numEmplacement,File file);
}
