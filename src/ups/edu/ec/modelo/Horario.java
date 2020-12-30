package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Time;

public class Horario implements Serializable{

	private int id;
	private String dia;
	private Time horaIngreso;
	private Time horaSalida;
	
	public Horario() {
		
	}
	public Horario(int id,String dia,Time horaIngreso,Time horaSalida) {
		this.id=id;
		this.dia=dia;
		this.horaIngreso=horaIngreso;
		this.horaSalida=horaSalida;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Time getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(Time horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public Time getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((horaIngreso == null) ? 0 : horaIngreso.hashCode());
		result = prime * result + ((horaSalida == null) ? 0 : horaSalida.hashCode());
		result = prime * result + id;
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
		Horario other = (Horario) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (horaIngreso == null) {
			if (other.horaIngreso != null)
				return false;
		} else if (!horaIngreso.equals(other.horaIngreso))
			return false;
		if (horaSalida == null) {
			if (other.horaSalida != null)
				return false;
		} else if (!horaSalida.equals(other.horaSalida))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Horario [id=" + id + ", dia=" + dia + ", horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida
				+ "]";
	}
	
	
	
	
}
