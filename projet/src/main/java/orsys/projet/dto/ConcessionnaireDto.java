package orsys.projet.dto;

import javax.validation.constraints.Pattern;

import lombok.NonNull;

public class ConcessionnaireDto extends UtilisateurDto {

	@NonNull
	@Pattern(regexp = "\\d{10}", message = "veuillez un numéro de téléphone composé de 10 chiffres")
	private String numeroDeTelephone;
}
