package orsys.projet.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Locataire;
import orsys.projet.business.Location;

public interface LocataireDao extends JpaRepository<Locataire, Long> {
	
	Locataire findByDateHeureInscription(LocalDateTime dateHeureInscription);
	
	List<Locataire> findByLocations(List<Location> locations);

}
