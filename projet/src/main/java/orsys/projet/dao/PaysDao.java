package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Pays;

public interface PaysDao extends JpaRepository<Pays, String> {
	
	Pays findByCode(String code);
	
	Pays findByNom(String nom);

}
