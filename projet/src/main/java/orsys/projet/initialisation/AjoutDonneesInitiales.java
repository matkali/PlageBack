package orsys.projet.initialisation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import lombok.AllArgsConstructor;
import orsys.projet.business.Concessionnaire;
import orsys.projet.business.File;
import orsys.projet.business.LienDeParente;
import orsys.projet.business.Locataire;
import orsys.projet.business.Location;
import orsys.projet.business.Parasol;
import orsys.projet.business.Pays;
import orsys.projet.business.Statut;
import orsys.projet.dao.ConcessionnaireDao;
import orsys.projet.dao.FileDao;
import orsys.projet.dao.LienDeParenteDao;
import orsys.projet.dao.LocataireDao;
import orsys.projet.dao.LocationDao;
import orsys.projet.dao.ParasolDao;
import orsys.projet.dao.PaysDao;
import orsys.projet.dao.StatutDao;
import orsys.projet.dao.UtilisateurDao;
import orsys.projet.service.FileService;
import orsys.projet.service.impl.FileServiceImpl;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner{
	private final FileDao fileDao;
	private final ParasolDao parasolDao;
	private final LocationDao locationDao;
	private final LocataireDao locataireDao;
	private final LienDeParenteDao lienDeParenteDao;
	private final PaysDao paysDao;
	private final UtilisateurDao utilisateurDao;
	private final ConcessionnaireDao concessionnaireDao;
	private final StatutDao statutDao;
	
	private final FileService fileService = new FileServiceImpl();
	
	private static Random random = new Random();
	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"),
			new RandomService());
	private static Faker faker = new Faker(new Locale("fr-FR"));
	
	@Override
	@Transactional
	public void run(String... args) {
		Date dateHeureDebut = new Date();
		ajouterLienDeParente();
		ajouterPays();
		ajouterLocataire();
		ajouterConcessionnaire();
		ajouterFile();
		ajouterParasol();
		ajouterStatut();
		ajouterLocation();
		Date dateHeureFin = new Date();
		System.out.println("Données initiales ajoutées en "+ String.valueOf(dateHeureFin.getTime() - dateHeureDebut.getTime() + " ms"));
	}

	private void ajouterLocation() {
		Random rand = new Random();
		List<File> listFile = fileDao.findAll();
//		List<Parasol> parasols = fileService.recupererParasolsDeFile(listFile.get(rand.nextInt(listFile.size())));
		List<Parasol> parasols = parasolDao.findAll();
		Statut statut = statutDao.findByNom("En attente");
		LocalDate dateDebut = LocalDate.now();
		LocalDate dateFin = dateDebut.plusDays(2);
		List<Locataire> listLocataires = locataireDao.findAll();
		Concessionnaire concessionnaire = concessionnaireDao.findAll().get(0);
		locationDao.save(new Location(dateDebut, dateFin, listLocataires.get(rand.nextInt(listLocataires.size())), concessionnaire, statut, parasols));
		
	}

	private void ajouterStatut() {
		statutDao.save(new Statut("En attente"));
		statutDao.save(new Statut("Refusée"));
		statutDao.save(new Statut("Acceptée"));
		statutDao.save(new Statut("Payée"));
		
	}

	private void ajouterParasol() {
		if(parasolDao.count()==0) {
			List<File> listFile = fileDao.findAll();
			for(File file : listFile) {
				parasolDao.save(new Parasol((byte)-1, file));
				for(int i=0; i<10; i++) {
					parasolDao.save(new Parasol((byte)(i), file));
				}
			}
		}
		
	}

	private void ajouterFile() {
		if(fileDao.count()==0) {
			for(int i=0; i<8;i++) {
				fileDao.save(new File((byte) (i+1),(double) 25-i));
			}
		}
	}

	private void ajouterConcessionnaire() {
		concessionnaireDao.save(new Concessionnaire("Rossini", "Mateo", "rossini.mateo@gmail.com", "123", "0611223344"));
		
	}

	private void ajouterLocataire() {
		
		Random rand = new Random();
		List<Pays> listPays = paysDao.findAll();
		List<LienDeParente> lienDeParentes = lienDeParenteDao.findAll();
		if (locataireDao.count()==0) {
			for(int i= 0; i<100; i++) {
				Pays pays = listPays.get(rand.nextInt(listPays.size()));
				LienDeParente lienDeParente = lienDeParentes.get(rand.nextInt(lienDeParentes.size()));
				locataireDao.save(new Locataire(faker.name().lastName(), faker.name().firstName(),fakeValuesService.letterify("?????@gmail.com") , faker.internet().password(3,8), lienDeParente, pays));
			}
		}
		locataireDao.save(new Locataire("lola", "lola", "lol@gmail.com", "123", lienDeParentes.get(rand.nextInt(lienDeParentes.size())), listPays.get(rand.nextInt(listPays.size()))));
		
	}

	private void ajouterPays() {
		if (paysDao.count()==0) {
			paysDao.save(new Pays("250", "France"));
			paysDao.save(new Pays("266", "Gabon"));
			paysDao.save(new Pays("300", "Grèce"));
			paysDao.save(new Pays("818", "Egypte"));
			paysDao.save(new Pays("212", "Dominique"));
		}
		
	}

	private void ajouterLienDeParente() {
		if (lienDeParenteDao.count()==0) {
			lienDeParenteDao.save(new LienDeParente("Fraternel", 0.5F));
			lienDeParenteDao.save(new LienDeParente("Cousin", 0.75F));
			lienDeParenteDao.save(new LienDeParente("Parent", 0.25F));
			lienDeParenteDao.save(new LienDeParente("Defaut", 1F));
		}
		
	}
}
