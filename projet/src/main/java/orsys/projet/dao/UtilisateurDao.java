package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByUtilisateurNom(String nom);
	
	Utilisateur findByUtilisateurPrenom(String prenom);
	
	Utilisateur findByUtilisateurEmail(String email);
	
	Utilisateur findByUtilisateurId(Long id);
	
	
	

}
