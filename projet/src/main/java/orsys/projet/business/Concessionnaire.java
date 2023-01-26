package orsys.projet.business;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Concessionnaire extends Utilisateur {
	

	public Concessionnaire(@NonNull @Pattern(regexp = "[a-zA-Z]+") String nom,
			@NonNull @Pattern(regexp = "[a-zA-Z]+") String prenom, @NonNull @Email String email,
			@NonNull @Size(min = 3, message = "Le mot de passe doit comporter au moins trois caractères") String motDePasse,
			@NonNull @Pattern(regexp = "\\d{10}", message = "veuillez un numéro de téléphone composé de 10 chiffres") String numeroDeTelephone) {
		super(nom, prenom, email, motDePasse);
		this.numeroDeTelephone = numeroDeTelephone;
	}

	@NonNull
	@Pattern(regexp = "\\d{10}", message = "veuillez un numéro de téléphone composé de 10 chiffres")
	private String numeroDeTelephone;

}
