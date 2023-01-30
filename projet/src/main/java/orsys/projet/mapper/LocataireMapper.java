package orsys.projet.mapper;

import orsys.projet.business.Locataire;
import orsys.projet.dto.LocataireDto;

public interface LocataireMapper {
	LocataireDto toDto(Locataire locataire);

	Locataire toEntity(LocataireDto locataireDto);

}
