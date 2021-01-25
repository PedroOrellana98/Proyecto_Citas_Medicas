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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static ups.edu.ec.controlador.ControladorCitas.idCita;
import static ups.edu.ec.controlador.ControladorCitas.m;
import ups.edu.ec.modelo.Cita_Medica;
import ups.edu.ec.modelo.Medicamentos;
import ups.edu.ec.modelo.Prescripcion_Medica;

/**
 *
 * @author kevingodoy
 */
public class ControladorConsultas {
    public static int idMotivo;
    public static int idMedicamento;
    public static int idPrescripcion;
    public static Medicamentos m;
    public static Prescripcion_Medica p;
    Conexion conexionBD = new Conexion();
    
    public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM Motivo";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idMotivo = 0;

			while (rs.next()) {
				idMotivo = rs.getInt("idMotivo");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idMotivo;
	}// METODO OBTENER MAXIMA ID
    
     public JTextField BuscarPaciente(String cedula , JTextField nombre , JTextField apellido,JTextField telefono,JTextField direccion, JTextField correo) {// METODO BUSCAR CEDULA PACIENTE 

		conexionBD.getConnection();
                //"SELECT p.idPaciente,c.fecha,CONCAT(p.nombre, p.apellido)as nombres FROM Paciente p , CitaMedica c where p.idPaciente=c.Paciente_idPaciente And cedula = "+cedula+""
              try {
		String queryBuscarP = "SELECT idPaciente,nombre,apellido,telefono,direccion,correo FROM Paciente where cedula = "+cedula+"";
                Statement stmt = conexionBD.con.createStatement();
	        ResultSet rs = stmt.executeQuery(queryBuscarP);
               // psPaciente = conexionBD.con.prepareStatement(queryBuscarP);
               // psPaciente.setString(1, cedula);
                //psPaciente.execute();
                while (rs.next()) {
				System.out.println(rs.getInt("idPaciente") + "|" + rs.getString("nombre")+ rs.getString("apellido")+ rs.getString("telefono")+ rs.getString("direccion")+ rs.getString("correo"));
                                 nombre.setText(rs.getString("nombre"));
                                 apellido.setText(rs.getString("apellido"));
                                 telefono.setText(rs.getString("telefono"));
                                 direccion.setText(rs.getString("direccion"));
                                 correo.setText(rs.getString("correo"));
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
		
	}// METODO BUSCAR CEDULA PACIENTE 
    
     public boolean InsertarMotivo(String descripcion) {// METODO INSERTAR Motivo

		boolean banderaIngresoMotivo = false;

		conexionBD.getConnection();
		int idMotivo = ObtenerMaximaId();
		PreparedStatement psMotivo = null;

		String queryHorario = "INSERT INTO motivo (idMotivo, descripcion) values (?, ?)";

		try {

			idMotivo++;
			psMotivo = conexionBD.con.prepareStatement(queryHorario);

			psMotivo.setInt(1, idMotivo);
                        psMotivo.setString(2,descripcion); //Cita A=Asignada 
                        
                        
			psMotivo.executeUpdate();

			psMotivo.close();
			banderaIngresoMotivo = true;
                        JOptionPane.showMessageDialog(null, "Llamada agregada con exito a la base de datos.");
		
		} catch (SQLException e) {
			banderaIngresoMotivo = false;
			JOptionPane.showMessageDialog(null,"Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoMotivo;
	}// METODO INSERTAR Motivo
     
     public int ObtenerMaximaIdMedicamento() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM Medicamento";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idMedicamento = 0;

			while (rs.next()) {
				idMedicamento = rs.getInt("idMedicamento");
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idMedicamento;
	}// METODO OBTENER MAXIMA ID
     
     public boolean InsertarMedicamento(String nombre) {// METODO INSERTAR medicamento

		boolean banderaIngresoMedicamento = false;

		conexionBD.getConnection();
		int idMedicamento = ObtenerMaximaIdMedicamento();
		PreparedStatement psMedicamento = null;

		String queryHorario = "INSERT INTO Medicamento (idMedicamento, nombre) values (?, ?)";

		try {

			idMedicamento++;
			psMedicamento = conexionBD.con.prepareStatement(queryHorario);

			psMedicamento.setInt(1, idMedicamento);
                        psMedicamento.setString(2,nombre); //Cita A=Asignada 
                        
                        
			psMedicamento.executeUpdate();

			psMedicamento.close();
			banderaIngresoMedicamento = true;
                       // JOptionPane.showMessageDialog(null, "Llamada agregada con exito a la base de datos.");
		
		} catch (SQLException e) {
			banderaIngresoMedicamento = false;
			JOptionPane.showMessageDialog(null,"Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoMedicamento;
	}// METODO INSERTAR Medicamento
     
     public int ObtenerMaximaIdPrescripcion() {// METODO OBTENER MAXIMA ID

		conexionBD.getConnection();

		try {
			String SQL = "SELECT * FROM PrescripcionMedica";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			idPrescripcion = 0;

			while (rs.next()) {
				idPrescripcion = rs.getInt("idPrescripcionMedica");
                                
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idPrescripcion;
	}// METODO OBTENER MAXIMA ID
     
     public boolean InsertarPrescripcion(Date fecha,String dosis,String horas,String dias,String notas) {// METODO INSERTAR Prescripcion

		boolean banderaIngresoPrescripcion = false;
                

		conexionBD.getConnection();
		int idPrescripcion = ObtenerMaximaIdPrescripcion();
		PreparedStatement psPrescripcion = null;

		String queryHorario = "INSERT INTO PrescripcionMedica (idPrescripcionMedica,fecha,dosis,horas,dias,notas) values (?, ?, ?, ?, ?, ?)";

		try {

			idPrescripcion++;
			psPrescripcion = conexionBD.con.prepareStatement(queryHorario);

			psPrescripcion.setInt(1, idPrescripcion);
                        psPrescripcion.setDate(2, (java.sql.Date) fecha); //Cita A=Asignada 
                        psPrescripcion.setString(3, dosis); //Cita A=Asignada 
                        psPrescripcion.setString(4,horas);
                        psPrescripcion.setString(5,dias);
                        psPrescripcion.setString(6,notas);
                        
			psPrescripcion.executeUpdate();

			psPrescripcion.close();
			banderaIngresoPrescripcion = true;
                        JOptionPane.showMessageDialog(null, "Llamada agregada con exito a la base de datos.");
		
		} catch (SQLException e) {
			banderaIngresoPrescripcion = false;
			JOptionPane.showMessageDialog(null,"Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoPrescripcion;
	}// METODO INSERTAR Prescripcion
     
     public List<Medicamentos> MostrarMedicamentos() {// METODO MOSTRAR Citas
        conexionBD.getConnection();
        
       List medicamento = new ArrayList<Medicamentos>();
       
        try {
            String SQL = "Select nombre from medicamento";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
               
                m = new Medicamentos();
                m.setNombre(rs.getString("nombre"));
                
             //   m.setCit_paciente(MostrarPaciente().contains(cit_paciente));
               // m.setCit_medico(cit_medico.MostrarMedicos1());
                
                medicamento.add(m);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar");
            e.printStackTrace();
        }
        
        return medicamento;
    }
     
     public List<Prescripcion_Medica> MostrarPrescripcion() {// METODO MOSTRAR Citas
        conexionBD.getConnection();
        
       List prescripcion = new ArrayList<Prescripcion_Medica>();
       
        try {
            String SQL = "Select dosis,horas,dias from PrescripcionMedica";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
               
                p = new Prescripcion_Medica();
                p.setDosis(rs.getString("dosis"));
                p.setHoras(rs.getString("horas"));
                p.setDias(rs.getString("dias"));
                
             //   m.setCit_paciente(MostrarPaciente().contains(cit_paciente));
               // m.setCit_medico(cit_medico.MostrarMedicos1());
                
                prescripcion.add(p);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar");
            e.printStackTrace();
        }
        
        return prescripcion;
    }
    public JTextField BuscarMedicamento(String medicamento,JTextField nombre) {// METODO BUSCAR CEDULA PACIENTE 

		conexionBD.getConnection();
                //"SELECT p.idPaciente,c.fecha,CONCAT(p.nombre, p.apellido)as nombres FROM Paciente p , CitaMedica c where p.idPaciente=c.Paciente_idPaciente And cedula = "+cedula+""
              try {
		String queryBuscarP = "SELECT nombre from medicamento where nombre= '"+medicamento+" '";
                Statement stmt = conexionBD.con.createStatement();
	        ResultSet rs = stmt.executeQuery(queryBuscarP);
               // psPaciente = conexionBD.con.prepareStatement(queryBuscarP);
               // psPaciente.setString(1, cedula);
                //psPaciente.execute();
                while (rs.next()) {
				//System.out.println(rs.getString("nombre"));
                                nombre.setText(rs.getString("nombre"));
                               
                                 
                                 //fecha.setDate(rs.getDate("c.fecha"));
                                 
			}
                
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Medicamento no encontrado");
                        e.printStackTrace();
		}
                    
		return nombre;
	}// METODO BUSCAR CEDULA PACIENTE
}