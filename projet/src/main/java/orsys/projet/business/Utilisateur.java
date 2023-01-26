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
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="utilisateur")
public abstract class Utilisateur {
	public Utilisateur(@NonNull @Pattern(regexp = "[a-zA-Z]+") String nom,
			@NonNull @Pattern(regexp = "[a-zA-Z]+") String prenom, @NonNull @Email String email,
			@NonNull @Size(min = 3, message = "Le mot de passe doit comporter au moins trois caractères") String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@NonNull
	@Pattern(regexp = "[a-zA-Z]+")
	protected String nom;
	
	@NonNull
	@Pattern(regexp = "[a-zA-Z]+")
	protected String prenom;
	
	@NonNull
	@Email
	protected String email;
	
	@NonNull
	@Size(min=3, message="Le mot de passe doit comporter au moins trois caractères")
	protected String motDePasse;
	
	
	
	
}
