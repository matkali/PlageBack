package orsys.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Statut;

public interface StatutDao extends JpaRepository<Statut, Long> {

	Statut findByNom(String nom);

	Statut findByNomStartingWith(String nom);
}
