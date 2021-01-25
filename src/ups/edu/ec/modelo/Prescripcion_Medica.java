package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Prescripcion_Medica implements Serializable{
	
	private int id;
	private Date fecha;
	private String dosis;
        private String horas;
        private String dias;
        private String notas;
	//private List<Medicamentos> medicamentos;
	
	public Prescripcion_Medica() {
		
	}
	
        public Prescripcion_Medica(int id , Date fecha,String dosis,String horas,String dias,String notas) {
		this.id=id;
                this.fecha=fecha;
                this.dosis=dosis;
                this.horas=horas;
                this.dias=dias;
                this.notas=notas;
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

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.fecha);
        hash = 53 * hash + Objects.hashCode(this.dosis);
        hash = 53 * hash + Objects.hashCode(this.horas);
        hash = 53 * hash + Objects.hashCode(this.dias);
        hash = 53 * hash + Objects.hashCode(this.notas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prescripcion_Medica other = (Prescripcion_Medica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dosis, other.dosis)) {
            return false;
        }
        if (!Objects.equals(this.horas, other.horas)) {
            return false;
        }
        if (!Objects.equals(this.dias, other.dias)) {
            return false;
        }
        if (!Objects.equals(this.notas, other.notas)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prescripcion_Medica{" + "id=" + id + ", fecha=" + fecha + ", dosis=" + dosis + ", horas=" + horas + ", dias=" + dias + ", notas=" + notas + '}';
    }
	
}
