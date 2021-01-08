package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Especialidad implements Serializable {

	private int esp_id;
	private String esp_nombre;
	public List list = new ArrayList();
			
	public Especialidad() {
		
		
	}
	public Especialidad(int esp_id,String esp_nombre) {
		this.esp_id=esp_id;
		this.esp_nombre=esp_nombre;
		Especialidad e=new Especialidad();
		e.esp_id=esp_id;
		e.esp_nombre=esp_nombre;
		list.add(e);
	}
	public int getEsp_id() {
		return esp_id;
	}
	public void setEsp_id(int esp_id) {
		this.esp_id = esp_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + esp_id;
		result = prime * result + ((esp_nombre == null) ? 0 : esp_nombre.hashCode());
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
		Especialidad other = (Especialidad) obj;
		if (esp_id != other.esp_id)
			return false;
		if (esp_nombre == null) {
			if (other.esp_nombre != null)
				return false;
		} else if (!esp_nombre.equals(other.esp_nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Especialidad [esp_id=" + esp_id + ", esp_nombre=" + esp_nombre + "]";
	}
	
	
}
