package orsys.projet.mapper.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.dto.ParasolDto;
import orsys.projet.mapper.ParasolMapper;
@Component
public class ParasolMapperImpl implements ParasolMapper {

	@Override
	public ParasolDto toDto(Parasol parasol, LocalDate dateDeb, LocalDate dateFin) {
		boolean reserve = false;
		for(Location location:parasol.getLocations()) {
			if(!(location.getDateDebut().isAfter(dateFin)|| location.getDateFin().isBefore(dateDeb))) {
				reserve = true;
			}
		}
		return new ParasolDto(parasol.getNumEmplacement(),parasol.getFile().getNumero(),reserve, false, dateDeb, dateFin);
	}

	@Override
	public Parasol toEntity(ParasolDto parasolDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
