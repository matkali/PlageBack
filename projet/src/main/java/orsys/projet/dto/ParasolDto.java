package orsys.projet.dto;

import org.hibernate.validator.constraints.Range;

import orsys.projet.business.File;

public class ParasolDto {
	
	@Range(min=-1, max=36, message="Il y a 36 parasols par file")
	private byte numEmplacement;
	
	private File file;
}
