package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import entities.Concerto;
import entities.Evento;
import entities.GaraDiAtletica;
import entities.Genere;
import entities.PartitaDiCalcio;
import entities.Persona;
import utils.JpaUtil;

public class EventoDAO extends JpaUtil {

	public void save(Evento ev) {
		
		try {
			
			t.begin();
			em.persist(ev);
			t.commit();
			
			System.out.println( "Evento inserito correttamente" );
		} catch(Exception e) {
			System.out.println( "ERRORE durante l'inserimento dell'evento!!" );
		}
		
	}
	
	public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
		try {
			
			Query query = em.createNamedQuery("concertiInStreaming");
			
			query.setParameter("streaming", inStreaming);
			System.out.println( query.getResultList().toString() );
			return query.getResultList();
			
		} finally {
		}
	}
	
	public List<Concerto> getConcertoPerGenere(Genere genere) {
		try {
			
			Query query = em.createNamedQuery("concertiPerGenere");
			
			query.setParameter("listagenere", genere);
			System.out.println( query.getResultList().toString() );
			return query.getResultList();
			
		} finally {
		}
	}
	
	public List<PartitaDiCalcio> getPartiteVinteInCasa() {
		return executeNamedQuery("partiteVinteInCasa", PartitaDiCalcio.class);
	}

	public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
		return executeNamedQuery("partiteVinteInTrasferta", PartitaDiCalcio.class);
	}

	public List<PartitaDiCalcio> getPartitePareggiate() {
		return executeNamedQuery("partitePareggiate", PartitaDiCalcio.class);
	}

	private <T> List<T> executeNamedQuery(String namedQuery, Class<T> returnClass) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			Query query = em.createNamedQuery(namedQuery);

			return query.getResultList();

		} finally {
			em.close();
		}
	}
	
	public List<Evento> getEventiPerInvitato(Persona invitato) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			Query query = em.createNamedQuery("eventiPerInvitato");

			query.setParameter("persona", invitato);
			return query.getResultList();

		} finally {
			em.close();
		}
	}
	
	
	public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			Query query = em.createNamedQuery("garePerVincitore");

			query.setParameter("persona", vincitore);
			return query.getResultList();

		} finally {
			em.close();
		}
	}
	
	public List<Evento> getEventiSoldout(){
		
		return executeNamedQuery("eventiSoldout", Evento.class);

	}
		
	public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona partecipante) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			Query query = em.createNamedQuery("garePerPartecipante");

			query.setParameter("persona", partecipante);
			return query.getResultList();

		} finally {
			em.close();
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
