package entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "partiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa")
@NamedQuery(name = "partiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
@NamedQuery(name = "partitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL")
public class PartitaDiCalcio extends Evento {
	
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	
	private int goalSquadraCasa = 0;
	private int goalSquadraOspite = 0;
		
}
