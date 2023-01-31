package orsys.projet.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.emory.mathcs.backport.java.util.Collections;
import orsys.projet.business.File;
import orsys.projet.business.Parasol;
import orsys.projet.dao.FileDao;
import orsys.projet.dao.ParasolDao;
import orsys.projet.dto.FileDto;
import orsys.projet.exception.FileExistanteException;
import orsys.projet.exception.FileInexistanteException;
import orsys.projet.mapper.FileMapper;
import orsys.projet.mapper.impl.FileMapperImpl;
import orsys.projet.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;
	@Autowired
	private ParasolDao parasolDao;

	@Override
	public File enregisterFile(File file) {
		if (fileDao.existsById(file.getId())) {
			throw new FileExistanteException();
		}
		return fileDao.save(file);
	}

	@Override
	public File enregisterFile(byte numero, double prixJournalier) {
		return enregisterFile(new File(numero, prixJournalier));
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
		file.setPrixJournalier(prixJournalier);
		return fileDao.save(file);
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

	@Override
	public List<FileDto> recupererFilesInfo(LocalDate dateDeb, LocalDate dateFin) {
		FileMapper fileMapper = new FileMapperImpl()
;		List<File> files = fileDao.findAll();
		List<FileDto> fileDtos = new ArrayList<>();
		for(File file:files) {
			fileDtos.add(fileMapper.toDto(file, dateDeb, dateFin));
		}
		Collections.sort(fileDtos, (a, b) -> ((FileDto) a).getNumero() < ((FileDto) b).getNumero() ? -1
				: ((FileDto) a).getNumero() == ((FileDto) b).getNumero() ? 0 : 1);
		return fileDtos;
	}

	@Override
	public File recupererFile(byte num) {
		return fileDao.findByNumero(num);
	}

}
