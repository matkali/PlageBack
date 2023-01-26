package orsys.projet.service;

import java.util.List;

import orsys.projet.business.LienDeParente;

public interface LienDeParenteService {
	
	LienDeParente enregistrerLienDeParente (String nom, float coefficient);
	
	LienDeParente recupererLienDeParenteParNom (String nom);
	
	List<LienDeParente> recupererLienDeParenteParCoefficient (float coefficient);
	
	LienDeParente mettreAJourLienDeParenteNom (String nomOld, String nomNew);
	
	LienDeParente mettreAJourLienDeParenteCoefficient(String nom, float coefficient);
	
	boolean supprimerLienDeParenteParNom (String nom);
	
	
}
	
	
	
