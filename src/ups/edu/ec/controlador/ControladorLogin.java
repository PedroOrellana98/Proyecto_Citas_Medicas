/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import ups.edu.ec.modelo.Medico;
import ups.edu.ec.modelo.Secretaria;

/**
 *
 * @author Pedro
 */
public class ControladorLogin {
    
     Conexion conexionBD = new Conexion();
    public static Medico m;
    public static Secretaria s;
    
    public boolean LoginMedico(String correo, String password) {
    conexionBD.getConnection();
        boolean bandera = false;
        m = new Medico();
        try {
            String SQL = "SELECT * FROM medico WHERE correo  = '" + correo + "' AND contrasena = '" + password + "'";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                m.setPer_email(rs.getString("correo"));
                bandera = true;
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No se encontro el medico");
            e.printStackTrace();
            bandera = false;
        }
        
        return bandera;
    }
    
    public boolean LoginSecretaria(String correo, String password) {
    conexionBD.getConnection();
        boolean bandera = false;
        s = new Secretaria();
        try {
            String SQL = "SELECT * FROM secretaria WHERE correo  = '" + correo + "' AND contraseña = '" + password + "'";
            Statement stmt = conexionBD.con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                s.setPer_email(rs.getString("correo"));
                bandera = true;
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No se encontro el medico");
            e.printStackTrace();
            bandera = false;
        }
        
        return bandera;
    }
    
}
