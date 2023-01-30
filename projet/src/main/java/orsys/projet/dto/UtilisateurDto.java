package orsys.projet.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UtilisateurDto {
//	@NotBlank(message= "Merci de préciser votre nom")
//	String nom;
//
//	@NotBlank(message = "Merci de préciser votre prénom")
//	String prenom;
//
//	@Email(message = "Merci de préciser une adresse email au bon format")
//	@NotBlank(message = "Merci de préciser une adresse email")
//	String email;
//
//	@JsonProperty(access = Access.WRITE_ONLY)
//	@Size(min = 3, message = "Le mot de passe doit comporter au moins trois caractères")
//	String motDePasse;
	
	Long id; 
	
	String email;
	
	String role;
	
	public UtilisateurDto(Long id, String email) {
		this.id = id;
		this.email = email;
	}
}
