package orsys.projet.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.dto.LocataireDto;
import orsys.projet.dto.LocataireDtoEx;
import orsys.projet.dto.LocationDto;
import orsys.projet.dto.UtilisateurDto;
import orsys.projet.mapper.LocataireMapper;
import orsys.projet.mapper.LocationMapper;
import orsys.projet.mapper.PaysMapper;
import orsys.projet.mapper.PaysMapperImpl;

public class LocataireMapperImpl implements LocataireMapper {
	PaysMapper paysMapper = new PaysMapperImpl();
	LocationMapper locationMapper = new LocationMapperImpl();

	@Override
	public LocataireDto toDto(Locataire locataire) {
		LocataireDto locataireDto = (LocataireDto) new UtilisateurDto(locataire.getId(),locataire.getEmail());
		locataireDto.setRole("locataire");
		locataireDto.setDateHeureInscription(locataire.getDateHeureInscription());
		locataireDto.setLienDeParente(locataire.getLienDeParente());
		locataireDto.setPays(paysMapper.toDto(locataire.getPays()));
		locataireDto.setValide(false);
		for(Location location:locataire.getLocations()) {
			if(location.getStatut().getNom()=="Acceptée") {
				locataireDto.setValide(true);
			}
		}
		return locataireDto;
	}

	@Override
	public LocataireDtoEx toDtoEx(Locataire locataire) {
		LocataireDtoEx locataireDtoEx = (LocataireDtoEx) toDto(locataire);
		List<LocationDto> locations =new ArrayList<>();
		for(Location location:locataire.getLocations()) {
			locations.add(locationMapper.toDto(location));
		}
		locataireDtoEx.setLocations(locations);
		return locataireDtoEx;
	}

	@Override
	public Locataire toEntity(LocataireDto locataireDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
