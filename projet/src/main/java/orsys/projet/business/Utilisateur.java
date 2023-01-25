package orsys.projet.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
@Entity
@Table(name="utilisateur")
public abstract class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Pattern(regexp = "[a-zA-Z]+")
	private String nom;
	
	@NonNull
	@Pattern(regexp = "[a-zA-Z]+")
	private String prenom;
	
	@NonNull
	@Email
	private String email;
	
	@NonNull
	@Size(min=3, message="Le mot de passe doit comporter au moins trois caractères")
	private String motDePasse;
	
	
	
	
}
