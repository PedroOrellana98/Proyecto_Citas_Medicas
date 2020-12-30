package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Historia_Clinica implements Serializable{

	private int id;
	private Date fecha;
	private String hora;
	private List<Cita_Medica> citas;
	private Paciente paciente;
	
	public Historia_Clinica() {
		
	}
	
	public Historia_Clinica(int id, Date fecha, String hora, List<Cita_Medica> citas, Paciente paciente) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.citas = citas;
		this.paciente = paciente;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<Cita_Medica> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita_Medica> citas) {
		this.citas = citas;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citas == null) ? 0 : citas.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
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
		Historia_Clinica other = (Historia_Clinica) obj;
		if (citas == null) {
			if (other.citas != null)
				return false;
		} else if (!citas.equals(other.citas))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
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
		return "Historia_Clinica [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", citas=" + citas + ", paciente="
				+ paciente + "]";
	}
	
}
