package orsys.projet.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.dto.LocataireDto;
import orsys.projet.dto.LocataireDtoEx;
import orsys.projet.dto.UtilisateurDto;
import orsys.projet.mapper.LocataireMapper;
import orsys.projet.mapper.LocationMapper;
import orsys.projet.mapper.PaysMapper;
import orsys.projet.mapper.PaysMapperImpl;

public class LocataireMapperImpl implements LocataireMapper {
	private final PaysMapper paysMapper = new PaysMapperImpl();
	private final LocationMapper locationMapper = new LocationMapperImpl();

	@Override
	public LocataireDto toDto(Locataire locataire) {
		LocataireDto locataireDto = new LocataireDto(locataire.getId(), locataire.getEmail(),
				"locataire");
		locataireDto.setDateHeureInscription(locataire.getDateHeureInscription());
		locataireDto.setLienDeParenteString(locataire.getLienDeParente().getNom());
		locataireDto.setCoefficient(locataire.getLienDeParente().getCoefficient());
		locataireDto.setPaysString(locataire.getPays().getNom());
		locataireDto.setNom(locataire.getNom());
		locataireDto.setPrenom(locataire.getPrenom());
		locataireDto.setValide(false);
		for (Location location : locataire.getLocations()) {
			if (location.getStatut().getNom().equals("Acceptée")) {
				locataireDto.setValide(true);
			}
		}
		return locataireDto;
	}

	@Override
	public LocataireDtoEx toDtoEx(Locataire locataire) {
		LocataireDtoEx locataireDtoEx = new LocataireDtoEx(locataire.getId(), locataire.getEmail(),
				"locataire");
		locataireDtoEx.setDateHeureInscription(locataire.getDateHeureInscription());
		locataireDtoEx.setLienDeParente(locataire.getLienDeParente());
		locataireDtoEx.setPays(paysMapper.toDto(locataire.getPays()));
		locataireDtoEx.setValide(false);
		for (Location location : locataire.getLocations()) {
			if (location.getStatut().getNom().equals("Acceptée")) {
				locataireDtoEx.setValide(true);
			}
		}
		locataireDtoEx.setLocations(locationMapper.toDto(locataire.getLocations()));
		return locataireDtoEx;
	}

	@Override
	public Locataire toEntity(LocataireDto locataireDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocataireDto> toDto(List<Locataire> locataires) {
		List<LocataireDto> locataireDtos = new ArrayList<>();
		for (Locataire locataire : locataires) {
			locataireDtos.add(toDto(locataire));
		}
		return locataireDtos;
	}

}
