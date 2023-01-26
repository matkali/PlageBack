package orsys.projet.service;

import java.util.List;

import orsys.projet.business.Pays;

public interface PaysService {
	
	Pays enregistrerPays (String code, String nom);
	
	List<Pays> recupererListePays();
	
	Pays recupererPaysParCode (String code);
	
	Pays recupererPaysParNom (String nom);
	
	Pays mettreAJourNomPays (String nomOld, String nomNew);
	
	Pays mettreAJourCodePays (String codeOld, String codeNew);
 	
	boolean supprimerPaysParCode (String code);
	
	boolean supprimerPaysParNom (String nom);
}
