package orsys.projet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

import org.HdrHistogram.SingleWriterDoubleRecorder;

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
	@NonNull
	@PastOrPresent
	LocalDateTime dateHeureInscription;

	LienDeParente lienDeParente;
	
	String nom;
	
	String prenom; 
	
	String mdp;
	
	String lienDeParenteString;
	
	String paysString;
	
	double coefficient;
	

	@NonNull
	PaysDto pays;
	
	boolean valide;

	public LocataireDto(Long id, String email, String role) {
		super(id, email, role);
	}
	
	
	public LocataireDto(String nom, String prenom, String email, String mdp, String lienDeParente, String pays, double coef) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.lienDeParenteString = lienDeParente;
		this.paysString = pays;
		this.coefficient = coef;
	}
	
	
	

}
