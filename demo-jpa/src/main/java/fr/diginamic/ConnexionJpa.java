package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		
		
		Region r = em.find(Region.class, 1);
		if(r != null) {
			System.out.println(r.getNom());
		}
		
		Region r2 = new Region();
		r2.setNom("Occitanie");
		em.persist(r2);
		
		
		Region r3 = em.find(Region.class, r2.getId());
		if(r3 != null) {
			System.out.println(r3.getNom());
		}
		
		transaction.commit();
	}

}
