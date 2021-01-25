package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class Ptransacciones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ptransacciones frame = new Ptransacciones();
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
	public Ptransacciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 488, 331);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Comprobante de Pago");
		lblNewLabel_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 21));
		lblNewLabel_1.setBounds(183, 21, 206, 25);
		panel.add(lblNewLabel_1);
		
		JButton btn = new JButton("");
		btn.setIcon(new ImageIcon(Ptransacciones.class.getResource("/imagen/tarjeta-de-debito.png")));
		btn.setForeground(Color.WHITE);
		btn.setBorder(null);
		btn.setBackground(Color.WHITE);
		btn.setBounds(110, 0, 69, 73);
		panel.add(btn);
		
		JLabel lblNewLabel = new JLabel("Numero de Cuenta:");
		lblNewLabel.setBounds(57, 114, 105, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Valor a depositar:");
		lblNewLabel_2.setBounds(57, 162, 94, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(161, 111, 179, 20);
		panel.add(textField);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setForeground(Color.LIGHT_GRAY);
		separator_2_3.setBackground(Color.BLACK);
		separator_2_3.setBounds(161, 131, 179, 14);
		panel.add(separator_2_3);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(161, 159, 179, 20);
		panel.add(textField_1);
		
		JSeparator separator_2_3_1 = new JSeparator();
		separator_2_3_1.setForeground(Color.LIGHT_GRAY);
		separator_2_3_1.setBackground(Color.BLACK);
		separator_2_3_1.setBounds(161, 179, 179, 14);
		panel.add(separator_2_3_1);
		
		JButton btnNewButton_1_1 = new JButton("Transferir");
		btnNewButton_1_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1_1.setBounds(183, 238, 89, 23);
		panel.add(btnNewButton_1_1);
	}
}
