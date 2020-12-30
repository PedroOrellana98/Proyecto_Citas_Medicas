package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Time;

public class Colaborador extends Persona implements Serializable {

	private int co_id;
	private Time tiempo;
	
	public Colaborador() {
		
	}
	public Colaborador(int co_id,Time tiempo) {
		this.co_id=co_id;
		this.tiempo=tiempo;
	}
	public int getCo_id() {
		return co_id;
	}
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	public Time getTiempo() {
		return tiempo;
	}
	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + co_id;
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
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
		Colaborador other = (Colaborador) obj;
		if (co_id != other.co_id)
			return false;
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Colaborador [co_id=" + co_id + ", tiempo=" + tiempo + "]";
	}
	
	
}
