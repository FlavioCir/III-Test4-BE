package dao;

import javax.persistence.EntityManager;

import entities.Concerto;
import entities.Evento;
import utils.JpaUtil;

public class EventoDAO extends JpaUtil {

	public void saveEvento(Evento ev) {
		
		try {
			
			t.begin();
			em.persist(ev);
			t.commit();
			
			System.out.println( "Evento inserito correttamente" );
		} catch(Exception e) {
			System.out.println( "ERRORE durante l'inserimento dell'evento!!" );
		}
		
	}
	
	public static void getEventoById(int id) {
		
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati evento #" + id );
		System.out.printf(  
			"Titolo: %s | Data evento: %s | Descrizione: %s | Tipo evento: %s | Massimo partecipanti: %d%n",
			e.getTitolo(), e.getDataEvento(), e.getDescrizione(), e.getTipoEvento(), e.getNumeroMaxPartecipanti()
		);
	}
	
	public static void eliminaEventoByID(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(e);
		System.out.println( "Evento eliminato correttamente!" );
		t.commit();
	}
	
	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}
	
	public static Evento getEvento(int id) {
		
		Evento e = em.find(Evento.class, id);
		if(e == null) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return null;
		}
		
		return e;
	}
	
	public void refresh(Evento evento) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(evento);

		} finally {
			em.close();
		}

	}
	
//	public static void updateEventoById(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti) {
//		
//		Evento ev = getEvento(id);
//		if(ev == null) {
//			return;
//		}
//		
//		try {
//			ev.setTitolo(titolo);
//			ev.setDataEvento(dataEvento);
//			ev.setDescrizione(descrizione);
//			ev.setTipoEvento(tipoEvento);
//			ev.setTipoEvento(tipoEvento);
//			
//			persist(ev);
//			
//			System.out.println( "L'evento con l'id " + id + " è stato aggiornato!" );
//			
//		} catch(Exception e) {
//			System.out.println( "ERRORE nella modifica dell'evento!" );
//		}
//		
//	}
	
}
