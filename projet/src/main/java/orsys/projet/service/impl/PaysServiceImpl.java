package orsys.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.Pays;
import orsys.projet.dao.PaysDao;
import orsys.projet.exception.PaysExistantException;
import orsys.projet.exception.PaysInexistantException;
import orsys.projet.service.PaysService;

@Service
public class PaysServiceImpl implements PaysService{
	@Autowired
	private PaysDao paysDao;

	@Override
	public Pays enregistrerPays(String code, String nom) {
		if (paysDao.findByCode(code)!=null) {
			throw new PaysExistantException("Ce pays est déjà créé en base");
		} else {
			return paysDao.save(new Pays(code, nom));
		}
	}

	@Override
	public List<Pays> recupererListePays() {
		return paysDao.findAll();
	}

	@Override
	public Pays recupererPaysParCode(String code) {
		return paysDao.findByCode(code);
	}

	@Override
	public Pays recupererPaysParNom(String nom) {
		return paysDao.findByNom(nom);
	}

	@Override
	public Pays mettreAJourNomPays(String nomOld, String nomNew) {
		paysDao.findByNom(nomOld).setNom(nomNew);
		paysDao.save(paysDao.findByNom(nomNew));
		return paysDao.findByNom(nomNew);
	}

	@Override
	public Pays mettreAJourCodePays(String codeOld, String codeNew) {
		paysDao.findByCode(codeOld).setCode(codeNew);
		paysDao.save(paysDao.findByCode(codeNew));
		return paysDao.findByCode(codeNew);
	}

	@Override
	public boolean supprimerPaysParCode(String code) {
		if(paysDao.findByCode(code)==null) {
			throw new PaysInexistantException("Ce code pays n'existe pas en base");
		} else {
			paysDao.delete(paysDao.findByCode(code));
			return true;
		}
	}

	@Override
	public boolean supprimerPaysParNom(String nom) {
		if(paysDao.findByNom(nom)==null) {
			throw new PaysInexistantException("Ce Nom pays n'existe pas en base");
		} else {
			paysDao.delete(paysDao.findByNom(nom));
			return true;
		}
	}
	
	
}
