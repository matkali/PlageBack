package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Pays;
import orsys.projet.dto.PaysDto;

@Mapper(componentModel = "spring")
public interface PaysMapper {
PaysMapper INSTANCE = Mappers.getMapper(PaysMapper.class);
	
	PaysDto toDto(Pays Pays);
	
	Pays toEntity(PaysDto PaysDto);

}
