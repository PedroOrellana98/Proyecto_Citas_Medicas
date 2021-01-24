package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.List;
import ups.edu.ec.modelo.*;

public class Medico extends Persona implements Serializable {

	private int me_id;
	private String me_especialidad;
	private Sueldo sueldo;
	private List <Horario> horario;
	private Paciente paciente;
	
	public Medico() {
		
	}

	public Medico(int me_id,String me_especialidad,Sueldo sueldo,List<Horario> horario,Paciente paciente) {
		this.me_id=me_id;
		this.me_especialidad=me_especialidad;
		this.sueldo=sueldo;
		this.horario=horario;
		this.paciente=paciente;
	}

	public int getMe_id() {
		return me_id;
	}

	public void setMe_id(int me_id) {
		this.me_id = me_id;
	}

	public String getMe_especialidad() {
		return me_especialidad;
	}

	public void setMe_especialidad(String me_especialidad) {
		this.me_especialidad = me_especialidad;
	}

	public Sueldo getSueldo() {
		return sueldo;
	}

	public void setSueldo(Sueldo sueldo) {
		this.sueldo = sueldo;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
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
		int result = super.hashCode();
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((me_especialidad == null) ? 0 : me_especialidad.hashCode());
		result = prime * result + me_id;
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((sueldo == null) ? 0 : sueldo.hashCode());
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
		Medico other = (Medico) obj;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (me_especialidad == null) {
			if (other.me_especialidad != null)
				return false;
		} else if (!me_especialidad.equals(other.me_especialidad))
			return false;
		if (me_id != other.me_id)
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (sueldo == null) {
			if (other.sueldo != null)
				return false;
		} else if (!sueldo.equals(other.sueldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [me_id=" + me_id + ", me_especialidad=" + me_especialidad + ", sueldo=" + sueldo + ", horario="
				+ horario + ", paciente=" + paciente + "]";
	}

    public Medico toString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
}
