package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ups.edu.ec.modelo.Medico;

public class ControladorMedico {
	
	Conexion conexionBD = new Conexion();
	public static Medico m ;
	
	public void insertarMedico(int idMedico, String nombre, String apellido, String cedula, String correo, String contrasena, int idHorario) {

		
		conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Medico (idMedico, nombre, apellido, cedula, correo, contraseña, Horario_idHorario) values (?, ?, ?, ?, ?, ?, ?)";

        try {
          PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);
            
          preparedStmt.setInt       (1, idMedico);
          preparedStmt.setString    (2,nombre);
          preparedStmt.setString    (3, apellido);
          preparedStmt.setString    (4, cedula);
          preparedStmt.setString    (5, correo);
          preparedStmt.setString    (6, contrasena);
          preparedStmt.setInt       (7, idHorario);

            // Indicamos que comience la actualizaci�n de la tabla en nuestra base de datos
          preparedStmt.executeUpdate();

            // Cerramos las conexiones, en orden inverso a su apertura
            System.out.println("Llamada agregada con �xito a la base de datos.");
            JOptionPane.showMessageDialog(null, "Ingreso realizado con exito");
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
    }
	
	public void ListarMedicos() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();
		try {
			String SQL = "SELECT * FROM medico";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getInt("idMedico") + "|" + rs.getString("nombre") + "|"
						+ rs.getString("apellido") + "|" + rs.getString("cedula") + "|" + rs.getString("correo") + "|"
						+ rs.getString("contraseña") + "|" + rs.getString("Horario_idHorario"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Medico> MostrarMedicos() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();

		List<Medico> med = new ArrayList<Medico>();
		m = new Medico();
		
		try {
			String SQL = "SELECT * FROM medico";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				m.setPer_nombre(rs.getString("nombre"));
				m.setPer_apellido(rs.getString("apellido"));
				m.setPer_cedula(rs.getString("cedula"));
				m.setPer_email(rs.getString("correo"));
				med.add(m);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
		return med;
	}

}
