package orsys.projet.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import orsys.projet.business.Statut;
import orsys.projet.dto.LocationDto;
import orsys.projet.dto.LocationDtoEx;
import orsys.projet.mapper.LocationMapper;
import orsys.projet.mapper.impl.LocationMapperImpl;
import orsys.projet.service.LocationService;
import orsys.projet.service.StatutService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class LocationRestController {

	private final LocationService locationService;
	private final StatutService statutService;

	private final LocationMapper locationMapper = new LocationMapperImpl();

	@GetMapping(value = "locations")
	public List<LocationDto> getLocation() {
		// TODO vérifier la session
		return locationMapper.toDto(locationService.recupererLocation());
	}

	@GetMapping(value = "locations_en_attente")
	public List<LocationDto> getLocationEnAttente() {
		// TODO vérifier la session
		Statut statut = statutService.recupererStatutsParDebutNom("En").get(0);
		return locationMapper.toDto(locationService.recupererLocationParStatut(statut));
	}

	@PostMapping(value = "location")
	public LocationDtoEx getLocation(@RequestParam("ID") Long id) {
		// TODO vérifier la session
		return locationMapper.toDtoEx(locationService.recupererLocationParId(id));
	}

}
