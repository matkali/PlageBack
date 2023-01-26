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
	
	Utilisateur mettreAJourNom (Long id, String nomNew);
	
	Utilisateur mettreAJourPrenom (Long id, String prenomNew);
	
	Utilisateur mettreAJourEmail (Long id, String emailNew);
	
	Concessionnaire mettreAJourConcessionnaireNumeroDeTelephone (Long id, String numeroDeTelephoneNew);
	
	boolean supprimerUtilisateur (Long id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
