/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;


import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ups.edu.ec.modelo.Cita_Medica;
import ups.edu.ec.modelo.Medico;
import ups.edu.ec.modelo.Paciente;
import ups.edu.ec.modelo.Secretaria;

/**
 *
 * @author kevingodoy
 */
public class ControladorCitas {
    public static int idCita;
    public static Cita_Medica m;
    private Secretaria secre;
    private Paciente cit_paciente;
    private Medico cit_medico;
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
        
        public List<Secretaria> MostrarSecre() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();

		List<Secretaria> med = new ArrayList<Secretaria>();
		secre = new Secretaria();
		
		try {
			String SQL = "select c.fecha,c.hora,CONCAT(s.nombre, s.apellido)as secretaria,CONCAT(p.nombre, p.apellido)as paciente ,CONCAT(m.nombre, m.apellido)as medico from CitaMedica c , Secretaria s ,Paciente p , Medico m where c.Secretaria_idSecretaria=s.idSecretaria And c.Paciente_idPaciente=p.idPaciente And c.Medico_idMedico=m.idMedico";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
			secre.setPer_nombre(rs.getString("secretaria"));
				
				med.add(secre);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
		return med;
	}
        
         public List<Paciente> MostrarPaciente() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();

		List<Paciente> med = new ArrayList<Paciente>();
		cit_paciente = new Paciente();
		
		try {
			String SQL = "select c.fecha,c.hora,CONCAT(s.nombre, s.apellido)as secretaria,CONCAT(p.nombre, p.apellido)as paciente ,CONCAT(m.nombre, m.apellido)as medico from CitaMedica c , Secretaria s ,Paciente p , Medico m where c.Secretaria_idSecretaria=s.idSecretaria And c.Paciente_idPaciente=p.idPaciente And c.Medico_idMedico=m.idMedico";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				cit_paciente.setPer_nombre(rs.getString("paciente"));
				
				med.add(cit_paciente);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
		return med;
	}
        
        
        public List<Cita_Medica> MostrarCitas() {// METODO MOSTRAR Citas
        conexionBD.getConnection();
        
       List citas = new ArrayList<Cita_Medica>();
       
        try {
            String SQL = "select c.fecha,c.hora,CONCAT(s.nombre, s.apellido)as secretaria,CONCAT(p.nombre, p.apellido)as paciente ,CONCAT(m.nombre, m.apellido)as medico from CitaMedica c , Secretaria s ,Paciente p , Medico m where c.Secretaria_idSecretaria=s.idSecretaria And c.Paciente_idPaciente=p.idPaciente And c.Medico_idMedico=m.idMedico";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
               
                m = new Cita_Medica();
                m.setCit_fecha(rs.getDate("c.fecha"));
                m.setCit_hora(rs.getString("c.hora"));
                
             //   m.setCit_paciente(MostrarPaciente().contains(cit_paciente));
               // m.setCit_medico(cit_medico.MostrarMedicos1());
                
                citas.add(m);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar");
            e.printStackTrace();
        }
        
        return citas;
    }

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
			psCita.setDate(2, (java.sql.Date) fecha);
			psCita.setTime(3, hora);
                        psCita.setInt(4, secretaria);
                        psCita.setInt(5, paciente);
                        psCita.setInt(6, medico);
                        psCita.setString(7,"A"); //Cita A=Asignada 
                        
                        
			psCita.executeUpdate();

			psCita.close();
			banderaIngresoCita = true;
                        JOptionPane.showMessageDialog(null, "Llamada agregada con exito a la base de datos.");
		
		} catch (SQLException e) {
			banderaIngresoCita = false;
			JOptionPane.showMessageDialog(null,"Error!, la llamada no pudo ser agregada a la base de datos.");
		}

		return banderaIngresoCita;
	}// METODO INSERTAR CITA
        public JTextField BuscarPaciente(String cedula , JTextField paciente , JTextField pacienteid) {// METODO BUSCAR CEDULA PACIENTE 

		conexionBD.getConnection();
                //"SELECT p.idPaciente,c.fecha,CONCAT(p.nombre, p.apellido)as nombres FROM Paciente p , CitaMedica c where p.idPaciente=c.Paciente_idPaciente And cedula = "+cedula+""
              try {
		String queryBuscarP = "SELECT idPaciente,CONCAT(nombre,apellido)as nombres FROM Paciente where cedula = "+cedula+"";
                Statement stmt = conexionBD.con.createStatement();
	        ResultSet rs = stmt.executeQuery(queryBuscarP);
               // psPaciente = conexionBD.con.prepareStatement(queryBuscarP);
               // psPaciente.setString(1, cedula);
                //psPaciente.execute();
                while (rs.next()) {
				System.out.println(rs.getInt("idPaciente") + "|" + rs.getString("nombres"));
                                 paciente.setText(rs.getString("nombres"));
                                 pacienteid.setText(String.valueOf(rs.getInt("idPaciente")));
                                 //fecha.setDate(rs.getDate("c.fecha"));
                                 
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Error!");
                        e.printStackTrace();
		}
                    return paciente;
		
	}// METODO BUSCAR CEDULA PACIENTE 
         public void BorrarTuplaCita(int idpaciente ,Date fecha) {
             conexionBD.getConnection();
		try
		{
	      String query = "delete from CitaMedica where Paciente_idPaciente = ? And fecha=? ";
	      PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);
	      preparedStmt.setInt(1, idpaciente);
              preparedStmt.setDate(2, (java.sql.Date) fecha);
	      // execute the preparedstatement
	      preparedStmt.execute();
	      System.out.println();
	      conexionBD.con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Error! ");
	      System.err.println(e.getMessage());
	    }
	
	}
            public JComboBox MostrarfechasPorId(JComboBox fechas,int idpaciente){
                conexionBD.getConnection();
           try {
			String SQL = "SELECT c.fecha FROM CitaMedica c , Paciente p where c.Paciente_idPaciente = p.idPaciente And p.idPaciente= "+idpaciente+" ";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
                        fechas.addItem("Seleccione una opción");
			while (rs.next()) {
				fechas.addItem(rs.getDate("c.fecha"));
                                
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
                
   
        return fechas;
}
    
}