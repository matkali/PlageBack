package orsys.projet.service;

import java.util.List;

import orsys.projet.business.LienDeParente;

public interface LienDeParenteService {
	
	LienDeParente ajouterLienDeParente (String nom, float coefficient);
	
	LienDeParente recupererLienDeParenteParNom (String nom);
	
	List<LienDeParente> recupererLienDeParenteParCoefficient (float coefficient);
	
	LienDeParente mettreAJourLienDeParenteNom (String nom);
	
	LienDeParente mettreAJourLienDeParenteCoefficient(float coefficient);
	
	boolean supprimerLienDeParenteParNom (String nom);
	
	
}
	
	
	
