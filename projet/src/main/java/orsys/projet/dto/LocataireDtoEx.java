package orsys.projet.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocataireDtoEx extends LocataireDto {
	public LocataireDtoEx(Long id, String email, String role) {
		super(id, email, role);
	}

	List<LocationDto> locations;
}
