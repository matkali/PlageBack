package orsys.projet.mapper;

import java.time.LocalDate;

import orsys.projet.business.File;
import orsys.projet.dto.FileDto;

public interface FileMapper {	
	FileDto toDto(File file, LocalDate dateDeb, LocalDate dateFin);
	
	File toEntity(FileDto fileDto);

}