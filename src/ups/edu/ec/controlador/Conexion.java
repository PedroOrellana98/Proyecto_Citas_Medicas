package ups.edu.ec.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ups.edu.ec.modelo.Horario;

public class Conexion {
	Connection con = null;

	static Statement sentencia;
	static ResultSet resultado;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:8889/citas_medicas";
			String usuario = "root";
			String clave = "root";

			con = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Se conecto :)");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con la ====> BD");
			e.printStackTrace();
		}

		return con;

	}

	public void ejecutarConsulta() {
		try {
			String SQL = "SELECT * FROM Horario";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString("idHorario") + "|" + rs.getString("horaIngreso") + "|"
						+ rs.getString("horaSalida"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> llenarCombo() {
		ArrayList<String> lista = new ArrayList<String>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			Conexion Con = new Conexion();
			Connection con = Con.getConnection();

			String sql = "SELECT nombre FROM especialidades";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				lista.add(rs.getString("nombre"));
			}
		} catch (SQLException ex) {
			System.err.println(ex.toString());
		}
		
		
		return lista;
	}
	public void BorrarTuplaHorario(int id) {
		try
		{
	      String query = "delete from horario where idHorario = ?";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setInt(1, id);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      System.out.println();
	      con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Error! ");
	      System.err.println(e.getMessage());
	    }
	
	}
	
	public void BorrarTuplaMedico(int idMedico) {
		try
		{
	      String query = "delete from Medico where idMedico = ?";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setInt(1, idMedico);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      System.out.println();
	      con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Error! ");
	      System.err.println(e.getMessage());
	    }
	
	}
	public void insertarMedico(int idMedico, String nombre, String apellido, String cedula, String correo, String contraseña, int idHorario) {

	        // Crear sentencia SQL para insertar en la base de datos
	        String query = "INSERT INTO Medico (idMedico, nombre, apellido, cedula, correo, contraseña, Horario_idHorario) values (?, ?, ?, ?, ?, ?, ?)";

	        try {
	          PreparedStatement preparedStmt = con.prepareStatement(query);
	            
	          preparedStmt.setInt       (1, idMedico);
	          preparedStmt.setString    (2,nombre);
	          preparedStmt.setString    (3, apellido);
	          preparedStmt.setString    (4, cedula);
	          preparedStmt.setString    (5, correo);
	          preparedStmt.setString    (6, contraseña);
	          preparedStmt.setInt       (7, idHorario);

	            // Indicamos que comience la actualización de la tabla en nuestra base de datos
	          preparedStmt.executeUpdate();

	            // Cerramos las conexiones, en orden inverso a su apertura
	            System.out.println("Llamada agregada con éxito a la base de datos.");
	            con.close();
	        } catch (SQLException e) {
	            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
	        }
	    }
}
