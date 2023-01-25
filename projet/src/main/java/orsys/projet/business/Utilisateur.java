package orsys.projet.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import lombok.Data;

@Data
@Entity
@Table(name="utilisateur")
public abstract class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String motDePasse;
	
	
}
