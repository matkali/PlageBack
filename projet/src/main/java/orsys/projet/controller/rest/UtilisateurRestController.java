package orsys.projet.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import orsys.projet.business.Utilisateur;
import orsys.projet.dto.UtilisateurDto;
import orsys.projet.service.UtilisateurService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurRestController {
	private final UtilisateurService utilisateurService;
	
	@GetMapping("utilisateurs/{email}/{motDePasse}")
	public ResponseEntity<Utilisateur> utilisateurGet(@PathVariable String email, @PathVariable String motDePasse) {
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(email, motDePasse);
		if (utilisateur == null) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(utilisateur);
	}

	@PostMapping("utilisateurs/connexion/{email}/{motDePasse}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<UtilisateurDto> utilisateurConnexion(@PathVariable String email,
			@PathVariable String motDePasse) {
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(email, motDePasse);
		if (utilisateur == null) {
			return ResponseEntity.badRequest().body(null);
		}
		String role = utilisateurService.recupererConcessionnaireouLocataire(email, motDePasse);
		UtilisateurDto uDto = new UtilisateurDto(utilisateur.getId(), utilisateur.getEmail(), role);
		return ResponseEntity.ok(uDto);
	}

}
