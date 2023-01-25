package orsys.projet.service;

import java.util.List;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;

public interface FileService {
	File enregisterFile(File file);

	// File enregisterFile (FileDto file);
	File enregisterFile(byte numero, double prixJournalier);

	boolean supprimerFile(Long id);
	
	File modifierPrixFile(Long id, double prixJournalier);
	
	List<File> recupererFiles();
	
	File recupererFile(Long id);
	
	List<Parasol> recupererParasolsDeFile(File file);
}
