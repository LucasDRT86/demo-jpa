package fr.diginamic.banque;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NUMERO", length = 50, nullable = false)
	private String numero;
	
	@Column(name = "SOLDE", length = 50, nullable = false)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="COMPTE_CLIENT",
	joinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName=
	"id"),
	inverseJoinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="id"))
	private List<Client> clients = new ArrayList<>();
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations = new ArrayList<>();
	
	public Compte() {
	}
	
	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
}
