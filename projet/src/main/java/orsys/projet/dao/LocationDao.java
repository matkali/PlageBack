package orsys.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Statut;

public interface LocationDao extends JpaRepository<Location, Long> {

	List<Location> findLocationByStatut(Statut statut);

	List<Location> findLocationByLocataire(Locataire locataire);

	List<Location> findLocationByLocataireId(Long id);

	List<Location> findLocationByConcessionnaire(Concessionnaire concessionnaire);
}
