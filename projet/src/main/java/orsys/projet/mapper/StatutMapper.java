package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Statut;
import orsys.projet.dto.StatutDto;

@Mapper(componentModel = "spring")
public interface StatutMapper {
	StatutMapper INSTANCE = Mappers.getMapper(StatutMapper.class);

	StatutDto toDto(Statut Statut);

	Statut toEntity(StatutDto StatutDto);

}
