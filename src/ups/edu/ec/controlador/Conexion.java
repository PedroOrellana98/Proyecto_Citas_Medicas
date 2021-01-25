package ups.edu.ec.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	Connection con = null;

	static Statement sentencia;
	static ResultSet resultado;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/citas_medicas2?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String clave = "Patito.123";

			con = DriverManager.getConnection(url, usuario, clave);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con la ====> BD");
			e.printStackTrace();
		}

		return con;

	}
	
}
