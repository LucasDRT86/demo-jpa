package fr.diginamic.banque;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AssuranceVie extends Compte {
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private double taux;
	
	public AssuranceVie(Date dateFin, double taux) {
		super();
		this.dateFin = dateFin;
		this.taux = taux;
	}
	
	

}
