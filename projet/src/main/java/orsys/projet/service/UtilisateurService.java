package orsys.projet.service;

import java.time.LocalDateTime;
import java.util.List;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Utilisateur;

public interface UtilisateurService {
	
	Concessionnaire enregistrerConcessionnaire(String nom, String prenom, String email, String motDePasse, String numeroDeTelephone);
	
	Locataire enregistrerLocataire(String nom, String prenom, String email, String motDePasse, String lienDeParente, String pays);
	
	Utilisateur enregistrerUtilisateur (Utilisateur utilisateur);
	
	Object recupererUtilisateur (Long idUtilisateur);
	
	List<Utilisateur> recupererUtilisateursParNom (String nom);
	
	List<Utilisateur> recupererUtilisateursParPrenom (String prenom);
	
	Utilisateur recupererUtilisateurParEmail (String email);
	
	Utilisateur mettreAJourNom (String nomOld, String nomNew);
	
	Utilisateur mettreAJourPrenom (String prenom);
	
	Utilisateur mettreAJourEmail (String email);
	
	Concessionnaire mettreAJourConcessionnaireNumeroDeTelephone (String numeroDeTelephone);
	
	boolean supprimerUtilisateur (Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
