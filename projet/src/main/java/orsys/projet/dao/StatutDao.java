package orsys.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orsys.projet.business.Statut;

public interface StatutDao extends JpaRepository<Statut, Long> {

    Statut findByNom(String nom);

    List<Statut> findAllByNomStartingWith(String nom);
}