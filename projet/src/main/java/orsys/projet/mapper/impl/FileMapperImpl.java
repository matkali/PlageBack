package orsys.projet.mapper.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;
import orsys.projet.dto.FileDto;
import orsys.projet.dto.ParasolDto;
import orsys.projet.mapper.FileMapper;
import orsys.projet.mapper.ParasolMapper;

public class FileMapperImpl implements FileMapper {

	@Override
	public FileDto toDto(File file, LocalDate dateDeb, LocalDate dateFin) {
		ParasolMapper parasolMapper = new ParasolMapperImpl();
		List<Parasol> parasols = file.getParasols();
		List<ParasolDto> parasolDtos = new ArrayList<>();
		for (Parasol parasol : parasols) {
			parasolDtos.add(parasolMapper.toDto(parasol, dateDeb, dateFin));
		}
		Collections.sort(parasolDtos, (a, b) -> a.getNumEmplacement() < b.getNumEmplacement() ? -1
				: a.getNumEmplacement() == b.getNumEmplacement() ? 0 : 1);
		byte chemin = (byte) 4; // Le chemin est après le 5ème parasol par défaut
		return new FileDto(file.getNumero(), chemin, parasolDtos, file.getPrixJournalier(), dateDeb, dateFin);
	}

	@Override
	public File toEntity(FileDto FileDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
