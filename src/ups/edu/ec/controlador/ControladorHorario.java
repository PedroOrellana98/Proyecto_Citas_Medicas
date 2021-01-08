package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class ControladorHorario {

	public static int idHorario;

	Conexion conexionBD = new Conexion();

	public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM horario";
			Statement stmt = conexionBD.con.createStatement();
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
	}// METODO OBTENER MAXIMA ID

	public void MostrarHorario() {// METODO MOSTRAR HORARIO
		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM horario";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(
						rs.getInt("idHorario") + "|" + rs.getTime("horaIngreso") + "|" + rs.getTime("horaSalida"));
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// METODO MOSTRAR HORARIO

	public boolean InsertarHorario(Time horaIngreso, Time horaSalida) {// METODO INSERTAR HORARIO

		boolean banderaIngresoHorario = false;

		conexionBD.getConnection();
		int idHorario = ObtenerMaximaId();
		PreparedStatement psHorario = null;

		String queryHorario = "INSERT INTO horario (idHorario, horaIngreso, horaSalida) values (?, ?, ?)";

		try {

			idHorario++;
			psHorario = conexionBD.con.prepareStatement(queryHorario);

			psHorario.setInt(1, idHorario);
			psHorario.setTime(2, horaIngreso);
			psHorario.setTime(3, horaSalida);
			psHorario.executeUpdate();

			psHorario.close();
			banderaIngresoHorario = true;
			System.out.println("Llamada agregada con éxito a la base de datos.");
		} catch (SQLException e) {
			banderaIngresoHorario = false;
			System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoHorario;
	}// METODO INSERTAR HORARIO

}
