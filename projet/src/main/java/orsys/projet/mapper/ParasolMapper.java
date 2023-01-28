package orsys.projet.mapper;

import java.time.LocalDate;

import orsys.projet.business.Parasol;
import orsys.projet.dto.ParasolDto;

public interface ParasolMapper {
	ParasolDto toDto(Parasol parasol, LocalDate dateDeb, LocalDate dateFin);
	
	Parasol toEntity(ParasolDto parasolDto);
}