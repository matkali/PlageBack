package orsys.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.File;
import orsys.projet.business.Parasol;

public interface ParasolDao extends JpaRepository<Parasol, Long> {
	List<Parasol> findByFile(File file);
	
	List<Parasol> findByNumEmplacement(byte numEmplacement);
	
	Parasol findByNumEmplacementAndFile(byte numEmplacement,File file);
}
