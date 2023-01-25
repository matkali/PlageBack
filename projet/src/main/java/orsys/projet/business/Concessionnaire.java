package orsys.projet.business;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Concessionnaire extends Utilisateur {
	@NonNull
	@Pattern(regexp = "\\d{10}", message = "veuillez un numéro de téléphone composé de 10 chiffres")
	private String numeroDeTelephone;

}
