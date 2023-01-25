package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.LienDeParente;

public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {
	
	LienDeParente findByLienDeParenteNom (String nom);
	
	LienDeParente findByLienDeParenteId (Long id);
	
	LienDeParente findByLienDeParenteCoefficient (float coefficient);
	
	
}
