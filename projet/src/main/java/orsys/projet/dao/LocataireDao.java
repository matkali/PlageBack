package orsys.projet.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Locataire;

public interface LocataireDao extends JpaRepository<Locataire, Long> {
	
	Locataire findByDateHeureInscription(LocalDateTime dateHeureInscription);
	

}
