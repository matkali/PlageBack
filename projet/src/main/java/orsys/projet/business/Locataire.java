package orsys.projet.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Locataire extends Utilisateur{
	
	@NonNull
	@PastOrPresent
	private LocalDateTime dateHeureInscription;
	
	@ManyToOne
	private LienDeParente lienDeParente;
	
	@ManyToOne
	@NonNull
	private Pays pays;
	
	@JsonIgnore
	@OneToMany(mappedBy = "locataire", fetch = FetchType.EAGER)
	private List<Location> locations;
	
	public Locataire(@NonNull @Pattern(regexp = "[a-zA-Z]+") String nom,
			@NonNull @Pattern(regexp = "[a-zA-Z]+") String prenom, @NonNull @Email String email,
			@NonNull @Size(min = 3, message = "Le mot de passe doit comporter au moins trois caractères") String motDePasse, LienDeParente lienDeParente,
			@NonNull Pays pays) {
		super(nom, prenom, email, motDePasse);
		this.dateHeureInscription = LocalDateTime.now();
		this.lienDeParente = lienDeParente;
		this.pays = pays;
	}

	
}
