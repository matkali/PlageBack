package orsys.projet.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileDto {

	@NonNull
	@Range(min = 1, max = 8, message = "la rangée est comprise entre 1 et 8")
	byte numero;

	@NonNull
	@Min(value = 0, message = "Le prix doit être positif")
	double prixJournalier;
}
