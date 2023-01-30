package orsys.projet.mapper;

import orsys.projet.business.Location;
import orsys.projet.dto.LocationDto;

public interface LocationMapper {
	LocationDto toDto(Location Location);

	Location toEntity(LocationDto LocationDto);

}
