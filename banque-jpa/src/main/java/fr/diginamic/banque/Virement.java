package fr.diginamic.banque;

import jakarta.persistence.Entity;

@Entity
public class Virement extends Operation{
	
	private String beneficiaire;

	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}
	
	

}
