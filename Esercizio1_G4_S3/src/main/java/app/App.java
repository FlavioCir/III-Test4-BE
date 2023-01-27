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
import entities.Persona;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;
import utils.JpaUtil;

public class App extends JpaUtil {

	public static void main(String[] args) {
		
		Location location = saveLocation();
		Evento evento = saveEvento(location);
		Persona persona = savePersona();
		
		Partecipazione partecipazione = savePartecipazione(evento, persona);
		saveConcerto();
	}
	
	private static void saveConcerto() {
		Concerto c = new Concerto();
		c.setTitolo("Concerto Justin Bieber");
		c.setGenere(Genere.POP);
		c.setDataEvento(LocalDate.parse("2024-10-20"));
		c.setInStreaming(true);
		
		EventoDAO eventoDAO = new EventoDAO();
		eventoDAO.save(c);
		
		eventoDAO.getConcertiInStreaming(true);
		eventoDAO.getConcertoPerGenere(Genere.ROCK);
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
		loc.setCitta("Milano");
		loc.setNome("Stadio Sansiro");
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.save(loc);
		return loc;
	}
	
	private static Evento saveEvento(Location loc) {		
		Evento ev = new Evento();
		ev.setTitolo("Partita");
		ev.setDataEvento(LocalDate.parse("2025-11-07"));
		ev.setDescrizione("Derby Inter - Milan");
		ev.setNumeroMaxPartecipanti(1000);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(loc);
		
		EventoDAO eventoDAO = new EventoDAO();
		eventoDAO.save(ev);
		return ev;
	}

}
