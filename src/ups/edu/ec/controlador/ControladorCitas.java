/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author kevingodoy
 */
public class ControladorCitas {
    public static int idCita;

	Conexion conexionBD = new Conexion();

	public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM CitaMedica";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idCita = 0;

			while (rs.next()) {
				idCita = rs.getInt("idCitaMedica");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCita;
	}// METODO OBTENER MAXIMA ID

	public void MostrarCita() {// METODO MOSTRAR CITA
		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM CitaMedica";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(
						rs.getInt("idCitaMedica") + "|" + rs.getTime("fecha") + "|" + rs.getTime("Hora")+rs.getInt("Secretaria_idSecretaria") + rs.getInt("Paciente_idPaciente") + rs.getInt("Medico_idMedico")+ rs.getInt("estado"));
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// METODO MOSTRAR HORARIO

    /**
     *
     * @param fecha
     * @param hora
     * @param secretaria
     * @param paciente
     * @param medico
     * @return
     */
    public boolean InsertarCita(Date fecha, Time hora , int secretaria,int paciente,int medico ) {// METODO INSERTAR CITA 

		boolean banderaIngresoCita = false;

		conexionBD.getConnection();
		int idCita = ObtenerMaximaId();
		PreparedStatement psCita = null;

		String queryHorario = "INSERT INTO CitaMedica (idCitaMedica, fecha, Hora,Secretaria_idSecretaria,Paciente_idPaciente,Medico_idMedico,estado) values (?, ?, ?, ?, ?, ?, ?)";

		try {

			idCita++;
			psCita = conexionBD.con.prepareStatement(queryHorario);

			psCita.setInt(1, idCita);
			psCita.setDate(2, fecha);
			psCita.setTime(3, hora);
                        psCita.setInt(4, secretaria);
                        psCita.setInt(5, paciente);
                        psCita.setInt(6, medico);
                        psCita.setString(7,"A"); //Cita A=Asignada 
                        
                        
			psCita.executeUpdate();

			psCita.close();
			banderaIngresoCita = true;
			System.out.println("Llamada agregada con exito a la base de datos.");
		} catch (SQLException e) {
			banderaIngresoCita = false;
			System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoCita;
	}// METODO INSERTAR CITA

    
}
