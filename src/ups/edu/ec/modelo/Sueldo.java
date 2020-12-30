package ups.edu.ec.modelo;

import java.io.Serializable;

public class Sueldo implements Serializable {

	private int su_id;
	private double su_valor;
	private Secretaria secretaria;
	
	public Sueldo() {
		
	}

	public Sueldo(int su_id,double su_valor,Secretaria secretaria) {
		this.su_id=su_id;
		this.su_valor=su_valor;
		this.secretaria=secretaria;
		
	}

	public int getSu_id() {
		return su_id;
	}

	public void setSu_id(int su_id) {
		this.su_id = su_id;
	}

	public double getSu_valor() {
		return su_valor;
	}

	public void setSu_valor(double su_valor) {
		this.su_valor = su_valor;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((secretaria == null) ? 0 : secretaria.hashCode());
		result = prime * result + su_id;
		long temp;
		temp = Double.doubleToLongBits(su_valor);
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
		Sueldo other = (Sueldo) obj;
		if (secretaria == null) {
			if (other.secretaria != null)
				return false;
		} else if (!secretaria.equals(other.secretaria))
			return false;
		if (su_id != other.su_id)
			return false;
		if (Double.doubleToLongBits(su_valor) != Double.doubleToLongBits(other.su_valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sueldo [su_id=" + su_id + ", su_valor=" + su_valor + ", secretaria=" + secretaria + "]";
	}
	
	
}
