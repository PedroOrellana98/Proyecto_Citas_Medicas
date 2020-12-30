package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.List;

public class PlanDeCuentas implements Serializable {

	private int id_plan;
	private List<Cuenta> listaCuenta;
	
	public PlanDeCuentas() {
		
	}
	
	public PlanDeCuentas(int id_plan,List<Cuenta> listaCuenta) {
		this.id_plan=id_plan;
		this.listaCuenta=listaCuenta;
	}

	public int getId_plan() {
		return id_plan;
	}

	public void setId_plan(int id_plan) {
		this.id_plan = id_plan;
	}

	public List<Cuenta> getListaCuenta() {
		return listaCuenta;
	}

	public void setListaCuenta(List<Cuenta> listaCuenta) {
		this.listaCuenta = listaCuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_plan;
		result = prime * result + ((listaCuenta == null) ? 0 : listaCuenta.hashCode());
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
		PlanDeCuentas other = (PlanDeCuentas) obj;
		if (id_plan != other.id_plan)
			return false;
		if (listaCuenta == null) {
			if (other.listaCuenta != null)
				return false;
		} else if (!listaCuenta.equals(other.listaCuenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanDeCuentas [id_plan=" + id_plan + ", listaCuenta=" + listaCuenta + "]";
	}
	
	
}
