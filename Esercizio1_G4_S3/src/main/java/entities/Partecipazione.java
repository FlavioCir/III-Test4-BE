package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "partecipazioniDaConfermarePerEvento", query = "SELECT p FROM Partecipazione p WHERE p.stato = entities.Stato.DA_CONFERMARE AND p.evento = :evento")
public class Partecipazione {

	@Id
	@SequenceGenerator(name = "partecipazione_seq", sequenceName = "partecipazione_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partecipazione_seq")
	private int id;
	
	@ManyToOne
	private Persona persona;
	
	@ManyToOne
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
}
