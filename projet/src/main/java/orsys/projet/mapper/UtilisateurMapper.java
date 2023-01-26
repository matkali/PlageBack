package orsys.projet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import orsys.projet.business.Utilisateur;
import orsys.projet.dto.UtilisateurDto;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

	UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

	UtilisateurDto toDto(Utilisateur utilisateur);

//	Utilisateur toEntity(UtilisateurDto utilisateurDto);

}
