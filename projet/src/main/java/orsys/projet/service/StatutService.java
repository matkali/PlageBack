package orsys.projet.service;

import java.util.List;

import orsys.projet.business.Statut;

public interface StatutService {
	Statut enregisterStatut(Statut Statut);
	
	Statut enregisterStatut(String nom);

	boolean supprimerStatut(Long id);
	
	Statut modifierStatut(Long id, String nom);
	
	List<Statut> recupererStatuts();
}
