package ups.edu.ec.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ups.edu.ec.modelo.Medico;

public class ControladorSecretaria {
	
	Conexion conexionBD = new Conexion();
        public JComboBox MostrarSecretariaPorNombre(JComboBox secre){
         conexionBD.getConnection();
           try {
			String SQL = "SELECT idSecretaria ,CONCAT(nombre, apellido)as nombres FROM secretaria ";
			Statement stmt = conexionBD.con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
                        secre.addItem("Seleccione una opción");
			while (rs.next()) {
				secre.addItem(rs.getString("nombres"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo listar");
			e.printStackTrace();
		}
		
                
   
        return secre;
}
    

}


