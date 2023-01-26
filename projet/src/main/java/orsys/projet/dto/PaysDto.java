package orsys.projet.dto;

import java.util.List;

import lombok.NonNull;

public class PaysDto {
	@NonNull
	private String code;
	@NonNull
	private String nom;
	@NonNull
	private List<LocataireDto> locataires;
}
