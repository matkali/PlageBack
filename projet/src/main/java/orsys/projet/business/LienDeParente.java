package orsys.projet.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "lienDeParente")
public class LienDeParente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Pattern(regexp = "[a-zA-Z]+")
	private String nom;
	
	@Range(min = 0, max = 1)
	private float coefficient;

}
