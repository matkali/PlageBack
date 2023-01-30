package orsys.projet.mapper;

import java.util.List;

import orsys.projet.business.Locataire;
import orsys.projet.dto.LocataireDto;
import orsys.projet.dto.LocataireDtoEx;

public interface LocataireMapper {
	LocataireDto toDto(Locataire locataire);

	LocataireDtoEx toDtoEx(Locataire locataire);
	
	Locataire toEntity(LocataireDto locataireDto);
	
	List<LocataireDto> toDto(List<Locataire> locataires);

}
