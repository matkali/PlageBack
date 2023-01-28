package orsys.projet.service;

import java.time.LocalDate;
import java.util.List;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;
import orsys.projet.dto.FileDto;

public interface FileService {
	File enregisterFile(File file);

	// File enregisterFile (FileDto file);
	File enregisterFile(byte numero, double prixJournalier);

	boolean supprimerFile(Long id);
	
	File modifierPrixFile(Long id, double prixJournalier);
	
	List<File> recupererFiles();
	
	File recupererFile(Long id);
	
	List<Parasol> recupererParasolsDeFile(File file);
	
	List<FileDto> recupererFilesInfo(LocalDate dateDeb, LocalDate dateFin);
}
