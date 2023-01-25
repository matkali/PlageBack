package orsys.projet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

import lombok.NonNull;
import orsys.projet.business.Pays;

public class LocataireDto extends UtilisateurDto{
	@NonNull
	@PastOrPresent
	private LocalDateTime dateHeureInscription;
	
	@NonNull
	private Pays pays;
}
