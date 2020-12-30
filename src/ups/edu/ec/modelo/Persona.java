package ups.edu.ec.modelo;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	private String per_cedula;
	private String per_nombre;
	private String per_apellido;
	private String per_direccion;
	private String per_telefono;
	private String per_email;
	
	public Persona() {
		
	}
	public Persona(String per_cedula,String per_nombre,String per_apellido,String per_direccion,String per_telefono,String per_email) {
		this.per_cedula=per_cedula;
		this.per_nombre=per_nombre;
		this.per_apellido=per_apellido;
		this.per_direccion=per_direccion;
		this.per_telefono=per_telefono;
		this.per_email=per_email;
	}
	public String getPer_cedula() {
		return per_cedula;
	}
	public void setPer_cedula(String per_cedula) {
		this.per_cedula = per_cedula;
	}
	public String getPer_nombre() {
		return per_nombre;
	}
	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}
	public String getPer_apellido() {
		return per_apellido;
	}
	public void setPer_apellido(String per_apellido) {
		this.per_apellido = per_apellido;
	}
	public String getPer_direccion() {
		return per_direccion;
	}
	public void setPer_direccion(String per_direccion) {
		this.per_direccion = per_direccion;
	}
	public String getPer_telefono() {
		return per_telefono;
	}
	public void setPer_telefono(String per_telefono) {
		this.per_telefono = per_telefono;
	}
	public String getPer_email() {
		return per_email;
	}
	public void setPer_email(String per_email) {
		this.per_email = per_email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((per_apellido == null) ? 0 : per_apellido.hashCode());
		result = prime * result + ((per_cedula == null) ? 0 : per_cedula.hashCode());
		result = prime * result + ((per_direccion == null) ? 0 : per_direccion.hashCode());
		result = prime * result + ((per_email == null) ? 0 : per_email.hashCode());
		result = prime * result + ((per_nombre == null) ? 0 : per_nombre.hashCode());
		result = prime * result + ((per_telefono == null) ? 0 : per_telefono.hashCode());
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
		Persona other = (Persona) obj;
		if (per_apellido == null) {
			if (other.per_apellido != null)
				return false;
		} else if (!per_apellido.equals(other.per_apellido))
			return false;
		if (per_cedula == null) {
			if (other.per_cedula != null)
				return false;
		} else if (!per_cedula.equals(other.per_cedula))
			return false;
		if (per_direccion == null) {
			if (other.per_direccion != null)
				return false;
		} else if (!per_direccion.equals(other.per_direccion))
			return false;
		if (per_email == null) {
			if (other.per_email != null)
				return false;
		} else if (!per_email.equals(other.per_email))
			return false;
		if (per_nombre == null) {
			if (other.per_nombre != null)
				return false;
		} else if (!per_nombre.equals(other.per_nombre))
			return false;
		if (per_telefono == null) {
			if (other.per_telefono != null)
				return false;
		} else if (!per_telefono.equals(other.per_telefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Persona [per_cedula=" + per_cedula + ", per_nombre=" + per_nombre + ", per_apellido=" + per_apellido
				+ ", per_direccion=" + per_direccion + ", per_telefono=" + per_telefono + ", per_email=" + per_email
				+ "]";
	}
	
	
}
