package ups.edu.ec.modelo;

import java.io.Serializable;

public class FacturaDetalle implements Serializable{

	private int idFacturaD;
	private Cita_Medica cita;
	
	public FacturaDetalle() {
		
	}
	public FacturaDetalle(int idFacturaD,Cita_Medica cita) {
		this.idFacturaD=idFacturaD;
		this.cita=cita;
	}
	public int getIdFacturaD() {
		return idFacturaD;
	}
	public void setIdFacturaD(int idFacturaD) {
		this.idFacturaD = idFacturaD;
	}
	public Cita_Medica getCita() {
		return cita;
	}
	public void setCita(Cita_Medica cita) {
		this.cita = cita;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cita == null) ? 0 : cita.hashCode());
		result = prime * result + idFacturaD;
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
		FacturaDetalle other = (FacturaDetalle) obj;
		if (cita == null) {
			if (other.cita != null)
				return false;
		} else if (!cita.equals(other.cita))
			return false;
		if (idFacturaD != other.idFacturaD)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FacturaDetalle [idFacturaD=" + idFacturaD + ", cita=" + cita + "]";
	}
	
}
