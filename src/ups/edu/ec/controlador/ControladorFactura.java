package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ups.edu.ec.test.ControladorFacturaTest;

public class ControladorFactura {

	public static int idFacturaCabecera;

	Conexion conexionBD = new Conexion();

	public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM facturacabecera";
			Statement stmt = conexionBD.con.createStatement();
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

		System.out.println("valor retornado: " + idFacturaCabecera);
		return idFacturaCabecera;
	}// METODO OBTENER MAXIMA ID

	public void MostrarFacturas() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM facturacabecera fc, facturadetalle fd WHERE "
					+ "fc.idFacturaCabecera = fd.FacturaCabecera_idFacturaCabecera";
			Statement stmt = conexionBD.con.createStatement();
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
	}// METODO MOSTRAR FACTURAS

	public boolean InsertarFactura(String fecha, float subtotal, float iva, float total, String estado,
			String descripcion) {// METODO INSERTAR FACTURA

		boolean banderaIngresoFact = false;
		conexionBD.getConnection();
		int idFactura = ObtenerMaximaId();
		int idFacturaTest = 0;
		PreparedStatement psCabecera = null, psDetalle = null;

		String queryCabecera = "INSERT INTO facturacabecera (idFacturaCabecera, fecha, subTotal, iva, total, estado) values (?, ?, ?, ?, ?, ?)";
		String queryDetalle = "INSERT INTO facturadetalle (idFacturaDetalle, descripcion, FacturaCabecera_idFacturaCabecera) values (?, ?, ?)";

		try {

			psCabecera = conexionBD.con.prepareStatement(queryCabecera);
			psDetalle = conexionBD.con.prepareStatement(queryDetalle);

			if (estado.equals("T")) {
				idFacturaTest--;
				psCabecera.setInt(1, idFacturaTest);
				psDetalle.setInt(1, idFacturaTest);
				psDetalle.setInt(3, idFacturaTest);

			} else {
				idFactura++;
				psCabecera.setInt(1, idFactura);
				psDetalle.setInt(1, idFactura);
				psDetalle.setInt(3, idFactura);
			}

			psCabecera.setString(2, fecha);
			psCabecera.setFloat(3, subtotal);
			psCabecera.setFloat(4, iva);
			psCabecera.setFloat(5, total);
			psCabecera.setString(6, estado);
			psCabecera.executeUpdate();

			psDetalle.setString(2, descripcion);
			psDetalle.executeUpdate();

			psCabecera.close();
			psDetalle.close();

			banderaIngresoFact = true;
			System.out.println("Llamada agregada con �xito a la base de datos.");
		} catch (SQLException e) {
			banderaIngresoFact = false;
			System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoFact;
	}// M�TODO INSERTAR FACTURA
}