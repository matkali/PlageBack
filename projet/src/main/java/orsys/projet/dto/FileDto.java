package orsys.projet.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileDto {

	@Range(min = 1, max = 8, message = "la rangée est comprise entre 1 et 8")
	byte numero;

	byte chemin;

	List<ParasolDto> parasols;

	@Min(value = 0, message = "Le prix doit être positif")
	double prixJournalier;

	LocalDate dateDeb;

	LocalDate dateFin;
}
