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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kevingodoy
 */
public class ControladorOrdenMedica {
    public static int idOrden;
    Conexion conexionBD = new Conexion();
    public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM ExamenesMedicos";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idOrden = 0;

			while (rs.next()) {
				idOrden = rs.getInt("idExamenesMedicos");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idOrden;
	}// METODO OBTENER MAXIMA ID
    public JTextField BuscarPaciente(String cedula , JTextField nombre , JTextField apellido,JTextField id) {// METODO BUSCAR CEDULA PACIENTE 

		conexionBD.getConnection();
                //"SELECT p.idPaciente,c.fecha,CONCAT(p.nombre, p.apellido)as nombres FROM Paciente p , CitaMedica c where p.idPaciente=c.Paciente_idPaciente And cedula = "+cedula+""
              try {
		String queryBuscarP = "SELECT idPaciente,nombre,apellido FROM Paciente where cedula = "+cedula+"";
                Statement stmt = conexionBD.con.createStatement();
	        ResultSet rs = stmt.executeQuery(queryBuscarP);
               // psPaciente = conexionBD.con.prepareStatement(queryBuscarP);
               // psPaciente.setString(1, cedula);
                //psPaciente.execute();
                while (rs.next()) {
				System.out.println(rs.getInt("idPaciente") + "|" + rs.getString("nombre")+ rs.getString("apellido"));
                                 nombre.setText(rs.getString("nombre"));
                                 apellido.setText(rs.getString("apellido"));
                                 id.setText(String.valueOf(rs.getInt("idPaciente")));
                                // pacienteid.setText(String.valueOf(rs.getInt("idPaciente")));
                                 //fecha.setDate(rs.getDate("c.fecha"));
                                 
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Error!");
                        e.printStackTrace();
		}
                    return nombre;
		
	}
    public boolean InsertarOrdenMedica(String descripcion,Date fecha,int medico,int paciente) {// METODO INSERTAR Motivo

		boolean banderaIngresoOrden = false;

		conexionBD.getConnection();
		int idExamenesMedicos = ObtenerMaximaId();
		PreparedStatement psOrden = null;

		String queryHorario = "INSERT INTO ExamenesMedicos (idExamenesMedicos,descripcion,fecha,Medico_idMedico,Paciente_idPaciente) values (?, ?, ?, ?, ?)";
                

		try {

			idExamenesMedicos++;
			psOrden = conexionBD.con.prepareStatement(queryHorario);

			psOrden.setInt(1, idExamenesMedicos);
                        psOrden.setString(2, descripcion);
                        psOrden.setDate(3, (java.sql.Date) fecha);
                        psOrden.setInt(4, medico);
                        psOrden.setInt(5, paciente);
                        
			psOrden.executeUpdate();

			psOrden.close();
			banderaIngresoOrden = true;
                        JOptionPane.showMessageDialog(null, "Llamada agregada con exito a la base de datos.");
		
		} catch (SQLException e) {
			banderaIngresoOrden = false;
                       // e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoOrden;
	}// METODO INSERTAR Motivo
    
    
    
}
