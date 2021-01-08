package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class ControladorHorario {
	
	public static int idHorario;

	Conexion c = new Conexion();
	
	public int ObtenerMaximaId() {

		c.getConnection();

		try {
			String SQL = "SELECT * FROM horario";
			Statement stmt = c.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idHorario = 0;
			
			while (rs.next()) {
				idHorario = rs.getInt("idHorario");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idHorario;
	}

	public void MostrarHorario() {
		c.getConnection();

		try {
			String SQL = "SELECT * FROM horario";
			Statement stmt = c.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getInt("idHorario") + "|" + rs.getTime("horaIngreso") + "|" + rs.getTime("horaSalida"));
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void InsertarHorario(Time horaIngreso, Time horaSalida) {

		c.getConnection();
		int idHorario = ObtenerMaximaId();
		PreparedStatement psHorario = null;

		String queryHorario = "INSERT INTO horario (idHorario, horaIngreso, horaSalida) values (?, ?, ?)";

		try {
			idHorario++;
			psHorario = c.con.prepareStatement(queryHorario);

			psHorario.setInt(1, idHorario);
			psHorario.setTime(2, horaIngreso);
			psHorario.setTime(3, horaSalida);
			psHorario.executeUpdate();

			psHorario.close();

			System.out.println("Llamada agregada con éxito a la base de datos.");
		} catch (SQLException e) {
			System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
		}
	}

}
