package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PartitaDiCalcio extends Evento {
	
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	
	private int goalSquadraCasa;
	private int goalSquadraOspite;
	
	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location, String squadraDiCasa,
			String squadraOspite, String squadraVincente, int goalSquadraCasa, int goalSquadraOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.goalSquadraCasa = goalSquadraCasa;
		this.goalSquadraOspite = goalSquadraOspite;
	}
		
}
