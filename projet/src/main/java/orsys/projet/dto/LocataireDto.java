package orsys.projet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import orsys.projet.business.LienDeParente;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocataireDto extends UtilisateurDto {
	@NonNull
	@PastOrPresent
	LocalDateTime dateHeureInscription;

	LienDeParente lienDeParente;

	@NonNull
	PaysDto pays;
	
	boolean valide;

}
