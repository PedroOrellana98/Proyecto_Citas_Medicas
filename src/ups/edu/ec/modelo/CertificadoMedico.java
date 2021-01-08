package ups.edu.ec.modelo;

import java.io.Serializable;

public class CertificadoMedico implements Serializable {

	private int cer_id;
	private String cer_motivo;
	private Paciente cer_paciente;
	private Medico cer_medico;

	public CertificadoMedico() {

	}

	public CertificadoMedico(int cer_id, String cer_motivo, Paciente cer_paciente, Medico cer_medico) {
		this.cer_id = cer_id;
		this.cer_motivo = cer_motivo;
		this.cer_paciente = cer_paciente;
		this.cer_medico = cer_medico;

	}

	public int getCer_id() {
		return cer_id;
	}

	public void setCer_id(int cer_id) {
		this.cer_id = cer_id;
	}

	public String getCer_motivo() {
		return cer_motivo;
	}

	public void setCer_motivo(String cer_motivo) {
		this.cer_motivo = cer_motivo;
	}

	public Paciente getCer_paciente() {
		return cer_paciente;
	}

	public void setCer_paciente(Paciente cer_paciente) {
		this.cer_paciente = cer_paciente;
	}

	public Medico getCer_medico() {
		return cer_medico;
	}

	public void setCer_medico(Medico cer_medico) {
		this.cer_medico = cer_medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cer_id;
		result = prime * result + ((cer_medico == null) ? 0 : cer_medico.hashCode());
		result = prime * result + ((cer_motivo == null) ? 0 : cer_motivo.hashCode());
		result = prime * result + ((cer_paciente == null) ? 0 : cer_paciente.hashCode());
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
		CertificadoMedico other = (CertificadoMedico) obj;
		if (cer_id != other.cer_id)
			return false;
		if (cer_medico == null) {
			if (other.cer_medico != null)
				return false;
		} else if (!cer_medico.equals(other.cer_medico))
			return false;
		if (cer_motivo == null) {
			if (other.cer_motivo != null)
				return false;
		} else if (!cer_motivo.equals(other.cer_motivo))
			return false;
		if (cer_paciente == null) {
			if (other.cer_paciente != null)
				return false;
		} else if (!cer_paciente.equals(other.cer_paciente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CertificadoMedico [cer_id=" + cer_id + ", cer_motivo=" + cer_motivo + ", cer_paciente=" + cer_paciente
				+ ", cer_medico=" + cer_medico + "]";
	}
}
