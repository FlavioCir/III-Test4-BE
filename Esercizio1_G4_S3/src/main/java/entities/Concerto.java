package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NamedQuery(name = "concertoInStreaming", query = "select c from Concerto c where c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query = "select c from Concerto c where c.genere in :listagenere")
public class Concerto extends Evento {

	@Column(name = "genere")
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	@Column(name = "in_streaming")
	private boolean inStreaming;

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location, Genere genere, boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}
	
	public boolean getInStreaming() {
		return inStreaming;
	}

}
