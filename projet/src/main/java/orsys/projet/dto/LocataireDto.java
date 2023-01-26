package orsys.projet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocataireDto extends UtilisateurDto {
	@NonNull
	@PastOrPresent
	LocalDateTime dateHeureInscription;
}
