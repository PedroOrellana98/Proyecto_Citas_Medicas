package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Objects;

public class FacturaDetalle implements Serializable{

	private int idFacturaD;
        private String descripcion;
	private Cita_Medica cita;
	
	public FacturaDetalle(){
            super();
        }

    public FacturaDetalle(int idFacturaD, String descripcion, Cita_Medica cita) {
        this.idFacturaD = idFacturaD;
        this.descripcion = descripcion;
        this.cita = cita;
    }

    public int getIdFacturaD() {
        return idFacturaD;
    }

    public void setIdFacturaD(int idFacturaD) {
        this.idFacturaD = idFacturaD;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cita_Medica getCita() {
        return cita;
    }

    public void setCita(Cita_Medica cita) {
        this.cita = cita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idFacturaD;
        hash = 83 * hash + Objects.hashCode(this.descripcion);
        hash = 83 * hash + Objects.hashCode(this.cita);
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
        final FacturaDetalle other = (FacturaDetalle) obj;
        if (this.idFacturaD != other.idFacturaD) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.cita, other.cita)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" + "idFacturaD=" + idFacturaD + ", descripcion=" + descripcion + ", cita=" + cita + '}';
    }
        
        
}
