package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Location;
import orsys.projet.dto.LocationDto;

@Mapper(componentModel = "spring")
public interface LocationMapper {
	LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
	
	LocationDto toDto(Location Location);

	Location toEntity(LocationDto LocationDto);

}
