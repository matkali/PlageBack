package orsys.projet.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import orsys.projet.business.LienDeParente;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocataireDto extends UtilisateurDto {
	
	LocalDateTime dateHeureInscription;

	LienDeParente lienDeParente;
	
	String nom;
	
	String prenom; 
	
	String mdp;
	
	String lienDeParenteString;
	
	String paysString;
	
	double coefficient;
	
	String role;
	


	@NonNull
	PaysDto pays;
	
	boolean valide;

	public LocataireDto(Long id, String email, String role) {
		super(id, email, role);
	}
	
	
	public LocataireDto(Long id,String nom, String prenom, String email, String mdp, String role, String dateHeureInscription, String lienDeParente, String pays, boolean valide, double coef) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
		this.dateHeureInscription = LocalDateTime.now();
		this.lienDeParenteString = lienDeParente;
		this.paysString = pays;
		this.valide = valide;
		this.coefficient = coef;
	}
	
	
	

}
