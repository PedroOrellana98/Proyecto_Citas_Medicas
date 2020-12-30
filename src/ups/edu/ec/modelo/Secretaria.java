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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((libroDiario == null) ? 0 : libroDiario.hashCode());
		result = prime * result + se_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secretaria other = (Secretaria) obj;
		if (libroDiario == null) {
			if (other.libroDiario != null)
				return false;
		} else if (!libroDiario.equals(other.libroDiario))
			return false;
		if (se_id != other.se_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Secretaria [se_id=" + se_id + ", libroDiario=" + libroDiario + "]";
	}
	
}

