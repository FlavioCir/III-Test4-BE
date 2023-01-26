package dao;

import javax.persistence.EntityManager;

import entities.Persona;
import utils.JpaUtil;

public class PersonaDAO extends JpaUtil {

	public void save(Persona p) {
		
		try {
			
			t.begin();
			em.persist(p);
			t.commit();
			
			System.out.println( "Persona inserita correttamente" );
		} catch(Exception e) {
			System.out.println( "ERRORE durante l'inserimento della persona!!" );
		}
		
	}
	
	public void refresh(Persona persona) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(persona);

		} finally {
			em.close();
		}

	}
	
}
