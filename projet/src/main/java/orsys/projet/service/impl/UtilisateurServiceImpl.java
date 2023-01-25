package orsys.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.Concessionnaire;
import orsys.projet.business.Locataire;
import orsys.projet.business.Utilisateur;
import orsys.projet.dao.ConcessionnaireDao;
import orsys.projet.dao.LienDeParenteDao;
import orsys.projet.dao.LocataireDao;
import orsys.projet.dao.PaysDao;
import orsys.projet.dao.UtilisateurDao;
import orsys.projet.exception.ConcessionnaireExistantException;
import orsys.projet.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private ConcessionnaireDao concessionnaireDao;
	
	@Autowired
	private LocataireDao locataireDao;
	
	@Autowired
	private PaysDao paysDao;
	
	@Autowired
	private LienDeParenteDao lienDeParenteDao;
	
	
	
	
	
	
	@Override
	public Concessionnaire enregistrerConcessionnaire(String nom, String prenom, String email, String motDePasse,
			String numeroDeTelephone) {
		if (utilisateurDao.findByEmail(email)!=null) {
			throw new ConcessionnaireExistantException("Ce concessionnaire est déjà créé en base");
		} else {
		return concessionnaireDao.save(new Concessionnaire(nom, prenom, email, motDePasse, numeroDeTelephone));
		}
	}

	@Override
	public Locataire enregistrerLocataire(String nom, String prenom, String email, String motDePasse, String lienDeParente, String pays) {
		if (utilisateurDao.findByEmail(email)!=null) {
			return (Locataire) utilisateurDao.findByEmail(email);
		} else {
		return locataireDao.save(new Locataire(nom, prenom, email, motDePasse,lienDeParenteDao.findByNom(lienDeParente), paysDao.findByNom(pays)));
		}
	}

	@Override
	public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

	@Override
	public Object recupererUtilisateur(Long idUtilisateur) {
		return utilisateurDao.findById(idUtilisateur);
	}

	@Override
	public List<Utilisateur> recupererUtilisateursParNom(String nom) {
		return utilisateurDao.findByNom(nom);
	}

	@Override
	public List<Utilisateur> recupererUtilisateursParPrenom(String prenom) {
		return utilisateurDao.findByPrenom(prenom);
	}

	@Override
	public Utilisateur recupererUtilisateurParEmail(String email) {
		return utilisateurDao.findByEmail(email);
	}

	@Override
	public Utilisateur mettreAJourNom(String nomOld, String nomNew) {
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
