package orsys.projet.initialisation;

import java.time.LocalDate;
import java.util.ArrayList;
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

@Component
public class AjoutDonneesInitiales implements CommandLineRunner {
	private final FileDao fileDao;
	private final ParasolDao parasolDao;
	private final LocationDao locationDao;
	private final LocataireDao locataireDao;
	private final LienDeParenteDao lienDeParenteDao;
	private final PaysDao paysDao;
	private final ConcessionnaireDao concessionnaireDao;
	private final StatutDao statutDao;
	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"),
			new RandomService());
	private static Faker faker = new Faker(new Locale("fr-FR"));

	private LienDeParente lienFrere;
	private LienDeParente lienCousin;
	private LienDeParente lienParent;
	private LienDeParente lienDefaut;
	private List<LienDeParente> lienDeParentes = new ArrayList<>();

	private Pays paysFrance;
	private Pays paysGabon;
	private Pays paysGrece;
	private Pays paysEgypte;
	private Pays paysDominique;
	private List<Pays> listPays = new ArrayList<>();

	private Statut statutEnAttente;
	private Statut statutRefuse;
	private Statut statutAcceptee;
	private List<Statut> statuts = new ArrayList<>();

	private File file1;
	private File file2;
	private File file3;
	private File file4;
	private File file5;
	private File file6;
	private File file7;
	private File file8;
	private List<File> files = new ArrayList<>();

	private Parasol parasol1A;
	private Parasol parasol1B;
	private Parasol parasol1J;
	private Parasol parasol8I;
	private Parasol parasol8J;
	private Parasol parasolR1;
	private Parasol parasolR8;
	private List<Parasol> parasolsFile2;

	private Concessionnaire Mateo;
	private Locataire Lola;
	private Locataire FX;
	
	private Location location1;
	private Location location2;
	private Location location3;
	private Location locationEnAttente;
	private Location locationRefusee;

	Random rand = new Random();

	@Override
	@Transactional
	public void run(String... args) {
		Date dateHeureDebut = new Date();
		ajouterLienDeParente();
		ajouterPays();
		ajouterStatut();
		ajouterFile();
		ajouterParasol();
		ajouterConcessionnaire();
		ajouterLocataire();
		ajouterLocation();
		Date dateHeureFin = new Date();
		System.out.println("Données initiales ajoutées en "
				+ String.valueOf(dateHeureFin.getTime() - dateHeureDebut.getTime() + " ms"));
	}

	private void ajouterLocation() {
		LocalDate dateToday = LocalDate.now();
		
		List<Parasol> parasols1 = new ArrayList<>();
		parasols1.add(parasolR1);
		parasols1.add(parasolR1);
		parasols1.add(parasolR1);
		locationEnAttente = new Location(dateToday.plusDays(1),dateToday.plusDays(3),Lola,Mateo,statutEnAttente,parasols1);
		locationDao.save(locationEnAttente);
		List<Parasol> parasols2 = new ArrayList<>();
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		parasols2.add(parasolR8);
		locationRefusee = new Location(dateToday.plusDays(1),dateToday.plusDays(4),FX,Mateo,statutRefuse,parasols2);
		locationDao.save(locationRefusee);
		List<Parasol> parasols3 = new ArrayList<>();
		parasols3.add(parasol1A);
		parasols3.add(parasol1B);
		parasols3.add(parasol1J);
		location1 = new Location(dateToday,dateToday.plusDays(3),FX,Mateo,statutAcceptee,parasols3);
		location1.setRemarque("Merci de mettre ma belle-mère à l'écart");
		locationDao.save(location1);
		List<Parasol> parasols4 = parasolsFile2;
		location2 = new Location(dateToday.minusDays(2),dateToday,Lola,Mateo,statutAcceptee,parasols4);
		locationDao.save(location2);
		List<Parasol> parasols5 = new ArrayList<>();
		parasols5.add(parasol8I);
		parasols5.add(parasol8J);
		location3 = new Location(dateToday.minusDays(2),dateToday.plusDays(4),Lola,Mateo,statutAcceptee,parasols5);
		locationDao.save(location3);
	}

	private void ajouterStatut() {
		if (statutDao.count() == 0) {
			statutEnAttente = new Statut("En attente");
			statutRefuse = new Statut("Refusée");
			statutAcceptee = new Statut("Acceptée");
			statuts.add(statutAcceptee);
			statuts.add(statutEnAttente);
			statuts.add(statutRefuse);
			statutDao.save(statutEnAttente);
			statutDao.save(statutRefuse);
			statutDao.save(statutAcceptee);
		}
	}

	private void ajouterParasol() {
		if (parasolDao.count() == 0) {
			for (File file : files) {
				if (file == file1) {
					parasolR1 = new Parasol((byte) -1, file);					
					parasol1A = new Parasol((byte) 0, file);
					parasol1B = new Parasol((byte) 1, file);
					parasolDao.save(parasolR1);
					parasolDao.save(parasol1A);
					parasolDao.save(parasol1B);
					for (int i = 2; i < 9; i++) {
						parasolDao.save(new Parasol((byte) i, file));
					}
					parasol1J = new Parasol((byte) 9, file);
					parasolDao.save(parasol1J);
				} else if (file == file8) {
					parasolR8 = new Parasol((byte) -1, file);
					parasolDao.save(parasolR8);
					for (int i = 0; i < 8; i++) {
						parasolDao.save(new Parasol((byte) i, file));
					}
					parasol8I = new Parasol((byte) 8, file);
					parasol8J = new Parasol((byte) 9, file);
					parasolDao.save(parasol8I);
					parasolDao.save(parasol8J);
				} else if (file == file2){
					parasolsFile2 = new ArrayList<>();
					parasolDao.save(new Parasol((byte) -1, file));
					for (int i = 0; i < 10; i++) {
						parasolsFile2.add(new Parasol((byte) i, file));
					}
					for(Parasol parasol:parasolsFile2) {
						parasolDao.save(parasol);
					}
				} else {
					parasolDao.save(new Parasol((byte) -1, file));
					for (int i = 0; i < 10; i++) {
						parasolDao.save(new Parasol((byte) i, file));
					}
				}
			}
		}
	}

	private void ajouterFile() {
		if (fileDao.count() == 0) {
			file1 = new File((byte) 1, 25);
			file2 = new File((byte) 2, 24);
			file3 = new File((byte) 3, 23);
			file4 = new File((byte) 4, 22);
			file5 = new File((byte) 5, 21);
			file6 = new File((byte) 6, 20);
			file7 = new File((byte) 7, 19);
			file8 = new File((byte) 8, 18);
			files.add(file1);
			files.add(file2);
			files.add(file3);
			files.add(file4);
			files.add(file5);
			files.add(file6);
			files.add(file7);
			files.add(file8);
			for (File file : files) {
				fileDao.save(file);
			}
		}
	}

	private void ajouterConcessionnaire() {
		Mateo = new Concessionnaire("Rossini", "Mateo", "rossini.mateo@gmail.com", "123", "0611223344");
		concessionnaireDao.save(Mateo);

	}

	private void ajouterLocataire() {
		if (locataireDao.count() == 0) {
			for (int i = 0; i < 100; i++) {
				Pays pays = listPays.get(rand.nextInt(listPays.size()));
				LienDeParente lienDeParente = lienDeParentes.get(rand.nextInt(lienDeParentes.size()));
				locataireDao.save(new Locataire(faker.name().lastName(), faker.name().firstName(),
						fakeValuesService.letterify("?????@gmail.com"), faker.internet().password(3, 8), lienDeParente,
						pays));
			}
			Lola = new Locataire("lola", "lola", "lol@gmail.com", "123", lienCousin, paysGrece);
			FX = new Locataire("fx", "fx", "fx@orsys.fr", "abc", lienDefaut, paysFrance);
			locataireDao.save(Lola);
			locataireDao.save(FX);
		}
	}

	private void ajouterPays() {
		if (paysDao.count() == 0) {
			paysFrance = new Pays("250", "France");
			paysGabon = new Pays("266", "Gabon");
			paysGrece = new Pays("300", "Grèce");
			paysEgypte = new Pays("818", "Egypte");
			paysDominique = new Pays("212", "Dominique");
			listPays.add(paysFrance);
			listPays.add(paysGabon);
			listPays.add(paysGrece);
			listPays.add(paysEgypte);
			listPays.add(paysDominique);
			for (Pays pays : listPays) {
				paysDao.save(pays);
			}
		}

	}

	private void ajouterLienDeParente() {
		if (lienDeParenteDao.count() == 0) {
			lienFrere = new LienDeParente("Fraternel", 0.5F);
			lienCousin = new LienDeParente("Cousin", 0.75F);
			lienParent = new LienDeParente("Parent", 0.25F);
			lienDefaut = new LienDeParente("Defaut", 1F);
			lienDeParentes.add(lienFrere);
			lienDeParentes.add(lienCousin);
			lienDeParentes.add(lienParent);
			lienDeParentes.add(lienDefaut);
			for (LienDeParente lien : lienDeParentes) {
				lienDeParenteDao.save(lien);
			}
		}

	}

	public AjoutDonneesInitiales(FileDao fileDao, ParasolDao parasolDao, LocationDao locationDao,
			LocataireDao locataireDao, LienDeParenteDao lienDeParenteDao, PaysDao paysDao,
			ConcessionnaireDao concessionnaireDao, StatutDao statutDao) {
		super();
		this.fileDao = fileDao;
		this.parasolDao = parasolDao;
		this.locationDao = locationDao;
		this.locataireDao = locataireDao;
		this.lienDeParenteDao = lienDeParenteDao;
		this.paysDao = paysDao;
		this.concessionnaireDao = concessionnaireDao;
		this.statutDao = statutDao;
	}
}
