package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.File;
import orsys.projet.dto.FileDto;

@Mapper(componentModel = "spring")
public interface FileMapper {
FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);
	
	FileDto toDto(File File);
	
	File toEntity(FileDto FileDto);

}