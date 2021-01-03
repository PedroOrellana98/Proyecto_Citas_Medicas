package ups.edu.ec.controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Driver;


public class conexion {
	
	public Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost/citasmedicas";
			String usuario="root";
			String clave="admin";
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citasmedicas?useTimezone=true&serverTimezone=UTC", "root", "admin");
			
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
