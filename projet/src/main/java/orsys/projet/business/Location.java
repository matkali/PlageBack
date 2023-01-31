package orsys.projet.business;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private LocalDate dateDebut;

	@NonNull
	private LocalDate dateFin;

	private double montantAReglerEnEuros;

	@Column(length = 500)
	private String remarque;

	@NonNull
	@ManyToOne
	private Locataire locataire;

	@ManyToOne
	private Concessionnaire concessionnaire;

	@NonNull
	@ManyToOne
	private Statut statut;

	@NonNull
	@ManyToMany
	private List<Parasol> parasols;

	public Location(@NonNull LocalDate dateDebut, @NonNull LocalDate dateFin, @NonNull Locataire locataire,
			Concessionnaire concessionnaire, @NonNull Statut statut, @NonNull List<Parasol> parasols) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.concessionnaire = concessionnaire;
		this.locataire = locataire;
		this.statut = statut;
		this.parasols = parasols;
		calculMontantARegler();
	}

	public Location(@NonNull LocalDate dateDebut, @NonNull LocalDate dateFin, @NonNull Locataire locataire,
			@NonNull Statut statut, @NonNull List<Parasol> parasols) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.locataire = locataire;
		this.statut = statut;
		this.parasols = parasols;
		calculMontantARegler();
	}

	private void calculMontantARegler() {
		this.montantAReglerEnEuros = (double) 0;
		for (Parasol parasol : this.parasols) {
			this.montantAReglerEnEuros += parasol.getFile().getPrixJournalier();
		}
		int nbJours = (int) this.dateDebut.until(dateFin, ChronoUnit.DAYS) + 1;
		this.montantAReglerEnEuros *= nbJours;
		float coef = this.locataire.getLienDeParente().getCoefficient();
		this.montantAReglerEnEuros *= coef;
	}

}
