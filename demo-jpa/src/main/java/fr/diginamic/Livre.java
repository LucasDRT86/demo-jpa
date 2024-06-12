package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Livre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="TITRE", length = 255, nullable = false)
	private String titre;
	
	@Column(name ="AUTEUR", length = 255, nullable = false)
	private String auteur;

	@ManyToMany
	@JoinTable(name = "COMPO",
			joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName = "ID"))
	private List<Emprunt> emprunts = new ArrayList<>();
	
	public Livre() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
}
