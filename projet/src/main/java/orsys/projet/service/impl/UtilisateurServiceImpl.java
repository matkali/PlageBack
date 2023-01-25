package orsys.projet.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Utilisateur;
import orsys.projet.dao.ConcessionnaireDao;
import orsys.projet.dao.LocataireDao;
import orsys.projet.dao.UtilisateurDao;
import orsys.projet.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private ConcessionnaireDao concessionnaireDao;
	
	@Autowired
	private LocataireDao locataireDao;
	
	
	
	
	@Override
	public Concessionnaire enregistrerConcessionnaire(String nom, String prenom, String email, String motDePasse,
			String numeroDeTelephone) {
		Concessionnaire concessionnaire = new Concessionnaire();
		concessionnaire.setNumeroDeTelephone(numeroDeTelephone);
		return null;
	}

	@Override
	public Locataire enregistrerLocataire(String nom, String prenom, String email, String motDePasse,
			LocalDateTime dateHeureInscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur recupererUtilisateur(Long idUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur recupererUtilisateurParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur recupererUtilisateurParPrenom(String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur recupererUtilisateurParEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur mettreAJourNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur mettreAJourPrenom(String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur mettreAJourEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concessionnaire mettreAJourConcessionnaireNumeroDeTelephone(String numeroDeTelephone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimerUtilisateur(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
