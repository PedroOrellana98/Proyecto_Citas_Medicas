package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class FacturaCabecera implements Serializable{

	private int id;
	private Date fecha;
	private double subtotal;
	private int iva;
	private double total;
	private boolean estado;
	private List<FacturaDetalle> facturadetalle;
	
	public FacturaCabecera() {
		
	}
	public FacturaCabecera(int id,Date fecha,double subtotal,int iva,double total,boolean estado,List<FacturaDetalle> facturadetalle) {
		this.id=id;
		this.fecha=fecha;
		this.subtotal=subtotal;
		this.iva=iva;
		this.total=total;
		this.estado=estado;
		this.facturadetalle=facturadetalle;
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
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((facturadetalle == null) ? 0 : facturadetalle.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + iva;
		long temp;
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FacturaCabecera other = (FacturaCabecera) obj;
		if (estado != other.estado)
			return false;
		if (facturadetalle == null) {
			if (other.facturadetalle != null)
				return false;
		} else if (!facturadetalle.equals(other.facturadetalle))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (iva != other.iva)
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FacturaCabecera [id=" + id + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva + ", total="
				+ total + ", estado=" + estado + ", facturadetalle=" + facturadetalle + "]";
	}
	
}
