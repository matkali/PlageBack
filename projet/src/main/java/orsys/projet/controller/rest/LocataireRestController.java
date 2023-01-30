package orsys.projet.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import orsys.projet.dto.LocataireDto;
import orsys.projet.mapper.LocataireMapper;
import orsys.projet.mapper.impl.LocataireMapperImpl;
import orsys.projet.service.UtilisateurService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class LocataireRestController {
	private final UtilisateurService utilisateurService;

	private final LocataireMapper locataireMapper = new LocataireMapperImpl();

	@GetMapping(value = "locataires")
	public List<LocataireDto> getLocataire() {
		// TODO vérifier la session
		return locataireMapper.toDto(utilisateurService.recupererLocataires());
	}

}
