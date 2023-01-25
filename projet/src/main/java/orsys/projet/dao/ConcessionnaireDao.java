package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Concessionnaire;

public interface ConcessionnaireDao extends JpaRepository<Concessionnaire, Long> {
	
}
