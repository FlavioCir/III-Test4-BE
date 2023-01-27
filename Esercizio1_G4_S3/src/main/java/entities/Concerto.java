package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NamedQuery(name = "concertiInStreaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query = "SELECT c FROM Concerto c WHERE c.genere in :listagenere")
public class Concerto extends Evento {

	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	private boolean inStreaming;
	
}
