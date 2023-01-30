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
import orsys.projet.exception.LocataireExiststantException;
import orsys.projet.exception.UtilisateurInexistantException;
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
			throw new LocataireExiststantException("Ce locataire existe déjà en base");
		} else {
		return locataireDao.save(new Locataire(nom, prenom, email, motDePasse,lienDeParenteDao.findByNom(lienDeParente), paysDao.findByNom(pays)));
		}
	}

	@Override
	public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

	@Override
	public Utilisateur recupererUtilisateur(Long idUtilisateur) {
		Utilisateur utilisateur = utilisateurDao.findById(idUtilisateur).orElse(null);
		if(utilisateur==null) {
			throw new UtilisateurInexistantException("Cet utilisateur n'est pas créé en base");
		}else {
			return utilisateur;
		}
	}
	
	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findLastByEmailAndMotDePasse(email, motDePasse);
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
	public Utilisateur mettreAJourNom(Long id, String nomNew) {
		Utilisateur utilisateur = utilisateurDao.findById(id).orElse(null);
		if(utilisateur==null) {
			throw new UtilisateurInexistantException("Utilisateur non présent en base");
		} else {
			utilisateur.setNom(nomNew);
			return utilisateurDao.save(utilisateur);
		}
	}

	@Override
	public Utilisateur mettreAJourPrenom(Long id, String prenomNew) {
		Utilisateur utilisateur = utilisateurDao.findById(id).orElse(null);
		if(utilisateur==null) {
			throw new UtilisateurInexistantException("Utilisateur non présent en base");
		} else {
			utilisateur.setNom(prenomNew);
			return utilisateurDao.save(utilisateur);
		}
	}

	@Override
	public Utilisateur mettreAJourEmail(Long id, String emailNew) {
		Utilisateur utilisateur = utilisateurDao.findById(id).orElse(null);
		if(utilisateur==null) {
			throw new UtilisateurInexistantException("Utilisateur non présent en base");
		} else {
			utilisateur.setNom(emailNew);
			return utilisateurDao.save(utilisateur);
		}
	}

	@Override
	public Concessionnaire mettreAJourConcessionnaireNumeroDeTelephone(Long id, String numeroDeTelephoneNew) {
		Concessionnaire concessionnaire = concessionnaireDao.findById(id).orElse(null);
		if(concessionnaire==null) {
			throw new UtilisateurInexistantException("Utilisateur non présent en base");
		} else {
			concessionnaire.setNom(numeroDeTelephoneNew);
			return utilisateurDao.save(concessionnaire);
		}
	}

	@Override
	public boolean supprimerUtilisateur(Long id) {
		if (utilisateurDao.existsById(id)) {
			throw new UtilisateurInexistantException("Cet Utilisateur n'existe pas en base");
		} else {
			utilisateurDao.deleteById(id);
			return true;
		}
	}

	@Override
	public String recupererConcessionnaireouLocataire(String email, String motDePasse) {
		List<Concessionnaire> concessionnaires = concessionnaireDao.findAll();
		List<Locataire> locataires = locataireDao.findAll();
		Utilisateur utilisateur = recupererUtilisateur(email, motDePasse);
		if(concessionnaires.contains(utilisateur)){
			return "concessionnaire";
		} else if (locataires.contains(utilisateur)) {
			return "locataire";
		}
		return null;
	}
	
	

}
