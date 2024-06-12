package fr.diginamic.connexion;

import java.util.Calendar;
import java.util.Date;

import fr.diginamic.banque.Adresse;
import fr.diginamic.banque.Banque;
import fr.diginamic.banque.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		// Banque
		Banque banque = new Banque();
		banque.setNom("Crédit Agricole");
		em.persist(banque);
		
		// Client
		Client client = new Client();
		client.setNom("DORAT");
		client.setPrenom("Lucas");		
		Calendar cal = Calendar.getInstance();
		cal.set(1999,8,07);		
		Date date = cal.getTime();
		client.setDateNaissance(date);		
		client.setBanque(banque);		
		Adresse adr = new Adresse();
		adr.setNumero(13);
		adr.setRue("route de Vivonne");
		adr.setCodePostal(86340);
		adr.setVille("Aslonnes");
		client.setAdresse(adr);
		
		em.persist(client);

		transaction.commit();
		
		em.close();

	}

}
