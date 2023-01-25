package orsys.projet.service;

import java.util.List;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;

public interface FileService {
	File enregisterFile(File file);

	// File enregisterFile (FileDto file);
	File enregisterFile(byte numero, double prixJournalier);

	File enregisterFile(byte numero, double prixJournalier, List<Parasol> parasols);

	boolean supprimerFile(Long id);
	
	File ajouterParasolAFile(Parasol parasol);
	
	File supprimerParasolDeFile(Parasol parasol);
	
	File modifierPrixFile(double prixJournalier);
	
	List<File> recupererFiles();
}
