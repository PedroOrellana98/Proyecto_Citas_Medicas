package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ups.edu.ec.controlador.*;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField buscare;
	private JTable tbespecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					busqueda frame = new busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public busqueda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 481, 275);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("");
		lblNewLabel_1_5_1.setBounds(120, 11, 32, 35);
		lblNewLabel_1_5_1.setIcon(new ImageIcon(busqueda.class.getResource("/imagen/carnet.png")));
		lblNewLabel_1_5_1.setForeground(new Color(210, 105, 30));
		
		buscare = new JTextField();
		buscare.setBounds(155, 26, 179, 20);
		buscare.setToolTipText("");
		buscare.setColumns(10);
		buscare.setBorder(null);
		
		JSeparator separator_2_5_1 = new JSeparator();
		separator_2_5_1.setBounds(155, 46, 179, 14);
		separator_2_5_1.setForeground(Color.LIGHT_GRAY);
		separator_2_5_1.setBackground(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 95, 482, 180);
		
		JButton btnRestablecer = new JButton("Listar");
		btnRestablecer.setBounds(135, 61, 59, 23);
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo=new DefaultTableModel();
					tbespecialidad.setModel(modelo);
					
					PreparedStatement ps = null;
					ResultSet rs=null; 
					conexion Con = new conexion();
		            Connection con = Con.getConnection();
		            
		            String sql="SELECT codigo,nombre FROM especialidades";
		            
		            ps=con.prepareStatement(sql);
		            rs=ps.executeQuery();
		            
		            ResultSetMetaData rsmd= rs.getMetaData();
		            
		            int cantidadColumnas = rsmd.getColumnCount();
		            
		            modelo.addColumn("codigo");
		            modelo.addColumn("nombre");
		            
		            while (rs.next()) {
						Object[] filas = new  Object[cantidadColumnas];
						
						for (int i=0;i<cantidadColumnas;i++) {
							filas[i]=rs.getObject(i+1);
							
						}
						
						modelo.addRow(filas);
					}
				} catch (SQLException ex) {
					System.err.println(ex.toString());
				}
			}
		});
		btnRestablecer.setBackground(new Color(244, 164, 96));
		
		JButton btnregistrar = new JButton("Agregar");
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmedico pm=new pmedico();
				if (tbespecialidad.getSelectedRow()>=0) {
					try {
						DefaultTableModel tm= (DefaultTableModel)tbespecialidad.getModel();
						int codigo= Integer.parseInt(String.valueOf(tm.getValueAt(tbespecialidad.getSelectedRow(),0)));
						String nombre =String.valueOf(tm.getValueAt(tbespecialidad.getSelectedRow(),1));
						
						buscare.setText(nombre);
						
						String f=buscare.getText();
						//pm.txtEsp.setText(f);
						System.out.print(f);
						

					} catch (Exception e2) {
						// TODO: handle exception
					}
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione una Especialidad","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnregistrar.setBounds(291, 61, 71, 23);
		btnregistrar.setBackground(new Color(244, 164, 96));
		
		JButton btnBuscarE = new JButton("Buscar");
		btnBuscarE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String campo = buscare.getText();
				String where="";
				if(!"".equals(campo)) {
					where= "WHERE codigo='"+campo +"'";				
				}
				
				try {
					DefaultTableModel modelo=new DefaultTableModel();
					tbespecialidad.setModel(modelo);
					
					PreparedStatement ps = null;
					ResultSet rs=null; 
					conexion Con = new conexion();
		            Connection con = Con.getConnection();
		            
		            String sql="SELECT codigo,nombre FROM especialidades "+ where;
		            
		            System.out.println(sql);
		            
		            ps=con.prepareStatement(sql);
		            rs=ps.executeQuery();
		            
		            ResultSetMetaData rsmd= rs.getMetaData();
		            
		            int cantidadColumnas = rsmd.getColumnCount();
		            
		            modelo.addColumn("codigo");
		            modelo.addColumn("especialidad");
		            
		            while (rs.next()) {
						Object[] filas = new  Object[cantidadColumnas];
						
						for (int i=0;i<cantidadColumnas;i++) {
							filas[i]=rs.getObject(i+1);
							
						}
						
						modelo.addRow(filas);
					}
				} catch (SQLException ex) {
					System.err.println(ex.toString());
				}
				
			}
		});
		btnBuscarE.setBounds(204, 61, 77, 23);
		btnBuscarE.setBackground(new Color(244, 164, 96));
		
		tbespecialidad = new JTable();
		tbespecialidad.setCellSelectionEnabled(true);
		tbespecialidad.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Codigo", "Especialidad"
			}
		));
		scrollPane.setViewportView(tbespecialidad);
		panel.setLayout(null);
		panel.add(lblNewLabel_1_5_1);
		panel.add(buscare);
		panel.add(separator_2_5_1);
		panel.add(btnRestablecer);
		panel.add(btnBuscarE);
		panel.add(btnregistrar);
		panel.add(scrollPane);
	}
}
