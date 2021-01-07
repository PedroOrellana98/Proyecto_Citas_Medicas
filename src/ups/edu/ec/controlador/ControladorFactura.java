package ups.edu.ec.controlador;

import java.sql.ResultSet;
import java.sql.Statement;

public class ControladorFactura {

	Conexion c = new Conexion();
	
	public void ejecutarConsulta() {
		c.getConnection();

		try {
		   String SQL = "SELECT * FROM facturadetalle";
		   Statement stmt = c.con.createStatement();
		   ResultSet rs = stmt.executeQuery(SQL);

		   while (rs.next()) {
		   System.out.println(rs.getInt("idFacturaDetalle") + "|" + rs.getString("descripcion")+ "|"+rs.getInt("FacturaCabecera_idFacturaCabecera"));
		}
		  rs.close();
		  stmt.close();
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
		}

}
