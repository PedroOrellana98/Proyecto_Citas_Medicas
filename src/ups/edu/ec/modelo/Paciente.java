package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.List;

public class Paciente extends Persona implements Serializable {

	private int pac_id;
	private List<Examenes_Medicos> examenes;
	private List<Cita_Medica> citasMedicas;
	private List<FacturaCabecera> facturas;
	
	public Paciente() {
		
	}

	public Paciente(int pac_id,List<Examenes_Medicos> examenes,List<Cita_Medica> citasMedicas,List<FacturaCabecera> facturas) {
		this.pac_id=pac_id;
		this.examenes=examenes;
		this.citasMedicas=citasMedicas;
		this.facturas=facturas;
	}

	public int getPac_id() {
		return pac_id;
	}

	public void setPac_id(int pac_id) {
		this.pac_id = pac_id;
	}

	public List<Examenes_Medicos> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<Examenes_Medicos> examenes) {
		this.examenes = examenes;
	}

	public List<Cita_Medica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<Cita_Medica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public List<FacturaCabecera> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((citasMedicas == null) ? 0 : citasMedicas.hashCode());
		result = prime * result + ((examenes == null) ? 0 : examenes.hashCode());
		result = prime * result + ((facturas == null) ? 0 : facturas.hashCode());
		result = prime * result + pac_id;
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
		Paciente other = (Paciente) obj;
		if (citasMedicas == null) {
			if (other.citasMedicas != null)
				return false;
		} else if (!citasMedicas.equals(other.citasMedicas))
			return false;
		if (examenes == null) {
			if (other.examenes != null)
				return false;
		} else if (!examenes.equals(other.examenes))
			return false;
		if (facturas == null) {
			if (other.facturas != null)
				return false;
		} else if (!facturas.equals(other.facturas))
			return false;
		if (pac_id != other.pac_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [pac_id=" + pac_id + ", examenes=" + examenes + ", citasMedicas=" + citasMedicas
				+ ", facturas=" + facturas + "]";
	}

    public Medico toString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
