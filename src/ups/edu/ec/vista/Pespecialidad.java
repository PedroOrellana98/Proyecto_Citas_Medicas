package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ups.edu.ec.controlador.*;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Pespecialidad extends JFrame {

	private JPanel contentPane;
	private JTextField txtEspecialidades;
	private JLabel lblNewLabel_1;
	private JTextField txtcodigoe;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private JTextField txtenombre;
	private JSeparator separator_1;
	private JButton btnRestablecer;
	private JButton btnregistrar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable tespecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pespecialidad frame = new Pespecialidad();
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
	public Pespecialidad() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 552, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pespecialidad.class.getResource("/imagen/cientifico.png")));
		lblNewLabel.setBounds(144, 11, 85, 69);
		panel.add(lblNewLabel);
		
		txtEspecialidades = new JTextField();
		txtEspecialidades.setForeground(new Color(244, 164, 96));
		txtEspecialidades.setFont(new Font("Courier New", Font.PLAIN, 17));
		txtEspecialidades.setText("ESPECIALIDADES");
		txtEspecialidades.setToolTipText("");
		txtEspecialidades.setColumns(10);
		txtEspecialidades.setBorder(null);
		txtEspecialidades.setBounds(221, 35, 179, 20);
		panel.add(txtEspecialidades);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 112, 552, 328);
		contentPane.add(panel_1);
		
		lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setForeground(new Color(210, 105, 30));
		
		txtcodigoe = new JTextField();
		txtcodigoe.setToolTipText("");
		txtcodigoe.setColumns(10);
		txtcodigoe.setBorder(null);
		
		separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.BLACK);
		
		lblNewLabel_2 = new JLabel("Especialidad");
		lblNewLabel_2.setForeground(new Color(210, 105, 30));
		
		txtenombre = new JTextField();
		txtenombre.setToolTipText("");
		txtenombre.setColumns(10);
		txtenombre.setBorder(null);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.BLACK);
		
		btnRestablecer = new JButton("Restablecer");
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelo=new DefaultTableModel();
					tespecialidad.setModel(modelo);
					
					PreparedStatement ps = null;
					ResultSet rs=null; 
					Conexion Con = new Conexion();
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
		
		btnregistrar = new JButton("Registrar");
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo=new DefaultTableModel();
				tespecialidad.setModel(modelo);
				PreparedStatement ps = null;
		        try {
		        	
		        	
		            Conexion Con = new Conexion();
		            Connection con = Con.getConnection();
		            System.out.println("hola");
		            ps = con.prepareStatement("INSERT INTO especialidades (codigo,nombre) VALUES (?,?)");
		            ps.setString(1, txtcodigoe.getText());
		            ps.setString(2, txtenombre.getText());
		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Especialidad Agregado");
		          
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Especialidad nO se Agrego");
		            System.out.println(ex); 	
		        }
			}
		});
		btnregistrar.setBackground(new Color(244, 164, 96));
		
		btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(244, 164, 96));
		
		btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(39)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtcodigoe, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
							.addGap(43)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(76)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtenombre, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(21)
							.addComponent(btnRestablecer)
							.addGap(24)
							.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(55, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtcodigoe, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtenombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)))
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRestablecer)
						.addComponent(btnregistrar)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
		);
		
		tespecialidad = new JTable();
		tespecialidad.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Codigo", "Especialidad"
			}
		));
		tespecialidad.getColumnModel().getColumn(0).setPreferredWidth(15);
		scrollPane.setViewportView(tespecialidad);
		panel_1.setLayout(gl_panel_1);
	}
}
