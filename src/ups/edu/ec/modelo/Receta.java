package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

public class Receta implements Serializable{
	
	private int id;
	private List<Prescripcion_Medica> prescripciones;
	private Time horarioMedicina;
	private int diasMedicacion;
	
	public Receta() {
		
	}
	
	public Receta(int id, List<Prescripcion_Medica> prescripciones, Time horarioMedicina, int diasMedicacion) {
		this.id = id;
		this.prescripciones = prescripciones;
		this.horarioMedicina = horarioMedicina;
		this.diasMedicacion = diasMedicacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Prescripcion_Medica> getPrescripciones() {
		return prescripciones;
	}

	public void setPrescripciones(List<Prescripcion_Medica> prescripciones) {
		this.prescripciones = prescripciones;
	}

	public Time getHorarioMedicina() {
		return horarioMedicina;
	}

	public void setHorarioMedicina(Time horarioMedicina) {
		this.horarioMedicina = horarioMedicina;
	}

	public int getDiasMedicacion() {
		return diasMedicacion;
	}

	public void setDiasMedicacion(int diasMedicacion) {
		this.diasMedicacion = diasMedicacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diasMedicacion;
		result = prime * result + ((horarioMedicina == null) ? 0 : horarioMedicina.hashCode());
		result = prime * result + id;
		result = prime * result + ((prescripciones == null) ? 0 : prescripciones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (diasMedicacion != other.diasMedicacion)
			return false;
		if (horarioMedicina == null) {
			if (other.horarioMedicina != null)
				return false;
		} else if (!horarioMedicina.equals(other.horarioMedicina))
			return false;
		if (id != other.id)
			return false;
		if (prescripciones == null) {
			if (other.prescripciones != null)
				return false;
		} else if (!prescripciones.equals(other.prescripciones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", prescripciones=" + prescripciones + ", horarioMedicina=" + horarioMedicina
				+ ", diasMedicacion=" + diasMedicacion + "]";
	}
	
}
