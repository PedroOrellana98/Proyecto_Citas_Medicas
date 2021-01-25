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
import static ups.edu.ec.controlador.ControladorConsultas.idMotivo;

/**
 *
 * @author kevingodoy
 */
public class ControladorCertificados {
    public static int idCertificado;
    Conexion conexionBD = new Conexion();
    public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM certificado";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idCertificado = 0;

			while (rs.next()) {
				idCertificado = rs.getInt("idCertficado");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCertificado;
	}// METODO OBTENER MAXIMA ID
    public JTextField BuscarPaciente(String cedula , JTextField nombre , JTextField apellido) {// METODO BUSCAR CEDULA PACIENTE 

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
    public boolean InsertarCertificado(Date fecha_inicio,Date fecha_fin,String descripcion) {// METODO INSERTAR Motivo

		boolean banderaIngresoCertificado = false;

		conexionBD.getConnection();
		int idCertificado = ObtenerMaximaId();
		PreparedStatement psCertificado = null;

		String queryHorario = "INSERT INTO certificado (idCertificado, fecha_inicio,fecha_fin,descripcion) values (?, ?, ?, ?)";
                

		try {

			idCertificado++;
			psCertificado = conexionBD.con.prepareStatement(queryHorario);

			psCertificado.setInt(1, idCertificado);
                        psCertificado.setDate(2, (java.sql.Date) fecha_inicio); //Cita A=Asignada 
                        psCertificado.setDate(3, (java.sql.Date) fecha_fin);
                        psCertificado.setString(4, descripcion);
                        
			psCertificado.executeUpdate();

			psCertificado.close();
			banderaIngresoCertificado = true;
                        JOptionPane.showMessageDialog(null, "Llamada agregada con exito a la base de datos.");
		
		} catch (SQLException e) {
			banderaIngresoCertificado = false;
			JOptionPane.showMessageDialog(null,"Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoCertificado;
	}// METODO INSERTAR Motivo
}
