package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorFactura {

	public static int idFacturaCabecera;

	Conexion c = new Conexion();

	public int ObtenerMaximaId() {

		c.getConnection();

		try {
			String SQL = "SELECT * FROM facturacabecera";
			Statement stmt = c.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idFacturaCabecera = 0;
			
			while (rs.next()) {
				idFacturaCabecera = rs.getInt("idFacturaCabecera");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idFacturaCabecera;
	}


	public void MostrarFacturas() {
		c.getConnection();

		try {
			String SQL = "SELECT * FROM facturacabecera fc, facturadetalle fd WHERE "
					+ "fc.idFacturaCabecera = fd.FacturaCabecera_idFacturaCabecera";
			Statement stmt = c.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getInt("idFacturaCabecera") + "|" + rs.getDate("fecha") + "|"
						+ rs.getFloat("subtotal") + "|" + rs.getFloat("iva") + "|" + rs.getFloat("total") + "|"
						+ rs.getString("estado") + "|" + rs.getString("descripcion"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void InsertarFactura(String fecha, float subtotal, float iva, float total, String estado, String descripcion) {

		c.getConnection();
		int idFactura = ObtenerMaximaId();
		PreparedStatement psCabecera = null, psDetalle = null;

		String queryCabecera = "INSERT INTO facturacabecera (idFacturaCabecera, fecha, subTotal, iva, total, estado) values (?, ?, ?, ?, ?, ?)";
		String queryDetalle = "INSERT INTO facturadetalle (idFacturaDetalle, descripcion, FacturaCabecera_idFacturaCabecera) values (?, ?, ?)";

		try {
			idFactura++;
			System.out.println(idFactura + " insertada");

			psCabecera = c.con.prepareStatement(queryCabecera);
			psDetalle = c.con.prepareStatement(queryDetalle);

			psCabecera.setInt(1, idFactura);
			psCabecera.setString(2, fecha);
			psCabecera.setFloat(3, subtotal);
			psCabecera.setFloat(4, iva);
			psCabecera.setFloat(5, total);
			psCabecera.setString(6, estado);
			psCabecera.executeUpdate();

			psDetalle.setInt(1, idFactura);
			psDetalle.setString(2, descripcion);
			psDetalle.setInt(3, idFactura);
			psDetalle.executeUpdate();

			psCabecera.close();
			psDetalle.close();

			System.out.println("Llamada agregada con éxito a la base de datos.");
		} catch (SQLException e) {
			System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
		}
	}

}
