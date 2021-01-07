package ups.edu.ec.controlador;

import java.sql.ResultSet;
import java.sql.Statement;

public class ControladorFactura {

	public static int idFacturaCabecera;

	Conexion c = new Conexion();

	public void selectFacturaDetalle() {
		c.getConnection();

		try {
			String SQL = "SELECT * FROM facturadetalle";
			Statement stmt = c.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(
						rs.getInt("idFacturaDetalle") + "|" + rs.getString("descripcion") + "|" + idFacturaCabecera);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectFacturaCabecera() {
		c.getConnection();

		try {
			String SQL = "SELECT * FROM facturacabecera";
			Statement stmt = c.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				idFacturaCabecera = rs.getInt("idFacturaCabecera");
				System.out.println(idFacturaCabecera + "|" + rs.getDate("fecha") + "|"
						+ rs.getFloat("subtotal") + "|" + rs.getFloat("iva") + "|"
						+ rs.getFloat("total") + "|" + rs.getString("estado"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
