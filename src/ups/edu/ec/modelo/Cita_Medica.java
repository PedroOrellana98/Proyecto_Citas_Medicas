package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Date;

public class Cita_Medica implements Serializable {

	private int cit_id;
	private Date cit_fecha;
	private String cit_hora;
	private Paciente cit_paciente;
	private Medico cit_medico;
	private Secretaria secre;
	
	public Cita_Medica() {
		
	}
	
	public Cita_Medica( int cit_id,Date cit_fecha,String cit_hora,Paciente cit_paciente,Medico cit_medico,Secretaria secre) {
		this.cit_id=cit_id;
		this.cit_fecha=cit_fecha;
		this.cit_hora=cit_hora;
		this.cit_paciente=cit_paciente;
		this.cit_medico=cit_medico;
		this.secre=secre;
	}

	public int getCit_id() {
		return cit_id;
	}

	public void setCit_id(int cit_id) {
		this.cit_id = cit_id;
	}

	public Date getCit_fecha() {
		return cit_fecha;
	}

	public void setCit_fecha(Date cit_fecha) {
		this.cit_fecha = cit_fecha;
	}

	public String getCit_hora() {
		return cit_hora;
	}

	public void setCit_hora(String cit_hora) {
		this.cit_hora = cit_hora;
	}

	public Paciente getCit_paciente() {
		return cit_paciente;
	}

	public void setCit_paciente(Paciente cit_paciente) {
		this.cit_paciente = cit_paciente;
	}

	public Medico getCit_medico() {
		return cit_medico;
	}

	public void setCit_medico(Medico cit_medico) {
		this.cit_medico = cit_medico;
	}

	public Secretaria getSecre() {
		return secre;
	}

	public void setSecre(Secretaria secre) {
		this.secre = secre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cit_fecha == null) ? 0 : cit_fecha.hashCode());
		result = prime * result + ((cit_hora == null) ? 0 : cit_hora.hashCode());
		result = prime * result + cit_id;
		result = prime * result + ((cit_medico == null) ? 0 : cit_medico.hashCode());
		result = prime * result + ((cit_paciente == null) ? 0 : cit_paciente.hashCode());
		result = prime * result + ((secre == null) ? 0 : secre.hashCode());
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
		Cita_Medica other = (Cita_Medica) obj;
		if (cit_fecha == null) {
			if (other.cit_fecha != null)
				return false;
		} else if (!cit_fecha.equals(other.cit_fecha))
			return false;
		if (cit_hora == null) {
			if (other.cit_hora != null)
				return false;
		} else if (!cit_hora.equals(other.cit_hora))
			return false;
		if (cit_id != other.cit_id)
			return false;
		if (cit_medico == null) {
			if (other.cit_medico != null)
				return false;
		} else if (!cit_medico.equals(other.cit_medico))
			return false;
		if (cit_paciente == null) {
			if (other.cit_paciente != null)
				return false;
		} else if (!cit_paciente.equals(other.cit_paciente))
			return false;
		if (secre == null) {
			if (other.secre != null)
				return false;
		} else if (!secre.equals(other.secre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cita_Medica [cit_id=" + cit_id + ", cit_fecha=" + cit_fecha + ", cit_hora=" + cit_hora
				+ ", cit_paciente=" + cit_paciente + ", cit_medico=" + cit_medico + ", secre=" + secre + "]";
	}
	
}
