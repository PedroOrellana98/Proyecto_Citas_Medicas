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
import ups.edu.ec.controlador.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.modelo.Paciente;

public class Pregistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellidos;
	private JTextField txtelefono;
	private JTextField txtcedula;
	private JTextField txtdireccion;
	private JTextField txtemail;
	private JTable tableusu;
	private JTextField txtbuscar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregistro frame = new Pregistro();
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
	public Pregistro() {
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
		lblNewLabel.setIcon(new ImageIcon(Pregistro.class.getResource("/imagen/icons8_User_96px_2.png")));
		panel.add(lblNewLabel);
		
		JButton btnvolver = new JButton("");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Psecretaria ps=new Psecretaria();
				ps.setVisible(true);
                                dispose();
			}
		});
		btnvolver.setIcon(new ImageIcon(Pregistro.class.getResource("/imagen/volver.png")));
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
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1.setBounds(10, 11, 56, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos:");
		lblNewLabel_1_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_1.setBounds(10, 56, 56, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefono:");
		lblNewLabel_1_2.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_2.setBounds(10, 97, 56, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cedula:");
		lblNewLabel_1_3.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_3.setBounds(347, 11, 46, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Direccion:");
		lblNewLabel_1_4.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_4.setBounds(347, 56, 64, 14);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email:");
		lblNewLabel_1_5.setForeground(new Color(210, 105, 30));
		lblNewLabel_1_5.setBounds(347, 97, 46, 14);
		panel_1.add(lblNewLabel_1_5);
		
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
		
		txtelefono = new JTextField();
		txtelefono.setToolTipText("");
		txtelefono.setColumns(10);
		txtelefono.setBorder(null);
		txtelefono.setBounds(75, 94, 179, 20);
		panel_1.add(txtelefono);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setForeground(new Color(192, 192, 192));
		separator_2_2.setBackground(Color.BLACK);
		separator_2_2.setBounds(75, 114, 179, 14);
		panel_1.add(separator_2_2);
		
		txtcedula = new JTextField();
		txtcedula.setToolTipText("");
		txtcedula.setColumns(10);
		txtcedula.setBorder(null);
		txtcedula.setBounds(401, 4, 179, 20);
		panel_1.add(txtcedula);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setForeground(new Color(192, 192, 192));
		separator_2_3.setBackground(Color.BLACK);
		separator_2_3.setBounds(401, 24, 179, 14);
		panel_1.add(separator_2_3);
		
		txtdireccion = new JTextField();
		txtdireccion.setToolTipText("");
		txtdireccion.setColumns(10);
		txtdireccion.setBorder(null);
		txtdireccion.setBounds(411, 49, 179, 20);
		panel_1.add(txtdireccion);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setForeground(new Color(192, 192, 192));
		separator_2_4.setBackground(Color.BLACK);
		separator_2_4.setBounds(411, 69, 179, 14);
		panel_1.add(separator_2_4);
		
		txtemail = new JTextField();
		txtemail.setToolTipText("");
		txtemail.setColumns(10);
		txtemail.setBorder(null);
		txtemail.setBounds(390, 94, 179, 20);
		panel_1.add(txtemail);
                
                JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 236, 662, 184);
		panel_1.add(scrollPane);
		
		JSeparator separator_2_5 = new JSeparator();
		separator_2_5.setForeground(new Color(192, 192, 192));
		separator_2_5.setBackground(Color.BLACK);
		separator_2_5.setBounds(390, 114, 179, 14);
		panel_1.add(separator_2_5);
		
		JButton btnregistrar = new JButton("Registrar");
		btnregistrar.setBackground(new Color(244, 164, 96));
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            ControladorPaciente cp = new ControladorPaciente();
                            cp.insertarPaciente(txtnombre.getText(), txtapellidos.getText(), txtelefono.getText(), 
                                    txtcedula.getText(), txtdireccion.getText(), txtemail.getText());
			}
		});
		btnregistrar.setBounds(142, 202, 89, 23);
		panel_1.add(btnregistrar);
		
		JButton btnRestablecer = new JButton("Limpiar");
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txtnombre.setText("");
                                 txtapellidos.setText("");
                                 txtcedula.setText("");
                                 txtbuscar.setText("");
                                 txtdireccion.setText("");
                                 txtelefono.setText("");
                                 txtemail.setText("");
			}
		});
		btnRestablecer.setBounds(22, 202, 89, 23);
		panel_1.add(btnRestablecer);
		btnRestablecer.setBackground(new Color(244, 164, 96));
		
		JButton btnNewButton_1 = new JButton("Listar");
                btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ControladorPaciente cp = new ControladorPaciente();
                DefaultTableModel modelo = new DefaultTableModel();
                List<Paciente> lista = cp.MostrarPaciente();
                String columna1 = "Nombre";
                String columna2 = "Apellido";
                String columna3 = "Cedula";
                String columna4 = "Correo";
                String columna5 = "Direccion";
                String columna6 = "Telefono";
                modelo.addColumn(columna1);
                modelo.addColumn(columna2);
                modelo.addColumn(columna3);
                modelo.addColumn(columna4);
                modelo.addColumn(columna5);
                modelo.addColumn(columna6);
                Object[] objeto = new Object[6];

                for (int i = 0; i < lista.size(); i++) {
                    objeto[0] = lista.get(i).getPer_nombre();
                    objeto[1] = lista.get(i).getPer_apellido();
                    objeto[2] = lista.get(i).getPer_cedula();
                    objeto[3] = lista.get(i).getPer_email();
                    objeto[4] = lista.get(i).getPer_direccion();
                    objeto[5] = lista.get(i).getPer_telefono();
                    modelo.addRow(objeto);
                }
                tableusu = new JTable();
                tableusu.setBorder(new LineBorder(new Color(218, 165, 32)));
                tableusu.setBackground(new Color(255, 255, 255));
                tableusu.setModel(modelo);
                scrollPane.setViewportView(tableusu);
                }
            });
		btnNewButton_1.setBounds(401, 202, 89, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ControladorPaciente cp = new ControladorPaciente();
                        cp.EliminarPaciente(txtbuscar.getText());
                        }
		});
		btnNewButton_2.setBounds(525, 202, 89, 23);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(244, 164, 96));
		
		JButton btnNewButton_1_1 = new JButton("Buscar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorPaciente cp  = new ControladorPaciente();
                                cp.BuscarPaciente(txtbuscar.getText());

                tableusu = new JTable();
                tableusu.setBorder(new LineBorder(new Color(218, 165, 32)));
                tableusu.setBackground(new Color(255, 255, 255));
                tableusu.setModel(new DefaultTableModel(
                        new Object[][]{
                            {cp.p.getPer_nombre(), cp.p.getPer_apellido(), cp.p.getPer_cedula(), cp.p.getPer_email(), cp.p.getPer_direccion(), cp.p.getPer_telefono()},},
                        new String[]{
                            "Nombres", "Apellidos", "Cedula", "Correo", "Direccion", "Telefono"
                        }
                ) {
                    Class[] columnTypes = new Class[]{
                        String.class, String.class, String.class, String.class, String.class, String.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                scrollPane.setViewportView(tableusu);
            }   	
		});
		btnNewButton_1_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1_1.setBounds(273, 202, 89, 23);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("");
		lblNewLabel_1_5_1.setIcon(new ImageIcon(Pregistro.class.getResource("/imagen/carnet.png")));
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
