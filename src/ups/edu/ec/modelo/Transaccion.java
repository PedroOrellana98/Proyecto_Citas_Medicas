package ups.edu.ec.modelo;

import java.io.Serializable;

public abstract class Transaccion implements Serializable {

	private int tran_id;
	private String tran_estado;
	private String tran_descripcion;
	private double montoParcial;
	private double montoTotal;
	
	public Transaccion () {
		
	}
	
	public Transaccion( int tran_id,String tran_estado,String tran_descripcion,double montoParcial,double montoTotal) {
		this.tran_id=tran_id;
		this.tran_estado=tran_estado;
		this.tran_descripcion=tran_descripcion;
		this.montoParcial=montoParcial;
		this.montoTotal=montoTotal;
	}
	

	public int getTran_id() {
		return tran_id;
	}

	public void setTran_id(int tran_id) {
		this.tran_id = tran_id;
	}

	public String getTran_estado() {
		return tran_estado;
	}

	public void setTran_estado(String tran_estado) {
		this.tran_estado = tran_estado;
	}

	public String getTran_descripcion() {
		return tran_descripcion;
	}

	public void setTran_descripcion(String tran_descripcion) {
		this.tran_descripcion = tran_descripcion;
	}

	public double getMontoParcial() {
		return montoParcial;
	}

	public void setMontoParcial(double montoParcial) {
		this.montoParcial = montoParcial;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(montoParcial);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(montoTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tran_descripcion == null) ? 0 : tran_descripcion.hashCode());
		result = prime * result + ((tran_estado == null) ? 0 : tran_estado.hashCode());
		result = prime * result + tran_id;
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
		Transaccion other = (Transaccion) obj;
		if (Double.doubleToLongBits(montoParcial) != Double.doubleToLongBits(other.montoParcial))
			return false;
		if (Double.doubleToLongBits(montoTotal) != Double.doubleToLongBits(other.montoTotal))
			return false;
		if (tran_descripcion == null) {
			if (other.tran_descripcion != null)
				return false;
		} else if (!tran_descripcion.equals(other.tran_descripcion))
			return false;
		if (tran_estado == null) {
			if (other.tran_estado != null)
				return false;
		} else if (!tran_estado.equals(other.tran_estado))
			return false;
		if (tran_id != other.tran_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaccion [tran_id=" + tran_id + ", tran_estado=" + tran_estado + ", tran_descripcion="
				+ tran_descripcion + ", montoParcial=" + montoParcial + ", montoTotal=" + montoTotal + "]";
	}
	
}
