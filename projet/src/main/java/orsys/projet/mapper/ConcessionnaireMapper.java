package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Concessionnaire;
import orsys.projet.dto.ConcessionnaireDto;

@Mapper(componentModel = "spring")
public interface ConcessionnaireMapper {
	
	ConcessionnaireMapper INSTANCE = Mappers.getMapper(ConcessionnaireMapper.class);
	
	ConcessionnaireDto toDto(Concessionnaire concessionnaire);
	
	Concessionnaire toEntity(ConcessionnaireDto concessionnaireDto);

}
