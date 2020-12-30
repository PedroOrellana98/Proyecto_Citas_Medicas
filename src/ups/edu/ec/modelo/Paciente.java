package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.List;

public class Paciente extends Persona implements Serializable {

	private int pac_id;
	private List<Examen> examenes;
	private List<CitaMedica> citasMedicas;
	private List<FacturaCabecera> facturas;
	
	public Paciente() {
		
	}

	public Paciente(int pac_id,List<Examen> examenes,List<CitaMedica> citasMedicas,List<FacturaCabecera> facturas) {
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

	public List<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public List<FacturaCabecera> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}
	
	
}
