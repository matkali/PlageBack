package orsys.projet.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "pays")
public class Pays {
	@Id
	@NonNull
	private String code;
	
	@NonNull
	private String nom;
	
	@OneToMany(mappedBy = "pays", fetch = FetchType.EAGER)
	private List<Locataire> locataires;
}
