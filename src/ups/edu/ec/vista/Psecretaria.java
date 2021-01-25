package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;

public class Psecretaria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtCalendarioMedico;
	private JTextField txtRegistroPasiente;
	private JTextField txtAgendarCitasMedicas;
	private JTextField txtRegistroDeCitas;
	private JTextField txtRegistroEspecialidad;
	private JTextField txtRegistroMedico;
	JTextField secUsuario;
	private JTextField txtPagos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public  Psecretaria() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 952, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(255, 0, 0)));
		panel.setBounds(0, 0, 221, 475);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_User_96px_2.png")));
		lblNewLabel_1.setBounds(63, 59, 96, 116);
		panel.add(lblNewLabel_1);
		
		secUsuario = new JTextField();
		secUsuario.setToolTipText("");
		secUsuario.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 24));
		secUsuario.setEditable(false);
		secUsuario.setDropMode(DropMode.INSERT);
		secUsuario.setColumns(10);
		secUsuario.setBorder(null);
		secUsuario.setBackground(Color.WHITE);
		secUsuario.setBounds(47, 207, 146, 42);
		panel.add(secUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Psecretaria.class.getResource("/imagen/pizarra.png")));
		lblNewLabel.setBounds(47, 270, 146, 142);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setBounds(219, 0, 717, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(267, 28, 179, 20);
		panel_1.add(textField);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(267, 48, 161, 14);
		panel_1.add(separator_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_Search_32px_2.png")));
		lblNewLabel_4.setBounds(226, 19, 54, 32);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(219, 72, 717, 403);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_Today_96px.png")));
		lblNewLabel_5.setBounds(417, 185, 101, 124);
		panel_2.add(lblNewLabel_5);
                
                JButton btnRegistroM = new JButton("");
		btnRegistroM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCitas rc = new RegistroCitas();
				rc.setVisible(true);
                                dispose();
			}
		});
		btnRegistroM.setIcon(new ImageIcon(Psecretaria.class.getResource("/imagen/agenda.png")));
		btnRegistroM.setBackground(null);
		btnRegistroM.setBorder(null);
		btnRegistroM.setBounds(75, 185, 101, 124);
		panel_2.add(btnRegistroM);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(Index.class.getResource("/imagen/yu (1).png")));
		lblNewLabel_5_1_1_1.setBounds(258, 185, 101, 124);
		panel_2.add(lblNewLabel_5_1_1_1);
		
		txtCalendarioMedico = new JTextField();
		txtCalendarioMedico.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtCalendarioMedico.setForeground(new Color(244, 164, 96));
		txtCalendarioMedico.setText("Calendario Medico");
		txtCalendarioMedico.setBounds(396, 320, 126, 20);
		txtCalendarioMedico.setBorder(null);
		panel_2.add(txtCalendarioMedico);
		txtCalendarioMedico.setColumns(10);
		
		txtRegistroPasiente = new JTextField();
		txtRegistroPasiente.setText("Registro Pasiente");
		txtRegistroPasiente.setForeground(new Color(244, 164, 96));
		txtRegistroPasiente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtRegistroPasiente.setColumns(10);
		txtRegistroPasiente.setBorder(null);
		txtRegistroPasiente.setBounds(250, 136, 126, 20);
		panel_2.add(txtRegistroPasiente);
		
		txtAgendarCitasMedicas = new JTextField();
		txtAgendarCitasMedicas.setText("Agendar Citas medicas");
		txtAgendarCitasMedicas.setForeground(new Color(244, 164, 96));
		txtAgendarCitasMedicas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtAgendarCitasMedicas.setColumns(10);
		txtAgendarCitasMedicas.setBorder(null);
		txtAgendarCitasMedicas.setBounds(44, 320, 143, 20);
		panel_2.add(txtAgendarCitasMedicas);
		
		txtRegistroDeCitas = new JTextField();
		txtRegistroDeCitas.setText("Registro de Citas medicas");
		txtRegistroDeCitas.setForeground(new Color(244, 164, 96));
		txtRegistroDeCitas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtRegistroDeCitas.setColumns(10);
		txtRegistroDeCitas.setBorder(null);
		txtRegistroDeCitas.setBounds(227, 320, 149, 20);
		panel_2.add(txtRegistroDeCitas);
		
		JButton btnRegistro = new JButton("");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pregistro pr = new Pregistro();
				pr.setVisible(true);
                                dispose();
			}
		});
		btnRegistro.setIcon(new ImageIcon(Psecretaria.class.getResource("/imagen/icons8_User_96px_2.png")));
		btnRegistro.setBackground(null);
		btnRegistro.setBorder(null);
		btnRegistro.setBounds(258, 39, 89, 86);
		panel_2.add(btnRegistro);
		
		JButton btnRegistro_1 = new JButton("");
		btnRegistro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Factura f = new Factura();
                                f.setVisible(true);
                                dispose();
			}
		});
		btnRegistro_1.setIcon(new ImageIcon(Psecretaria.class.getResource("/imagen/cuenta.png")));
		btnRegistro_1.setBorder(null);
		btnRegistro_1.setBackground((Color) null);
		btnRegistro_1.setBounds(418, 39, 89, 86);
		panel_2.add(btnRegistro_1);
		
		txtRegistroEspecialidad = new JTextField();
		txtRegistroEspecialidad.setText("Registro Factura");
		txtRegistroEspecialidad.setForeground(new Color(244, 164, 96));
		txtRegistroEspecialidad.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtRegistroEspecialidad.setColumns(10);
		txtRegistroEspecialidad.setBorder(null);
		txtRegistroEspecialidad.setBounds(396, 136, 143, 20);
		panel_2.add(txtRegistroEspecialidad);
		
		JButton btnRegistro_1_1 = new JButton("");
		btnRegistro_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mregistro pm=new Mregistro();
				pm.setVisible(true);
                                dispose();
			}
		});
		btnRegistro_1_1.setIcon(new ImageIcon(Psecretaria.class.getResource("/imagen/doctor.png")));
		btnRegistro_1_1.setBorder(null);
		btnRegistro_1_1.setBackground((Color) null);
		btnRegistro_1_1.setBounds(75, 39, 89, 86);
		panel_2.add(btnRegistro_1_1);
		
		txtRegistroMedico = new JTextField();
		txtRegistroMedico.setText("Registro Medico");
		txtRegistroMedico.setForeground(new Color(244, 164, 96));
		txtRegistroMedico.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtRegistroMedico.setColumns(10);
		txtRegistroMedico.setBorder(null);
		txtRegistroMedico.setBounds(75, 136, 126, 20);
		panel_2.add(txtRegistroMedico);
		
		JButton btnPago = new JButton("");
                btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppagos p=new Ppagos();
				p.setVisible(true);
                                dispose();
			}
		});
		btnPago.setIcon(new ImageIcon(Psecretaria.class.getResource("/imagen/tarjeta-de-debito.png")));
		btnPago.setBorder(null);
		btnPago.setBackground((Color) null);
		btnPago.setBounds(547, 39, 89, 86);
		panel_2.add(btnPago);
		
                
                
		txtPagos = new JTextField();
		txtPagos.setText("Pagos");
		txtPagos.setForeground(new Color(244, 164, 96));
		txtPagos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtPagos.setColumns(10);
		txtPagos.setBorder(null);
		txtPagos.setBounds(571, 136, 54, 20);
		panel_2.add(txtPagos);
	}
}
