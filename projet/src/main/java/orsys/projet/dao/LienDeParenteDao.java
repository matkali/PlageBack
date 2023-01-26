package orsys.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.LienDeParente;

public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {
	
	LienDeParente findByNom (String nom);
	
	List<LienDeParente> findByCoefficient (float coefficient);
	
	
}
