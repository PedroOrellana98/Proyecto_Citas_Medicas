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
import ups.edu.ec.modelo.Paciente;

/**
 *
 * @author Pedro
 */
public class ControladorPaciente {
    
    Conexion conexionBD = new Conexion();
    public static Paciente p;
    public static int idPaciente;
    public static List<Paciente> pac;

    public int ObtenerMaximaId() {// METODO OBTENER MAXIMA ID

        conexionBD.getConnection();

        try {
            String SQL = "SELECT * FROM paciente";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            idPaciente = 0;

            while (rs.next()) {
                idPaciente = rs.getInt("idPaciente");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idPaciente;
    }

    public int ObtenerId(String nombre) {// METODO OBTENER MAXIMA ID

        conexionBD.getConnection();
        int id = 0;

        try {
            String SQL = "SELECT * FROM paciente where nombre = '" + nombre + "'";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            

            while (rs.next()) {
                id = rs.getInt("idPaciente");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
    
    public void insertarPaciente(String nombre, String apellido, String telefono, String cedula, String direccion, String correo) {

        conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Paciente (idPaciente, nombre, apellido, cedula, correo, direccion, telefono) values (?, ?, ?, ?, ?, ?, ?)";
        
        int id = ObtenerMaximaId();
        try {
            id++;
            PreparedStatement preparedStmt = conexionBD.con.prepareStatement(query);

            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, nombre);
            preparedStmt.setString(3, apellido);
            preparedStmt.setString(4, cedula);
            preparedStmt.setString(5, correo);
            preparedStmt.setString(6, direccion);
            preparedStmt.setString(7, telefono);

            // Indicamos que comience la actualización de la tabla en nuestra base de datos
            preparedStmt.executeUpdate();

            // Cerramos las conexiones, en orden inverso a su apertura
            System.out.println("Llamada agregada con éxito a la base de datos.");
            preparedStmt.close();
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
    }

    /*public List<Paciente> ListarMedicos() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        pac = new ArrayList<Paciente>();
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
    }*/

    public List<Paciente> MostrarPaciente() {// METODO MOSTRAR FACTURAS
        conexionBD.getConnection();

        pac = new ArrayList<Paciente>();
        try {
            String SQL = "SELECT * FROM paciente";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                p = new Paciente();
                p.setPer_nombre(rs.getString("nombre"));
                p.setPer_apellido(rs.getString("apellido"));
                p.setPer_cedula(rs.getString("cedula"));
                p.setPer_email(rs.getString("correo"));
                p.setPer_direccion(rs.getString("direccion"));
                p.setPer_telefono(rs.getString("telefono"));
                pac.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar");
            e.printStackTrace();
        }

        return pac;
    }

    public Paciente BuscarPaciente(String nombre) {
        conexionBD.getConnection();

        p = new Paciente();
        try {
            String SQL = "SELECT * FROM paciente WHERE nombre  = '" + nombre + "'";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                p.setPer_nombre(rs.getString("nombre"));
                p.setPer_apellido(rs.getString("apellido"));
                p.setPer_cedula(rs.getString("cedula"));
                p.setPer_email(rs.getString("correo"));
                p.setPer_direccion(rs.getString("direccion"));
                p.setPer_telefono(rs.getString("telefono"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el medico");
            e.printStackTrace();
        }

        return p;
    }

    public void EliminarPaciente(String nombre) {
        conexionBD.getConnection();
        // Crear sentencia SQL para insertar en la base de datos
        String query = "DELETE FROM paciente WHERE nombre  = ?";

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
    
}
