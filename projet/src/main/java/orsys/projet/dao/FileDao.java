package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.File;

public interface FileDao extends  JpaRepository<File, Long>{
	File findByNumero(byte numero);
}
