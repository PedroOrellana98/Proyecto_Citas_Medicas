package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class Ppagos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ppagos frame = new Ppagos();
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
	public Ppagos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 108, 442, 285);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Comprobante de Pago");
		lblNewLabel_1_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(124, 32, 206, 24);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Registro de Caja");
		lblNewLabel_1_2.setForeground(new Color(244, 164, 96));
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_1_2.setBounds(153, 106, 156, 24);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Transaccion ");
		lblNewLabel_1_3.setForeground(new Color(244, 164, 96));
		lblNewLabel_1_3.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_1_3.setBounds(124, 192, 156, 24);
		panel_1.add(lblNewLabel_1_3);
		
		JButton btnRegistro_1_1 = new JButton("");
		btnRegistro_1_1.setIcon(new ImageIcon(Ppagos.class.getResource("/imagen/cuenta.png")));
		btnRegistro_1_1.setBorder(null);
		btnRegistro_1_1.setBackground((Color) null);
		btnRegistro_1_1.setBounds(25, 0, 89, 86);
		panel_1.add(btnRegistro_1_1);
		
		JButton btnRegistro_1_1_1 = new JButton("");
		btnRegistro_1_1_1.setIcon(new ImageIcon(Ppagos.class.getResource("/imagen/cajero.png")));
		btnRegistro_1_1_1.setBorder(null);
		btnRegistro_1_1_1.setBackground((Color) null);
		btnRegistro_1_1_1.setBounds(307, 74, 89, 86);
		panel_1.add(btnRegistro_1_1_1);
		
		JButton btnRegistro_1_1_2 = new JButton("");
		btnRegistro_1_1_2.setIcon(new ImageIcon(Ppagos.class.getResource("/imagen/transaccion.png")));
		btnRegistro_1_1_2.setBorder(null);
		btnRegistro_1_1_2.setBackground((Color) null);
		btnRegistro_1_1_2.setBounds(25, 157, 89, 86);
		panel_1.add(btnRegistro_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 442, 109);
		contentPane.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(Ppagos.class.getResource("/imagen/tarjeta-de-debito.png")));
		lblNewLabel.setBounds(100, 23, 60, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresos");
		lblNewLabel_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 21));
		lblNewLabel_1.setBounds(187, 35, 156, 24);
		panel.add(lblNewLabel_1);
	}
}