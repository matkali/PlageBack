package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Locataire;
import orsys.projet.dto.LocataireDto;

@Mapper(componentModel = "spring")
public interface LocataireMapper {
	
	LocataireMapper INSTANCE = Mappers.getMapper(LocataireMapper.class);
	
	LocataireDto toDto(Locataire locataire);
	
	Locataire toEntity(LocataireDto locataireDto);

}
