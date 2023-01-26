package orsys.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
	List<Utilisateur> findByNom(String nom);
	
	List<Utilisateur> findByPrenom(String prenom);
	
	Utilisateur findByEmail(String email);
	
	
	

}
