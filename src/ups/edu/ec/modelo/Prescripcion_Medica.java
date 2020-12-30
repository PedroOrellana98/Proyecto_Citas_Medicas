package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Prescripcion_Medica implements Serializable{
	
	private int id;
	private Date fecha;
	private Paciente paciente;
	private List<Medicamentos> medicamentos;
	
	public Prescripcion_Medica() {
		
	}
	
	public Prescripcion_Medica(int id, Date fecha, Paciente paciente, List<Medicamentos> medicamentos) {
		this.id = id;
		this.fecha = fecha;
		this.paciente = paciente;
		this.medicamentos = medicamentos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Medicamentos> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamentos> medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((medicamentos == null) ? 0 : medicamentos.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
		Prescripcion_Medica other = (Prescripcion_Medica) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (medicamentos == null) {
			if (other.medicamentos != null)
				return false;
		} else if (!medicamentos.equals(other.medicamentos))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prescripcion_Medica [id=" + id + ", fecha=" + fecha + ", paciente=" + paciente + ", medicamentos="
				+ medicamentos + "]";
	}
	
}
