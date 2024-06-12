package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="DATE_DEBUT", length = 255, nullable = false)
	private Date dateDebut;
	
	@Column(name ="DELAI", length = 255, nullable = true)
	private int delai;
	
	@Column(name ="DATE_FIN", length = 255, nullable = true)
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "COMPO",
			joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_LIV",referencedColumnName = "ID"))
	private List<Livre> emprunts = new ArrayList<>();
	
	public Emprunt() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
