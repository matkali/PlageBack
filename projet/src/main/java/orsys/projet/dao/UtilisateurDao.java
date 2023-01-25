package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByNom(String nom);
	
	Utilisateur findByPrenom(String prenom);
	
	Utilisateur findByEmail(String email);
	
	
	

}
