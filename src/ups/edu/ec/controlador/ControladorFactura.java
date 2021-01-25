package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ups.edu.ec.modelo.FacturaCabecera;
import ups.edu.ec.modelo.FacturaDetalle;

public class ControladorFactura {

    public static List<FacturaCabecera> facC;
    public static List<FacturaDetalle> facD;
    public static FacturaCabecera fC;
    public static FacturaDetalle fD;
    public static int idFacturaCabecera;
    public static int idFacturaDetalle;

    Conexion conexionBD = new Conexion();

    public int ObtenerMaximaIdCabecera() {// METODO OBTENER MAXIMA ID

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

        return idFacturaCabecera;
    }// METODO OBTENER MAXIMA ID

    public int ObtenerMaximaIdDetalle() {// METODO OBTENER MAXIMA ID

        conexionBD.getConnection();

        try {
            String SQL = "SELECT * FROM facturadetalle";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            idFacturaDetalle = 0;

            while (rs.next()) {
                idFacturaDetalle = rs.getInt("idFacturaDetalle");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idFacturaDetalle;
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

    public boolean InsertarFactura(Date fecha, float subtotal, float iva, float total, String estado,
            String descripcion, int idPaciente) {// METODO INSERTAR FACTURA

        boolean banderaIngresoFact = false;
        conexionBD.getConnection();
        int idFactura = ObtenerMaximaIdCabecera();
        int idFacturaDetalle = ObtenerMaximaIdDetalle();
        PreparedStatement psCabecera = null, psDetalle = null;

        String queryCabecera = "INSERT INTO facturacabecera (idFacturaCabecera, fecha, subTotal, iva, total, estado, paciente_idPaciente) values (?, ?, ?, ?, ?, ?, ?)";
        String queryDetalle = "INSERT INTO facturadetalle (idFacturaDetalle, descripcion, FacturaCabecera_idFacturaCabecera) values (?, ?, ?)";

        try {
            
            idFactura++;
            idFacturaDetalle++;
            psCabecera = conexionBD.con.prepareStatement(queryCabecera);
            psDetalle = conexionBD.con.prepareStatement(queryDetalle);

            /*if (estado.equals("T")) {
				idFacturaTest--;
				psCabecera.setInt(1, idFacturaTest);
				psDetalle.setInt(1, idFacturaTest);
				psDetalle.setInt(3, idFacturaTest);

			} else {
				idFactura++;
				psCabecera.setInt(1, idFactura);
				psDetalle.setInt(1, idFactura);
				psDetalle.setInt(3, idFactura);
			}*/
            psCabecera.setInt(1, idFactura);
            psCabecera.setDate(2, (java.sql.Date) fecha);
            psCabecera.setFloat(3, subtotal);
            psCabecera.setFloat(4, iva);
            psCabecera.setFloat(5, total);
            psCabecera.setString(6, estado);
            psCabecera.setInt(7, idPaciente);
            psCabecera.executeUpdate();

            psDetalle.setInt(1, idFacturaDetalle);
            psDetalle.setString(2, descripcion);
            psDetalle.setInt(3, idFactura);
            psDetalle.executeUpdate();

            psCabecera.close();
            psDetalle.close();

            banderaIngresoFact = true;
            System.out.println("Llamada agregada con éxito a la base de datos.");
        } catch (SQLException e) {
            banderaIngresoFact = false;
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }

        return banderaIngresoFact;
    }// MÉTODO INSERTAR FACTURA
    
    public List<FacturaCabecera> ListarFacturaCabecera() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        facC = new ArrayList<FacturaCabecera>();
        try {
            String SQL = "select * from facturacabecera fc, facturadetalle fd where "
                    + "fc.idFacturaCabecera = fd.FacturaCabecera_idFacturaCabecera";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                fC = new FacturaCabecera();
                fC.setFecha(rs.getDate("fecha"));
                fC.setSubtotal(rs.getFloat("subTotal"));
                fC.setIva(rs.getFloat("iva"));
                fC.setTotal(rs.getFloat("total"));
                facC.add(fC);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return facC;
    }
    
    public List<FacturaDetalle> ListarFacturaDetalle() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        facD = new ArrayList<FacturaDetalle>();
        try {
            String SQL = "select * from facturacabecera fc, facturadetalle fd where "
                    + "fc.idFacturaCabecera = fd.FacturaCabecera_idFacturaCabecera";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                fD = new FacturaDetalle();
                fD.setDescripcion(rs.getString("descripcion"));
                facD.add(fD);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return facD;
    }
}
