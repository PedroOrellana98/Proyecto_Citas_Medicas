package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorMedico {
	
	Conexion conexionBD = new Conexion();
	
	public void insertarMedico(int idMedico, String nombre, String apellido, String cedula, String correo, String contrase�a, int idHorario) {

		
		conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Medico (idMedico, nombre, apellido, cedula, correo, contrase�a, Horario_idHorario) values (?, ?, ?, ?, ?, ?, ?)";

        try {
          PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);
            
          preparedStmt.setInt       (1, idMedico);
          preparedStmt.setString    (2,nombre);
          preparedStmt.setString    (3, apellido);
          preparedStmt.setString    (4, cedula);
          preparedStmt.setString    (5, correo);
          preparedStmt.setString    (6, contrase�a);
          preparedStmt.setInt       (7, idHorario);

            // Indicamos que comience la actualizaci�n de la tabla en nuestra base de datos
          preparedStmt.executeUpdate();

            // Cerramos las conexiones, en orden inverso a su apertura
            System.out.println("Llamada agregada con �xito a la base de datos.");
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
    }
	
	public void MostrarMedicos() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM medico";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getInt("idMedico") + "|" + rs.getString("nombre") + "|"
						+ rs.getString("apellido") + "|" + rs.getString("cedula") + "|" + rs.getString("correo") + "|"
						+ rs.getString("contrase�a") + "|" + rs.getString("Horario_idHorario"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
