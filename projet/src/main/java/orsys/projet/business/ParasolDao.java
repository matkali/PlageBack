package orsys.projet.business;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParasolDao extends JpaRepository<Parasol, Long> {
	List<Parasol> findByFile(File file);
	
	List<Parasol> findByNumEmplacement(byte numEmplacement);
	
	Parasol findByNumEmplacementAndFile(byte numEmplacement,File file);
}
