package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class FacturaCabecera implements Serializable{

	private int id;
	private Date fecha;
	private float subtotal;
	private float iva;
	private float total;
	private String estado;
	private List<FacturaDetalle> facturadetalle;
        
        public FacturaCabecera(){
            super();
        }

    public FacturaCabecera(int id, Date fecha, float subtotal, float iva, float total, String estado, List<FacturaDetalle> facturadetalle) {
        this.id = id;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
        this.facturadetalle = facturadetalle;
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<FacturaDetalle> getFacturadetalle() {
        return facturadetalle;
    }

    public void setFacturadetalle(List<FacturaDetalle> facturadetalle) {
        this.facturadetalle = facturadetalle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Float.floatToIntBits(this.subtotal);
        hash = 29 * hash + Float.floatToIntBits(this.iva);
        hash = 29 * hash + Float.floatToIntBits(this.total);
        hash = 29 * hash + Objects.hashCode(this.estado);
        hash = 29 * hash + Objects.hashCode(this.facturadetalle);
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
        final FacturaCabecera other = (FacturaCabecera) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.subtotal) != Float.floatToIntBits(other.subtotal)) {
            return false;
        }
        if (Float.floatToIntBits(this.iva) != Float.floatToIntBits(other.iva)) {
            return false;
        }
        if (Float.floatToIntBits(this.total) != Float.floatToIntBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.facturadetalle, other.facturadetalle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaCabecera{" + "id=" + id + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", estado=" + estado + ", facturadetalle=" + facturadetalle + '}';
    }

	
}
