package orsys.projet.dto;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParasolDto {
	
	@Range(min=-1, max=36, message="Il y a 36 parasols par file")
	byte numEmplacement;
	
	FileDto fileDto;
}
