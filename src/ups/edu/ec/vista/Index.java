package ups.edu.ec.vista;

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
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField Usuario;
	private JTextField textField;
	private JTextField txtCalendarioMedico;
	private JTextField txtRegistroPasiente;
	private JTextField txtAgendarCitasMedicas;
	private JTextField txtRegistroDeCitas;

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
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 514);
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

		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setBackground(new Color(244, 164, 96));
		lblNewLabel.setBounds(27, 209, 112, 20);
		panel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setForeground(new Color(244, 164, 96));
		lblPassword.setBackground(new Color(244, 164, 96));
		lblPassword.setBounds(27, 301, 112, 20);
		panel.add(lblPassword);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_User_96px_2.png")));
		lblNewLabel_1.setBounds(47, 59, 96, 116);
		panel.add(lblNewLabel_1);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 13));
		password.setBounds(60, 332, 146, 28);
		password.setBorder(null);
		panel.add(password);

		Usuario = new JTextField();
		Usuario.setToolTipText("");
		Usuario.setBounds(60, 251, 146, 20);
		Usuario.setBorder(null);
		panel.add(Usuario);
		Usuario.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_customer_32px_1.png")));
		lblNewLabel_2.setBounds(27, 240, 32, 31);
		panel.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(27, 271, 161, 14);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(27, 360, 161, 14);
		panel.add(separator_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_Key_32px.png")));
		lblNewLabel_3.setBounds(27, 332, 32, 26);
		panel.add(lblNewLabel_3);

		JButton entrar = new JButton("");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] clave = password.getPassword();

				String clavef = new String(clave);

				if (Usuario.getText().equals("Secretaria") && clavef.equals("admin")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Ingresando al sistema", "Ingresar",
							JOptionPane.INFORMATION_MESSAGE);
					Psecretaria ps = new Psecretaria();
					ps.setVisible(true);
					String inf = Usuario.getText();
					ps.secUsuario.setText(inf);
				} else {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		entrar.setIcon(new ImageIcon(Index.class.getResource("/imagen/Enter_OFF.png")));
		entrar.setBounds(47, 396, 125, 41);
		entrar.setBorder(null);
		panel.add(entrar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setBounds(219, 0, 423, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(149, 39, 179, 20);
		panel_1.add(textField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(149, 59, 161, 14);
		panel_1.add(separator_2);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_Search_32px_2.png")));
		lblNewLabel_4.setBounds(108, 30, 54, 32);
		panel_1.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(219, 72, 423, 403);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_Today_96px.png")));
		lblNewLabel_5.setBounds(75, 11, 101, 124);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(Index.class.getResource("/imagen/icons8_User_96px_2.png")));
		lblNewLabel_5_1.setBounds(258, 11, 101, 124);
		panel_2.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(Index.class.getResource("/imagen/agenda.png")));
		lblNewLabel_5_1_1.setBounds(75, 185, 101, 124);
		panel_2.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(Index.class.getResource("/imagen/yu (1).png")));
		lblNewLabel_5_1_1_1.setBounds(258, 185, 101, 124);
		panel_2.add(lblNewLabel_5_1_1_1);

		txtCalendarioMedico = new JTextField();
		txtCalendarioMedico.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtCalendarioMedico.setForeground(new Color(244, 164, 96));
		txtCalendarioMedico.setText("Calendario Medico");
		txtCalendarioMedico.setBounds(61, 136, 126, 20);
		txtCalendarioMedico.setBorder(null);
		panel_2.add(txtCalendarioMedico);
		txtCalendarioMedico.setColumns(10);

		txtRegistroPasiente = new JTextField();
		txtRegistroPasiente.setText("Registro Paciente");
		txtRegistroPasiente.setForeground(new Color(244, 164, 96));
		txtRegistroPasiente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtRegistroPasiente.setColumns(10);
		txtRegistroPasiente.setBorder(null);
		txtRegistroPasiente.setBounds(250, 136, 126, 20);
		panel_2.add(txtRegistroPasiente);

		txtAgendarCitasMedicas = new JTextField();
		txtAgendarCitasMedicas.setText("Agendar Citas Médicas");
		txtAgendarCitasMedicas.setForeground(new Color(244, 164, 96));
		txtAgendarCitasMedicas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtAgendarCitasMedicas.setColumns(10);
		txtAgendarCitasMedicas.setBorder(null);
		txtAgendarCitasMedicas.setBounds(44, 320, 143, 20);
		panel_2.add(txtAgendarCitasMedicas);

		txtRegistroDeCitas = new JTextField();
		txtRegistroDeCitas.setText("Registro de Citas Médicas");
		txtRegistroDeCitas.setForeground(new Color(244, 164, 96));
		txtRegistroDeCitas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtRegistroDeCitas.setColumns(10);
		txtRegistroDeCitas.setBorder(null);
		txtRegistroDeCitas.setBounds(250, 320, 126, 20);
		panel_2.add(txtRegistroDeCitas);
	}
}
