package orsys.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orsys.projet.business.Statut;
import orsys.projet.dao.StatutDao;
import orsys.projet.exception.FileInexistanteException;
import orsys.projet.exception.StatutExistantException;
import orsys.projet.service.StatutService;

@Service
public class StatutServiceImpl implements StatutService {

	@Autowired
	private StatutDao statutDao;

	@Override
	public Statut enregisterStatut(Statut statut) {
		if (statutDao.existsById(statut.getId())) {
			throw new StatutExistantException();
		}
		return statutDao.save(statut);
	}

	@Override
	public Statut enregisterStatut(String nom) {
		return enregisterStatut(new Statut(nom));
	}

	@Override
	public boolean supprimerStatut(Long id) {
		if (statutDao.existsById(id)) {
			statutDao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Statut modifierStatut(Long id, String nom) {
		Statut statut = statutDao.findById(id).orElse(null);
		if (statut == null) {
			throw new FileInexistanteException();
		}
		statut.setNom(nom);
		return statutDao.save(statut);
	}

	@Override
	public List<Statut> recupererStatuts() {
		return statutDao.findAll();
	}

	@Override
	public List<Statut> recupererStatutsParDebutNom(String nom) {
		return statutDao.findAllByNomStartingWith(nom);
	}

	@Override
	public Statut recupererStatutParNom(String nom) {
		return statutDao.findByNom(nom);
	}

}
