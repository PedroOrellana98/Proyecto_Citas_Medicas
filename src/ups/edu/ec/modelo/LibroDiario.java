package ups.edu.ec.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class LibroDiario implements Serializable {

	private int lib_id;
	private Date lib_fecha;
	private List<PlanDeCuentas> listaPan;
	
	public LibroDiario() {
		
	}
	
	public LibroDiario(int lib_id,Date lib_fecha,List<PlanDeCuentas>listaPan) {
		this.lib_id=lib_id;
		this.lib_fecha=lib_fecha;
		this.listaPan=listaPan;
	}

	public int getLib_id() {
		return lib_id;
	}

	public void setLib_id(int lib_id) {
		this.lib_id = lib_id;
	}

	public Date getLib_fecha() {
		return lib_fecha;
	}

	public void setLib_fecha(Date lib_fecha) {
		this.lib_fecha = lib_fecha;
	}

	public List<PlanDeCuentas> getListaPan() {
		return listaPan;
	}

	public void setListaPan(List<PlanDeCuentas> listaPan) {
		this.listaPan = listaPan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lib_fecha == null) ? 0 : lib_fecha.hashCode());
		result = prime * result + lib_id;
		result = prime * result + ((listaPan == null) ? 0 : listaPan.hashCode());
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
		LibroDiario other = (LibroDiario) obj;
		if (lib_fecha == null) {
			if (other.lib_fecha != null)
				return false;
		} else if (!lib_fecha.equals(other.lib_fecha))
			return false;
		if (lib_id != other.lib_id)
			return false;
		if (listaPan == null) {
			if (other.listaPan != null)
				return false;
		} else if (!listaPan.equals(other.listaPan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibroDiario [lib_id=" + lib_id + ", lib_fecha=" + lib_fecha + ", listaPan=" + listaPan + "]";
	}
	
}
