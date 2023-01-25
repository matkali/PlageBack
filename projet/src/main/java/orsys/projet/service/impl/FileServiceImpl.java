package orsys.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;
import orsys.projet.dao.FileDao;
import orsys.projet.dao.ParasolDao;
import orsys.projet.exception.FileInexistanteException;
import orsys.projet.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;
	@Autowired
	private ParasolDao parasolDao;

	@Override
	public File enregisterFile(File file) {
		return fileDao.save(file);
	}

	@Override
	public File enregisterFile(byte numero, double prixJournalier) {
		return fileDao.save(new File(numero, prixJournalier));
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
	public File modifierPrixFile(Long id, double prixJournalier) throws FileInexistanteException{
		File file = fileDao.findById(id).orElse(null);
		if(file==null) {
			throw new FileInexistanteException();
		}
		return file;
	}

	@Override
	public List<File> recupererFiles() {
		return fileDao.findAll();
	}

	@Override
	public File recupererFile(Long id) {
		File file = fileDao.findById(id).orElse(null);
		if (file==null) {
			throw new FileInexistanteException();
		}
		file.setParasols(recupererParasolsDeFile(file));
		return file;
	}

	@Override
	public List<Parasol> recupererParasolsDeFile(File file) {
		return parasolDao.findByFile(file);
	}

}
