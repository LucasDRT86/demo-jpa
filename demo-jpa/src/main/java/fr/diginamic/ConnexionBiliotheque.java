package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionBiliotheque {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		
		Livre l = em.find(Livre.class, 1);
		if(l != null) {
			System.out.println(l.getTitre());
		}		

		transaction.commit();
		

		
		em.close();
	}

}
