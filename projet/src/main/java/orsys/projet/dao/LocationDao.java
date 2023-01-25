package orsys.projet.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Statut;

public interface LocationDao extends JpaRepository<Location, Long>{
	List<Location> findLocationByDateHeureDebut(LocalDateTime date);
	List<Location> findLocationByDateHeureFin(LocalDateTime date);
	
	List<Location> findLocationByDateHeureDebutAfter(LocalDateTime date);
	List<Location> findLocationByDateHeureFinAfter(LocalDateTime date);
	List<Location> findLocationByDateHeureDebutBefore(LocalDateTime date);
	List<Location> findLocationByDateHeureFinBefore(LocalDateTime date);
	List<Location> findLocationByDateHeureDebutBetween(LocalDateTime date1, LocalDateTime date2);
	List<Location> findLocationByDateHeureFinBetween(LocalDateTime date1, LocalDateTime date2);
	
	
	List<Location> findLocationByStatut(Statut statut);
	List<Location> findLocationByLocataire(Locataire locataire);
	List<Location> findLocationByConcessionnaire(Concessionnaire concessionnaire);
}
