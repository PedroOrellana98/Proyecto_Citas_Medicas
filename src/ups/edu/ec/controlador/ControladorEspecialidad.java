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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ups.edu.ec.modelo.Especialidad;

/**
 *
 * @author Pedro
 */
public class ControladorEspecialidad {
    
    Conexion conexionBD = new Conexion();
    public static Especialidad e;
    public static int idEspecialidad;
    public static List<Especialidad> esp;

    public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

        conexionBD.getConnection();

        try {
            String SQL = "SELECT * FROM especialidad";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            idEspecialidad = 0;

            while (rs.next()) {
                idEspecialidad = rs.getInt("idEspecilidad");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idEspecialidad;
    }

    public void insertarEspecialidad(String nombre) {

        conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Especialidad (idEspecialidad, nombre, Medico_idMedico, Medico_Horario_idHorario) values (?, ?, ?, ?)";
        
        int idHorario = ControladorHorario.idHorario;
        int idMedico = ControladorMedico.idMedico;
        idEspecialidad++;
        
        try {
            idHorario++;
            PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);

            preparedStmt.setInt(1, idEspecialidad);
            preparedStmt.setString(2, nombre);
            preparedStmt.setInt(3, idMedico);
            preparedStmt.setInt(4, idHorario);
            // Indicamos que comience la actualización de la tabla en nuestra base de datos
            preparedStmt.executeUpdate();

            // Cerramos las conexiones, en orden inverso a su apertura
            System.out.println("Llamada agregada con éxito a la base de datos.");
            JOptionPane.showMessageDialog(null, "Ingreso realizado con exito");
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
    }
    
    public List<Especialidad> ListarEspecialidades() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        esp = new ArrayList<Especialidad>();
        try {
            String SQL = "SELECT * FROM medico m, especialidad e, horario h where "
                    + "h.idHorario = Horario_idHorario AND m.idMedico = e.Medico_idMedico";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                e = new Especialidad();
                e.setEsp_nombre(rs.getString("e.nombre"));
                esp.add(e);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return esp;
    }
    
}
