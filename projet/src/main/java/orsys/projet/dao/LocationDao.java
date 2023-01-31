package orsys.projet.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Statut;

public interface LocationDao extends JpaRepository<Location, Long>{
	List<Location> findLocationByDateDebut(LocalDate date);
	List<Location> findLocationByDateFin(LocalDate date);
	
	List<Location> findLocationByDateDebutAfter(LocalDate date);
	List<Location> findLocationByDateFinAfter(LocalDate date);
	List<Location> findLocationByDateDebutBefore(LocalDate date);
	List<Location> findLocationByDateFinBefore(LocalDate date);
	List<Location> findLocationByDateDebutBetween(LocalDate date1, LocalDate date2);
	List<Location> findLocationByDateFinBetween(LocalDate date1, LocalDate date2);
	
	
	List<Location> findLocationByStatut(Statut statut);
	List<Location> findLocationByLocataire(Locataire locataire);

	List<Location> findLocationByLocataireId(Long id);
	List<Location> findLocationByConcessionnaire(Concessionnaire concessionnaire);
}
