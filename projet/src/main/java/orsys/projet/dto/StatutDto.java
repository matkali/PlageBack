package orsys.projet.dto;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatutDto {

	@NonNull
	@Column(length=123)
	String nom;
}
