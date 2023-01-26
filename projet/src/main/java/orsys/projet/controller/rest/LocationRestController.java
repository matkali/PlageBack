package orsys.projet.controller.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import orsys.projet.business.Location;
import orsys.projet.service.LocationService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LocationRestController {

	private final LocationService locationService;
	
	@GetMapping(value="locations", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getJours() {
		return locationService.recupererLocation();
	}
	
}
