package dao;

import javax.persistence.EntityManager;

import entities.Location;
import utils.JpaUtil;

public class LocationDAO extends JpaUtil {

	public void save(Location lo) {
		
		try {
			
			t.begin();
			em.persist(lo);
			t.commit();
			
			System.out.println( "Location inserita correttamente" );
		} catch(Exception e) {
			System.out.println( "ERRORE durante l'inserimento della location!!" );
		}
		
	}
	
	public void refresh(Location location) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(location);

		} finally {
			em.close();
		}

	}
	
}
