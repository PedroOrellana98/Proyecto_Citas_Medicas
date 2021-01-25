package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pcomprobante extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pcomprobante frame = new Pcomprobante();
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
	public Pcomprobante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 585, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Comprobante de Pago");
		lblNewLabel_1.setBounds(214, 0, 206, 25);
		lblNewLabel_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 21));
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 38, 287, 92);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultario Buen Dia");
		lblNewLabel.setBounds(10, 0, 212, 34);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
		
		JLabel lblNewLabel_2 = new JLabel("Cuenca-Ecuador");
		lblNewLabel_2.setBounds(10, 45, 113, 25);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Direccion: Av. Solano y Remigio Crespo");
		lblNewLabel_2_1.setBounds(10, 62, 277, 25);
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 139, 302, 32);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de emision:");
		lblNewLabel_3.setBounds(0, 11, 119, 14);
		panel_3.add(lblNewLabel_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 5, 177, 20);
		panel_3.add(dateChooser);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 128, 128));
		panel_4.setBounds(334, 36, 219, 70);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Numero de Factura");
		lblNewLabel_4.setBounds(30, 5, 158, 20);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("CP 001");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(86, 25, 73, 34);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Buscar:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNewLabel_5.setBounds(334, 145, 58, 14);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBounds(384, 137, 121, 20);
		panel.add(textField_4);
		
		JSeparator separator_2_3_1 = new JSeparator();
		separator_2_3_1.setForeground(Color.LIGHT_GRAY);
		separator_2_3_1.setBackground(Color.BLACK);
		separator_2_3_1.setBounds(384, 157, 121, 14);
		panel.add(separator_2_3_1);
		
		JButton btnNewButton = new JButton("Ir");
		btnNewButton.setBounds(514, 139, 48, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 277, 577, 338);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("Buscar:");
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(187, 19, 58, 14);
		panel_1.add(lblNewLabel_5_1);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBounds(237, 11, 121, 20);
		panel_1.add(textField_5);
		
		JSeparator separator_2_3_1_1 = new JSeparator();
		separator_2_3_1_1.setForeground(Color.LIGHT_GRAY);
		separator_2_3_1_1.setBackground(Color.BLACK);
		separator_2_3_1_1.setBounds(237, 31, 121, 14);
		panel_1.add(separator_2_3_1_1);
		
		JButton btnNewButton_1 = new JButton("Ir");
		btnNewButton_1.setBounds(367, 13, 48, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 44, 577, 149);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"     CANT", "                           DESCRIPCION", "    PRECIO", "    TOTAL"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(17);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("SubTotal");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_6.setBounds(406, 204, 71, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBounds(468, 204, 99, 20);
		panel_1.add(textField_6);
		
		JSeparator separator_2_3_2 = new JSeparator();
		separator_2_3_2.setForeground(Color.LIGHT_GRAY);
		separator_2_3_2.setBackground(Color.BLACK);
		separator_2_3_2.setBounds(468, 224, 99, 14);
		panel_1.add(separator_2_3_2);
		
		JLabel lblNewLabel_6_1 = new JLabel("(+)12% IVA");
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(393, 237, 71, 14);
		panel_1.add(lblNewLabel_6_1);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("");
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBounds(468, 235, 99, 20);
		panel_1.add(textField_7);
		
		JSeparator separator_2_3_2_1 = new JSeparator();
		separator_2_3_2_1.setForeground(Color.LIGHT_GRAY);
		separator_2_3_2_1.setBackground(Color.BLACK);
		separator_2_3_2_1.setBounds(468, 255, 99, 14);
		panel_1.add(separator_2_3_2_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("NETO A PAGAR");
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_6_2.setBounds(356, 282, 108, 14);
		panel_1.add(lblNewLabel_6_2);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("");
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBounds(468, 280, 99, 20);
		panel_1.add(textField_8);
		
		JSeparator separator_2_3_2_2 = new JSeparator();
		separator_2_3_2_2.setForeground(Color.LIGHT_GRAY);
		separator_2_3_2_2.setBackground(Color.BLACK);
		separator_2_3_2_2.setBounds(468, 300, 99, 14);
		panel_1.add(separator_2_3_2_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 184, 577, 93);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres:");
		lblNewLabel_1_1.setBounds(33, 18, 56, 14);
		panel_5.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(210, 105, 30));
		
		textField = new JTextField();
		textField.setBounds(98, 11, 179, 20);
		panel_5.add(textField);
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(98, 31, 179, 14);
		panel_5.add(separator_2);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cedula:");
		lblNewLabel_1_3.setBounds(309, 18, 46, 14);
		panel_5.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setForeground(new Color(210, 105, 30));
		
		textField_1 = new JTextField();
		textField_1.setBounds(363, 11, 179, 20);
		panel_5.add(textField_1);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBounds(363, 31, 179, 14);
		panel_5.add(separator_2_3);
		separator_2_3.setForeground(Color.LIGHT_GRAY);
		separator_2_3.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_4 = new JLabel("Direccion:");
		lblNewLabel_1_4.setBounds(33, 60, 64, 14);
		panel_5.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setForeground(new Color(210, 105, 30));
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 53, 179, 20);
		panel_5.add(textField_2);
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setBounds(97, 73, 179, 14);
		panel_5.add(separator_2_4);
		separator_2_4.setForeground(Color.LIGHT_GRAY);
		separator_2_4.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefono:");
		lblNewLabel_1_2.setBounds(309, 56, 56, 14);
		panel_5.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(new Color(210, 105, 30));
		
		textField_3 = new JTextField();
		textField_3.setBounds(374, 53, 179, 20);
		panel_5.add(textField_3);
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(374, 73, 179, 14);
		panel_5.add(separator_2_2);
		separator_2_2.setForeground(Color.LIGHT_GRAY);
		separator_2_2.setBackground(Color.BLACK);
	}
}
