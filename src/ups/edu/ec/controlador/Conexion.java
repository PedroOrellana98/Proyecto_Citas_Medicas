package ups.edu.ec.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;




public class Conexion {
	Connection con=null;
	
	static Statement sentencia;
	static ResultSet resultado;
	public Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/citasmedicas?useTimezone=true&serverTimezone=UTC";
			String usuario="root";
			String clave="admin";
			
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
	
	public static ArrayList<String> llenarCombo() {
		ArrayList<String> lista=new ArrayList<String>();
		//String q="SELECT * FROM citasmedicas.especialidades;";
		
		try {
			PreparedStatement ps = null;
			ResultSet rs=null; 
			Conexion Con = new Conexion();
            Connection con = Con.getConnection();
            
            String sql="SELECT nombre FROM especialidades";
            
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsmd= rs.getMetaData();
            
            
            while (rs.next()) {
				lista.add(rs.getString("nombre"));
			}
		} catch (SQLException ex) {
			System.err.println(ex.toString());
		}
		
		/*try {
			resultado =sentencia.executeQuery(q);
			System.out.print("Correcto");
			System.out.print(resultado);
		} catch (Exception e) {
			System.out.print("Incorrecto no bale");
		}
		try {
			while (resultado.next()) {
				lista.add(resultado.getString("nombre"));			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		return lista;
		
	}

}
