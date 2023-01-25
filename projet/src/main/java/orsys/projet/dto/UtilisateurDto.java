package orsys.projet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


public class UtilisateurDto {
	@NotBlank(message= "Merci de préciser votre nom")
	String nom;

	@NotBlank(message = "Merci de préciser votre prénom")
	String prenom;

	@Email(message = "Merci de préciser une adresse email au bon format")
	@NotBlank(message = "Merci de préciser une adresse email")
	String email;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min = 3, message = "Le mot de passe doit comporter au moins trois caractères")
	String motDePasse;
}
