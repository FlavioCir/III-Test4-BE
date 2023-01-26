package dao;

import javax.persistence.EntityManager;

import entities.Partecipazione;
import utils.JpaUtil;

public class PartecipazioneDAO extends JpaUtil {

	public void save(Partecipazione par) {
		
		try {
			
			t.begin();
			em.persist(par);
			t.commit();
			
			System.out.println( "Partecipazione inserita correttamente" );
		} catch(Exception e) {
			System.out.println( "ERRORE durante l'inserimento della partecipazione!!" );
		}
		
	}

	public void refresh(Partecipazione partecipazione) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(partecipazione);

		} finally {
			em.close();
		}

	}
	
}
