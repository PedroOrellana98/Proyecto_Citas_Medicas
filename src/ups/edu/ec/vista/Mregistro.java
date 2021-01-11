package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import ups.edu.ec.controlador.*;
import ups.edu.ec.modelo.Medico;
import ups.edu.ec.controlador.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mregistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellidos;
	private JTextField txtcorreo;
	private JTextField txtcedula;
	private JTextField txtpassword;
	private JTable tableusu;
	private JTextField txtbuscar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mregistro frame = new Mregistro();
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
	public Mregistro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 662, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(283, 5, 96, 96);
		lblNewLabel.setIcon(new ImageIcon(Mregistro.class.getResource("/imagen/icons8_User_96px_2.png")));
		panel.add(lblNewLabel);
		
		JButton btnvolver = new JButton("");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Psecretaria ps=new Psecretaria();
				ps.setVisible(true);
			}
		});
		btnvolver.setIcon(new ImageIcon(Mregistro.class.getResource("/imagen/volver.png")));
		btnvolver.setBorder(null);
		btnvolver.setBackground((Color) null);
		btnvolver.setBounds(10, 5, 38, 40);
		panel.add(btnvolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 102, 662, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1.setBounds(10, 11, 56, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_1.setBounds(10, 56, 56, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cedula:");
		lblNewLabel_1_2.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_2.setBounds(10, 97, 56, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Correo:");
		lblNewLabel_1_3.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_3.setBounds(347, 11, 46, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Contraseña:");
		lblNewLabel_1_4.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_4.setBounds(347, 56, 64, 14);
		panel_1.add(lblNewLabel_1_4);
		
		
		txtnombre = new JTextField();
		txtnombre.setToolTipText("");
		txtnombre.setColumns(10);
		txtnombre.setBorder(null);
		txtnombre.setBounds(75, 4, 179, 20);
		panel_1.add(txtnombre);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(192, 192, 192));
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(75, 24, 179, 14);
		panel_1.add(separator_2);
		
		txtapellidos = new JTextField();
		txtapellidos.setToolTipText("");
		txtapellidos.setColumns(10);
		txtapellidos.setBorder(null);
		txtapellidos.setBounds(75, 49, 179, 20);
		panel_1.add(txtapellidos);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(new Color(192, 192, 192));
		separator_2_1.setBackground(Color.BLACK);
		separator_2_1.setBounds(75, 69, 179, 14);
		panel_1.add(separator_2_1);
		
		txtcedula = new JTextField();
		txtcedula.setToolTipText("");
		txtcedula.setColumns(10);
		txtcedula.setBorder(null);
		txtcedula.setBounds(75, 94, 179, 20);
		panel_1.add(txtcedula);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setForeground(new Color(192, 192, 192));
		separator_2_2.setBackground(Color.BLACK);
		separator_2_2.setBounds(75, 114, 179, 14);
		panel_1.add(separator_2_2);
		
		txtcorreo = new JTextField();
		txtcorreo.setToolTipText("");
		txtcorreo.setColumns(10);
		txtcorreo.setBorder(null);
		txtcorreo.setBounds(401, 4, 179, 20);
		panel_1.add(txtcorreo);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setForeground(new Color(192, 192, 192));
		separator_2_3.setBackground(Color.BLACK);
		separator_2_3.setBounds(401, 24, 179, 14);
		panel_1.add(separator_2_3);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setForeground(new Color(192, 192, 192));
		separator_2_4.setBackground(Color.BLACK);
		separator_2_4.setBounds(411, 69, 179, 14);
		panel_1.add(separator_2_4);
		
		txtpassword = new JTextField();
		txtpassword.setToolTipText("");
		txtpassword.setColumns(10);
		txtpassword.setBorder(null);
		txtpassword.setBounds(411, 49, 179, 20);
		panel_1.add(txtpassword);
		
		JButton btnregistrar = new JButton("Listar");
		btnregistrar.setBackground(new Color(244, 164, 96));
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 236, 662, 184);
				panel_1.add(scrollPane);
	
				List<Medico> med = new ArrayList<Medico>();
				ControladorMedico cm = new ControladorMedico();
				cm.MostrarMedicos();
				
				tableusu = new JTable();
				tableusu.setBorder(new LineBorder(new Color(218, 165, 32)));
				tableusu.setBackground(new Color(255, 255, 255));
				tableusu.setModel(new DefaultTableModel(
						
					new Object[][] {
						{cm.m.getPer_nombre(),cm.m.getPer_apellido(), cm.m.getPer_cedula(), cm.m.getPer_email()},
					},
					new String[] {
						"Nombres", "Apellidos", "Cedula", "Correo"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane.setViewportView(tableusu);
			}
		});
		btnregistrar.setBounds(342, 202, 89, 23);
		panel_1.add(btnregistrar);
		
		JButton btnRestablecer = new JButton("Registrar");
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorMedico cm = new ControladorMedico();
				cm.insertarMedico(1, txtnombre.getText(), txtapellidos.getText(), txtcedula.getText(), txtcorreo.getText(), txtpassword.getText(), 1);
			}
		});
		btnRestablecer.setBounds(242, 202, 89, 23);
		panel_1.add(btnRestablecer);
		btnRestablecer.setBackground(new Color(244, 164, 96));
		
		
		JLabel lblNewLabel_1_5_1 = new JLabel("");
		lblNewLabel_1_5_1.setIcon(new ImageIcon(Mregistro.class.getResource("/imagen/carnet.png")));
		lblNewLabel_1_5_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_5_1.setBounds(203, 142, 32, 35);
		panel_1.add(lblNewLabel_1_5_1);
		
		txtbuscar = new JTextField();
		txtbuscar.setToolTipText("");
		txtbuscar.setColumns(10);
		txtbuscar.setBorder(null);
		txtbuscar.setBounds(238, 157, 179, 20);
		panel_1.add(txtbuscar);
		
		JSeparator separator_2_5_1 = new JSeparator();
		separator_2_5_1.setForeground(Color.LIGHT_GRAY);
		separator_2_5_1.setBackground(Color.BLACK);
		separator_2_5_1.setBounds(238, 177, 179, 14);
		panel_1.add(separator_2_5_1);
	}
}
