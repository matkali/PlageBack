package orsys.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.LienDeParente;
import orsys.projet.dao.LienDeParenteDao;
import orsys.projet.exception.LienDeParenteExistantException;
import orsys.projet.exception.LienDeParenteInexistantException;
import orsys.projet.service.LienDeParenteService;

@Service
public class LienDeParenteServiceImpl implements LienDeParenteService{

	@Autowired
	private LienDeParenteDao lienDeParenteDao;
	
	@Override
	public LienDeParente enregistrerLienDeParente(String nom, float coefficient) {
		return lienDeParenteDao.save(new LienDeParente(nom, coefficient));
	}

	@Override
	public LienDeParente recupererLienDeParenteParNom(String nom) {
		if (lienDeParenteDao.findByNom(nom)!=null){
			throw new LienDeParenteExistantException("Ce lien de parente est déjà créé en base");
		} else {
			return lienDeParenteDao.findByNom(nom);
		}
	}

	@Override
	public List<LienDeParente> recupererLienDeParenteParCoefficient(float coefficient) {
		return lienDeParenteDao.findByCoefficient(coefficient);
	}

	@Override
	public LienDeParente mettreAJourLienDeParenteNom(String nomOld, String nomNew) {
		lienDeParenteDao.findByNom(nomOld).setNom(nomNew);
		lienDeParenteDao.save(lienDeParenteDao.findByNom(nomNew));
		return lienDeParenteDao.save(lienDeParenteDao.findByNom(nomNew));
	}

	@Override
	public LienDeParente mettreAJourLienDeParenteCoefficient(String nom, float coefficient) {
		lienDeParenteDao.findByNom(nom).setCoefficient(coefficient);
		lienDeParenteDao.save(lienDeParenteDao.findByNom(nom));
		return lienDeParenteDao.save(lienDeParenteDao.findByNom(nom));
	}

	@Override
	public boolean supprimerLienDeParenteParNom(String nom) {
		if (lienDeParenteDao.findByNom(nom)==null) {
			throw new LienDeParenteInexistantException("Ce lien de parente n'existe pas en base");
		} else {
			lienDeParenteDao.delete(lienDeParenteDao.findByNom(nom));
			return true;
		}
	}
	
}
