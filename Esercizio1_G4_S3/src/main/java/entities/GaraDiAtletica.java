package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "garePerVincitore", query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :persona ")
@NamedQuery(name = "garePerPartecipante", query = "SELECT g FROM GaraDiAtletica g WHERE :persona MEMBER OF g.setAtleti")
public class GaraDiAtletica extends Evento  {

	@ManyToMany
	private Set<Persona> setAtleti;
	
	@ManyToOne
	private Persona vincitore;
		
}
