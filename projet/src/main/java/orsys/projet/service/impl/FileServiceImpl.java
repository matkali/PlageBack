package orsys.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;
import orsys.projet.dao.FileDao;
import orsys.projet.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	@Override
	public File enregisterFile(File file) {
		return fileDao.save(file);
	}

	@Override
	public File enregisterFile(byte numero, double prixJournalier) {
		return fileDao.save(new File(numero, prixJournalier));
	}

	@Override
	public File enregisterFile(byte numero, double prixJournalier, List<Parasol> parasols) {
		File file = new File(numero, prixJournalier);
		file.setParasols(parasols);
		return fileDao.save(file);
	}

	@Override
	public boolean supprimerFile(Long id) {
		if (fileDao.existsById(id)) {
			fileDao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public File modifierPrixFile(Long id, double prixJournalier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> recupererFiles() {
		return fileDao.findAll();
	}

}
