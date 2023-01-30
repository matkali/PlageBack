package orsys.projet.mapper;

import java.util.List;

import orsys.projet.business.Location;
import orsys.projet.dto.LocationDto;
import orsys.projet.dto.LocationDtoEx;


public interface LocationMapper {
	LocationDto toDto(Location location);
	
	LocationDtoEx toDtoEx(Location location);

	Location toEntity(LocationDto locationDto);
	
	List<LocationDto> toDto(List<Location> locations);
}
