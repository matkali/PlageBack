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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="utilisateur")
public abstract class Utilisateur {
//	public Utilisateur(@NonNull String nom,
//			@NonNull String prenom, @NonNull @Email String email,
//			@NonNull @Size(min = 3, message = "Le mot de passe doit comporter au moins trois caractères") String motDePasse) {
//		super();
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//		this.motDePasse = motDePasse;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@NonNull
	protected String nom;
	
	@NonNull
	protected String prenom;
	
	@NonNull
	@Email
	protected String email;
	
	@NonNull
	@Size(min=3, message="Le mot de passe doit comporter au moins trois caractères")
	protected String motDePasse;
	
	
	
	
}
