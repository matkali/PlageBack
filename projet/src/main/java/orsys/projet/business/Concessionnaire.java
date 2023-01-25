package orsys.projet.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="concessionnaire")
public class Concessionnaire extends Utilisateur {
	private String numeroDeTelephone;
	
	
	

}
