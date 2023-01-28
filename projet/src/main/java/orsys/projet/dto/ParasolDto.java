package orsys.projet.dto;

import java.time.LocalDate;

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
public class ParasolDto {
	
	@Range(min=-1, max=9, message="Il y a 10 parasols par file")
	byte numEmplacement;
	
	@Range(min=1, max=8, message="la rangée est comprise entre 1 et 8")
	byte numFile;
	
	boolean reserve;
	
	boolean select;
	
	LocalDate dateDeb;
	
	LocalDate dateFin;
}
