package orsys.projet.business;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Concessionnaire extends Utilisateur {
	@NonNull
	@Pattern(regexp = "\\d{10}", message = "veuillez un numéro de téléphone composé de 10 chiffres")
	private String numeroDeTelephone;
	
	
	

}
