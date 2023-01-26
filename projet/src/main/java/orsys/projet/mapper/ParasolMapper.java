package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Parasol;
import orsys.projet.dto.ParasolDto;

@Mapper(componentModel = "spring")
public interface ParasolMapper {
	ParasolMapper INSTANCE = Mappers.getMapper(ParasolMapper.class);

	ParasolDto toDto(Parasol Parasol);

	Parasol toEntity(ParasolDto ParasolDto);

}