package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GaraDiAtletica extends Evento  {

	@ManyToMany
	private Set<Persona> setAtleti;
	
	@ManyToOne
	private Persona vincitore;
	
	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location, Set<Persona> setAtleti,
			Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}
		
}
