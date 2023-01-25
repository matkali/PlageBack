package orsys.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Locataire;
import orsys.projet.business.Pays;

public interface PaysDao extends JpaRepository<Pays, String> {
	
	Pays findByCode(String code);
	
	Pays findByNom(String nom);
	
	List<Pays> findByLocataires(List<Locataire> locataires);

}
