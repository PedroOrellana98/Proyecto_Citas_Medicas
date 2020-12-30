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
	
}
