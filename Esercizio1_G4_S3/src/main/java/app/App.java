package app;

import java.time.LocalDate;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Concerto;
import entities.Evento;
import entities.Genere;
import entities.Location;
import entities.Partecipazione;
//import entities.PartitaDiCalcio;
import entities.Persona;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;
import utils.JpaUtil;

public class App extends JpaUtil {

	public static void main(String[] args) {
		
		//Location location = saveLocation();
		//saveEvento(location);
		//Persona persona = savePersona();
		
		//Partecipazione partecipazione = savePartecipazione(evento, persona);
		
		getConcertoInStreaming();

	}
	
	private static Partecipazione savePartecipazione(Evento evento, Persona persona) {
		Partecipazione part = new Partecipazione();
		part.setEvento(evento);
		part.setPersona(persona);
		part.setStato(Stato.CONFERMATA);
		
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		partecipazioneDAO.save(part);
		return part;
	}
	
	private static Persona savePersona() {
		Persona per = new Persona();
		per.setNome("Mario");
		per.setCognome("Rossi");
		per.setEmail("mario.rossi@gmail.com");
		per.setSesso(Sesso.MASCHIO);
		per.setDatadinascita(LocalDate.parse("1999-07-11"));
		PersonaDAO personaDAO = new PersonaDAO();
		personaDAO.save(per);
		return per;
	}
	
	private static Location saveLocation() {
		Location loc = new Location();
		loc.setCitta("Roma");
		loc.setNome("Stadio Olimpico");
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.save(loc);
		return loc;
	}
	
	private static void saveEvento(Location loc) {
		t.begin();
		
		Evento ev = new Evento();
		ev.setTitolo("Festa di compleanno");
		ev.setDataEvento(LocalDate.parse("2025-11-07"));
		ev.setDescrizione("Sarei felice di festeggiare la mia festa di compleanno con voi");
		ev.setNumeroMaxPartecipanti(50);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(loc);
		
		em.persist(ev);
		
		Concerto c = new Concerto();
		c.setTitolo("Concerto 2");
		c.setDataEvento(LocalDate.parse("2020-05-09"));
		c.setDescrizione("Concerto bellissimo");
		c.setNumeroMaxPartecipanti(1200);
		c.setTipoEvento(TipoEvento.PRIVATO);
		c.setLocation(loc);
		c.setGenere(Genere.CLASSICO);
		c.setInStreaming(true);
		
		em.persist(c);
		t.commit();
	}
	
	private static void getConcertoInStreaming() {
		Concerto c1 = em.find(Concerto.class, 8);
		Concerto c2 = em.find(Concerto.class, 10);
		
		System.out.println( c1.getTitolo() + " " + c1.getInStreaming() );
		System.out.println( c2.getTitolo() + " " + c2.getInStreaming() );
	}
	
//	private static Evento saveEvento(Location loc) {
//		Evento ev = new Evento();
//		ev.setTitolo("Discoteca");
//		ev.setDataEvento(LocalDate.parse("2023-07-09"));
//		ev.setDescrizione("Venite a scatenarvi con noi tra musica ed ospiti speciali");
//		ev.setNumeroMaxPartecipanti(150);
//		ev.setTipoEvento(TipoEvento.PUBBLICO);
//		ev.setLocation(loc);
//		
//		EventoDAO eventoDAO = new EventoDAO();
//		eventoDAO.saveEvento(ev);
//		return ev;
//	}
	
//	private static PartitaDiCalcio savePartita() {
//		PartitaDiCalcio pdc = new PartitaDiCalcio();
//		pdc.setSquadraDiCasa("Inter");
//		pdc.setSquadraOspite("Milan");
//		pdc.setSquadraVincente("Inter");
//		pdc.setGoalSquadraCasa(3);
//		pdc.setGoalSquadraOspite(0);
//		
//		EventoDAO partita = new EventoDAO();
//		partita.save(pdc);
//		return pdc;
//	}

}
