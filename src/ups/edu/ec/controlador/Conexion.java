package ups.edu.ec.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;




public class Conexion {
	Connection con=null;
	public Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:8889/citas_medicas";
			String usuario="root";
			String clave="root";
			
			con = DriverManager.getConnection(url,usuario,clave);
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
		   System.out.println(rs.getString("idHorario") + "|" + rs.getString("horaIngreso")+ "|"+rs.getString("horaSalida"));
		}
		  rs.close();
		  stmt.close();
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
		}
	
	public void BorrarTupla(int id) {
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

}
