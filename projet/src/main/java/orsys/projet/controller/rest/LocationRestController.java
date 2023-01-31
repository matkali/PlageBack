package orsys.projet.controller.rest;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.business.Statut;
import orsys.projet.dto.LocationDto;
import orsys.projet.dto.LocationDtoEx;
import orsys.projet.dto.ParasolDto;
import orsys.projet.mapper.LocationMapper;
import orsys.projet.mapper.impl.LocationMapperImpl;
import orsys.projet.service.ConcessionnaireService;
import orsys.projet.service.FileService;
import orsys.projet.service.LocationService;
import orsys.projet.service.ParasolService;
import orsys.projet.service.StatutService;
import orsys.projet.service.UtilisateurService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class LocationRestController {

	private final LocationService locationService;
	private final StatutService statutService;
	private final UtilisateurService utilisateurService;
	private final FileService fileService;
	private final ParasolService parasolService;

	private final LocationMapper locationMapper = new LocationMapperImpl();

	@GetMapping(value = "locations")
	public List<LocationDto> getLocation() {
		return locationMapper.toDto(locationService.recupererLocation());
	}

	@GetMapping(value = "locations_en_attente")
	public List<LocationDto> getLocationEnAttente() {
		Statut statut = statutService.recupererStatutsParDebutNom("En").get(0);
		return locationMapper.toDto(locationService.recupererLocationParStatut(statut));
	}

	@PostMapping(value = "location")
	public LocationDtoEx getLocation(@RequestParam("ID") Long id) {
		return locationMapper.toDtoEx(locationService.recupererLocationParId(id));
	}
	
	@PostMapping("utilisateurs/creationLocation")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Location> locationPost(@RequestBody LocationDtoEx locationDto){
		Statut statut = statutService.recupererStatutsParDebutNom("En").get(0);
		Concessionnaire concessionnaire = utilisateurService.recupererConcessionnaires().get(0);
		Locataire locataire = (Locataire) utilisateurService.recupererUtilisateurParEmail(locationDto.getLocataire().getEmail());
		List<ParasolDto> parasolsDto =locationDto.getParasols();
		List<Parasol> parasols = new ArrayList<>();
		for(ParasolDto parasol : parasolsDto) {
			Parasol para = parasolService.recupererParasolParNumEtFile((byte) -1, fileService.recupererFile(parasol.getNumFile()));
			parasols.add(para);
		}
		Location location = locationService.enregisterLocation(locationDto.getDateDebut(), locationDto.getDateFin(), parasols, locataire, statut, concessionnaire);
		return new ResponseEntity<>(location, HttpStatus.CREATED);
	}

}
