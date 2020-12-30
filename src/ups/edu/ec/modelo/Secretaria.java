package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.List;

public class Secretaria extends Persona implements Serializable {
	
	private int se_id;
	private List<LibroDiario> libroDiario;
	
	public Secretaria() {
		
	}

	
	public Secretaria(int se_id,List<LibroDiario> libroDiario) {
		this.se_id=se_id;
		this.libroDiario=libroDiario;
	}


	public int getSe_id() {
		return se_id;
	}


	public void setSe_id(int se_id) {
		this.se_id = se_id;
	}


	public List<LibroDiario> getLibroDiario() {
		return libroDiario;
	}


	public void setLibroDiario(List<LibroDiario> libroDiario) {
		this.libroDiario = libroDiario;
	}
	
	
}

