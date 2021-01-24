package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ups.edu.ec.controlador.Conexion;
import ups.edu.ec.modelo.Especialidad;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JComboBox;

public class Pmedico extends JFrame {

	private JPanel contentPane;
	private JTextField mcodigo;
	private JTextField mtelefono;
	private JTextField mmedico;
	private JTextField memail;
	private JTextField mdireccion;
	private JTextField textField_6;
	private JComboBox mComboBox;
	private JTable tabmedico;
	protected Object txtEsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pmedico frame = new Pmedico();
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
	public Pmedico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 668, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pmedico.class.getResource("/imagen/doctor.png")));
		lblNewLabel.setBounds(161, 11, 84, 77);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registo Medico");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 17));
		lblNewLabel_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1.setBounds(255, 41, 156, 24);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 98, 668, 425);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Codigo:");
		lblNewLabel_1_1.setBounds(23, 18, 56, 14);
		lblNewLabel_1_1.setForeground(new Color(210, 105, 30));
		
		mcodigo = new JTextField();
		mcodigo.setBounds(88, 11, 179, 20);
		mcodigo.setToolTipText("");
		mcodigo.setColumns(10);
		mcodigo.setBorder(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(88, 31, 179, 14);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono:");
		lblNewLabel_1_3.setBounds(341, 18, 63, 14);
		lblNewLabel_1_3.setForeground(new Color(210, 105, 30));
		
		mtelefono = new JTextField();
		mtelefono.setBounds(414, 11, 179, 20);
		mtelefono.setToolTipText("");
		mtelefono.setColumns(10);
		mtelefono.setBorder(null);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBounds(414, 31, 179, 14);
		separator_2_3.setForeground(Color.LIGHT_GRAY);
		separator_2_3.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Medico:");
		lblNewLabel_1_1_1.setBounds(23, 63, 56, 14);
		lblNewLabel_1_1_1.setForeground(new Color(210, 105, 30));
		
		mmedico = new JTextField();
		mmedico.setBounds(88, 56, 179, 20);
		mmedico.setToolTipText("");
		mmedico.setColumns(10);
		mmedico.setBorder(null);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(88, 76, 179, 14);
		separator_2_1.setForeground(Color.LIGHT_GRAY);
		separator_2_1.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setBounds(360, 63, 64, 14);
		lblNewLabel_1_4.setForeground(new Color(210, 105, 30));
		
		memail = new JTextField();
		memail.setBounds(424, 56, 179, 20);
		memail.setToolTipText("");
		memail.setColumns(10);
		memail.setBorder(null);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setBounds(424, 76, 179, 14);
		separator_2_4.setForeground(Color.LIGHT_GRAY);
		separator_2_4.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direccion:");
		lblNewLabel_1_2.setBounds(23, 104, 56, 14);
		lblNewLabel_1_2.setForeground(new Color(210, 105, 30));
		
		mdireccion = new JTextField();
		mdireccion.setBounds(88, 101, 179, 20);
		mdireccion.setToolTipText("");
		mdireccion.setColumns(10);
		mdireccion.setBorder(null);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(88, 121, 179, 14);
		separator_2_2.setForeground(Color.LIGHT_GRAY);
		separator_2_2.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_5 = new JLabel("Especialidad");
		lblNewLabel_1_5.setBounds(341, 101, 76, 14);
		lblNewLabel_1_5.setForeground(new Color(210, 105, 30));
		
		JLabel lblNewLabel_1_5_1 = new JLabel("");
		lblNewLabel_1_5_1.setBounds(216, 149, 32, 35);
		lblNewLabel_1_5_1.setIcon(new ImageIcon(Pmedico.class.getResource("/imagen/carnet.png")));
		lblNewLabel_1_5_1.setForeground(new Color(210, 105, 30));
		
		textField_6 = new JTextField();
		textField_6.setBounds(251, 164, 179, 20);
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		
		JSeparator separator_2_5_1 = new JSeparator();
		separator_2_5_1.setBounds(251, 184, 179, 14);
		separator_2_5_1.setForeground(Color.LIGHT_GRAY);
		separator_2_5_1.setBackground(Color.BLACK);
		
		JButton btnRestablecer = new JButton("Restablecer");
		btnRestablecer.setBounds(23, 198, 89, 23);
		btnRestablecer.setBackground(new Color(244, 164, 96));
		
		JButton btnregistrar = new JButton("Registrar");
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel modelo=new DefaultTableModel();
				tabmedico.setModel(modelo);
				PreparedStatement ps = null;
		        try {
		        	
		        	
		            Conexion Con = new Conexion();
		            Connection con = Con.getConnection();
		            System.out.println("hola");
		            ps = con.prepareStatement("INSERT INTO medico (codigo,nombre,direccion,telefono,email,especialidad) VALUES (?,?,?,?,?,?)");
		            ps.setString(1, mcodigo.getText());
		            ps.setString(2, mmedico.getText());
		            ps.setString(3, mdireccion.getText());
		            ps.setString(4, mtelefono.getText());
		            ps.setString(5, memail.getText());
		            ps.setString(6, (String) mComboBox.getSelectedItem());

		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Medico Agregado");
		          
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Medico nO se Agrego");
		            System.out.println(ex);
		        }
			}
		});
		btnregistrar.setBounds(143, 198, 89, 23);
		btnregistrar.setBackground(new Color(244, 164, 96));
		
		JButton btnNewButton_1_1 = new JButton("Buscar");
		btnNewButton_1_1.setBounds(274, 198, 89, 23);
		btnNewButton_1_1.setBackground(new Color(244, 164, 96));
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setBounds(402, 198, 89, 23);
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(526, 198, 89, 23);
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 232, 668, 193);
		
		tabmedico = new JTable();
		tabmedico.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
			},
			new String[] {
				"Codigo", "Medico", "Direccion", "Telefono", "Email", "Especialidad"
			}
		));
		scrollPane.setViewportView(tabmedico);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1_1);
		panel_1.add(mcodigo);
		panel_1.add(separator_2);
		panel_1.add(lblNewLabel_1_3);
		panel_1.add(mtelefono);
		panel_1.add(separator_2_3);
		panel_1.add(lblNewLabel_1_5_1);
		panel_1.add(textField_6);
		panel_1.add(separator_2_5_1);
		panel_1.add(btnRestablecer);
		panel_1.add(btnregistrar);
		panel_1.add(btnNewButton_1_1);
		panel_1.add(btnNewButton_1);
		panel_1.add(btnNewButton_2);
		panel_1.add(lblNewLabel_1_1_1);
		panel_1.add(mmedico);
		panel_1.add(separator_2_1);
		panel_1.add(lblNewLabel_1_4);
		panel_1.add(memail);
		panel_1.add(separator_2_4);
		panel_1.add(lblNewLabel_1_2);
		panel_1.add(mdireccion);
		panel_1.add(lblNewLabel_1_5);
		panel_1.add(separator_2_2);
		panel_1.add(scrollPane);
		
		JComboBox mcomboBox = new JComboBox();
		ArrayList<String> lista=new ArrayList<String>();
		//lista = Conexion.llenarCombo();
		for (int i = 0; i < lista.size(); i++) {
			mcomboBox.addItem(lista.get(i));
		}
		mcomboBox.setBounds(414, 101, 172, 20);
		panel_1.add(mcomboBox);
	}
}
