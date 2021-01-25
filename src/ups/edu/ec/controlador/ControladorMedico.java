package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import ups.edu.ec.modelo.Especialidad;

import ups.edu.ec.modelo.Medico;
import ups.edu.ec.modelo.Horario;

public class ControladorMedico {

    Conexion conexionBD = new Conexion();
    public static Medico m;
    public static int idMedico;
    public static List<Medico> med;
    
    static Statement sentencia;
    static ResultSet resultado;
    

    public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

        conexionBD.getConnection();

        try {
            String SQL = "SELECT * FROM medico";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            idMedico = 0;

            while (rs.next()) {
                idMedico = rs.getInt("idMedico");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idMedico;
    }

    public void insertarMedico(String nombre, String apellido, String cedula, String correo, String contraseña) {

        conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Medico (idMedico, nombre, apellido, cedula, correo, contrasena, Horario_idHorario) values (?, ?, ?, ?, ?, ?, ?)";

        int idHorario = ControladorHorario.idHorario;
        idMedico++;
        try {
            idHorario++;
            PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);

            preparedStmt.setInt(1, idMedico);
            preparedStmt.setString(2, nombre);
            preparedStmt.setString(3, apellido);
            preparedStmt.setString(4, cedula);
            preparedStmt.setString(5, correo);
            preparedStmt.setString(6, contraseña);
            preparedStmt.setInt(7, idHorario);

            // Indicamos que comience la actualización de la tabla en nuestra base de datos
            preparedStmt.executeUpdate();

            // Cerramos las conexiones, en orden inverso a su apertura
            System.out.println("Llamada agregada con éxito a la base de datos.");
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
    }

    public List<Medico> ListarMedicos() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        med = new ArrayList<Medico>();
        try {
            String SQL = "SELECT * FROM medico m, especialidad e, horario h where "
                    + "h.idHorario = Horario_idHorario AND m.idMedico = e.Medico_idMedico";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                m = new Medico();
                m.setPer_nombre(rs.getString("m.nombre"));
                m.setPer_apellido(rs.getString("m.apellido"));
                m.setPer_cedula(rs.getString("m.cedula"));
                m.setPer_email(rs.getString("m.correo"));
                med.add(m);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return med;
    }

    public List<Medico> MostrarMedico() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        med = new ArrayList<Medico>();
        try {
            String SQL = "SELECT * FROM medico";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                m = new Medico();
                m.setPer_nombre(rs.getString("nombre"));
                m.setPer_apellido(rs.getString("apellido"));
                m.setPer_cedula(rs.getString("cedula"));
                m.setPer_email(rs.getString("correo"));
                med.add(m);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar");
            e.printStackTrace();
        }

        return med;
    }

    public Medico BuscarMedico(String nombre) {
        conexionBD.getConnection();

        m = new Medico();
        try {
            String SQL = "SELECT * FROM medico WHERE nombre  = '" + nombre + "'";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                m.setPer_nombre(rs.getString("nombre"));
                m.setPer_apellido(rs.getString("apellido"));
                m.setPer_cedula(rs.getString("cedula"));
                m.setPer_email(rs.getString("correo"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el medico");
            e.printStackTrace();
        }

        return m;
    }

    public void EliminarMedico(String nombre) {
        conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "DELETE FROM medico WHERE nombre  = ?";

        try {
            PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);

            preparedStmt.setString(1, nombre);

            // Indicamos que comience la actualización de la tabla en nuestra base de datos
            preparedStmt.executeUpdate();

            // Cerramos las conexiones, en orden inverso a su apertura
            System.out.println("Llamada agregada con éxito a la base de datos.");
            JOptionPane.showMessageDialog(null, "Eliminacion de registro realizada correctamente");
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
    }
    
            public List<Medico> MostrarMedicos1() {// METODO MOSTRAR FACTURAS
		conexionBD.getConnection();

		List<Medico> med = new ArrayList<Medico>();
		m = new Medico();
		
		try {
	                String SQL = "select c.fecha,c.hora,CONCAT(s.nombre, s.apellido)as secretaria,CONCAT(p.nombre, p.apellido)as paciente ,CONCAT(m.nombre, m.apellido)as medico from CitaMedica c , Secretaria s ,Paciente p , Medico m where c.Secretaria_idSecretaria=s.idSecretaria And c.Paciente_idPaciente=p.idPaciente And c.Medico_idMedico=m.idMedico";

			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				m.setPer_nombre(rs.getString("medico"));
				
				med.add(m);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
		return med;
	}
            
            public static ArrayList<String> llenarComboEspe() {
            	ArrayList<String> list=new ArrayList<String>();
            	String q ="SELECT * FROM  especialidades";
            	try {
					resultado = sentencia.executeQuery(q);	
					System.out.println("Correcto");
				} catch (Exception e) {
					System.out.println("Correcto");
				}
            	try {
					while (resultado.next()) {
						list.add(resultado.getString("nombre"));
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
            	
            	return list;
			}
            
        public JComboBox MostrarMedicosPorNombre(JComboBox medicos){
         conexionBD.getConnection();
           try {
			String SQL = "SELECT idMedico ,CONCAT(nombre, apellido)as nombres FROM medico ";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
                        medicos.addItem("Seleccione una opción");
			while (rs.next()) {
				medicos.addItem(rs.getString("nombres"));
                                
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
                
   
        return medicos;
}

}
