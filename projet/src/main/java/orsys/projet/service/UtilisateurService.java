package orsys.projet.service;

import java.time.LocalDateTime;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Utilisateur;

public interface UtilisateurService {
	
	Concessionnaire ajouterConcessionnaire(String nom, String prenom, String email, String motDePasse, String numeroDeTelephone);
	
	Locataire ajouterLocataire(String nom, String prenom, String email, String motDePasse, LocalDateTime dateHeureInscription);
	
	Utilisateur enregistrerUtilisateur (Utilisateur utilisateur);
	
	Utilisateur recupererUtilisateur (Long idUtilisateur);
	
	Utilisateur recupererUtilisateurParNom (String nom);
	
	Utilisateur recupererUtilisateurParPrenom (String prenom);
	
	Utilisateur recupererUtilisateurParEmail (String email);
	
	Utilisateur mettreAJourNom (String nom);
	
	Utilisateur mettreAJourPrenom (String prenom);
	
	Utilisateur mettreAJourEmail (String email);
	
	Concessionnaire mettreAJourConcessionnaireNumeroDeTelephone (String numeroDeTelephone);
	
	boolean supprimerUtilisateur (Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
