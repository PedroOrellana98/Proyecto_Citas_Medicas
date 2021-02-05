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
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Label;
import javax.swing.JComboBox;

public class pmedico1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pmedico1 frame = new pmedico1();
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
	public pmedico1() {
		setBackground(new Color(240, 240, 240));
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
		
		JLabel lblNewLabel_1 = new JLabel("Registo");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 17));
		lblNewLabel_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1.setBounds(255, 41, 156, 24);
		panel.add(lblNewLabel_1);
		
		JButton btn = new JButton("");
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn.setIcon(new ImageIcon(pmedico1.class.getResource("/imagen/doctor (1).png")));
		btn.setBorder(null);
		btn.setBackground(Color.WHITE);
		btn.setBounds(149, 11, 89, 86);
		panel.add(btn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 98, 668, 425);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Codigo:");
		lblNewLabel_1_1.setBounds(23, 18, 56, 14);
		lblNewLabel_1_1.setForeground(new Color(210, 105, 30));
		
		textField = new JTextField();
		textField.setBounds(88, 11, 179, 20);
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(88, 31, 179, 14);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono:");
		lblNewLabel_1_3.setBounds(360, 18, 46, 14);
		lblNewLabel_1_3.setForeground(new Color(210, 105, 30));
		
		textField_1 = new JTextField();
		textField_1.setBounds(414, 11, 179, 20);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBounds(414, 31, 179, 14);
		separator_2_3.setForeground(Color.LIGHT_GRAY);
		separator_2_3.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Medico:");
		lblNewLabel_1_1_1.setBounds(23, 63, 56, 14);
		lblNewLabel_1_1_1.setForeground(new Color(210, 105, 30));
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 56, 179, 20);
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(88, 76, 179, 14);
		separator_2_1.setForeground(Color.LIGHT_GRAY);
		separator_2_1.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setBounds(360, 63, 64, 14);
		lblNewLabel_1_4.setForeground(new Color(210, 105, 30));
		
		textField_3 = new JTextField();
		textField_3.setBounds(424, 56, 179, 20);
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setBounds(424, 76, 179, 14);
		separator_2_4.setForeground(Color.LIGHT_GRAY);
		separator_2_4.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direccion:");
		lblNewLabel_1_2.setBounds(23, 104, 56, 14);
		lblNewLabel_1_2.setForeground(new Color(210, 105, 30));
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 101, 179, 20);
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(88, 121, 179, 14);
		separator_2_2.setForeground(Color.LIGHT_GRAY);
		separator_2_2.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_5 = new JLabel("Especialidad");
		lblNewLabel_1_5.setBounds(341, 101, 76, 14);
		lblNewLabel_1_5.setForeground(new Color(210, 105, 30));
		
		JLabel lblNewLabel_1_5_1 = new JLabel("");
		lblNewLabel_1_5_1.setBounds(216, 149, 32, 35);
		lblNewLabel_1_5_1.setIcon(new ImageIcon(pmedico1.class.getResource("/imagen/carnet.png")));
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
			public void actionPerformed(ActionEvent e) {
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
			},
			new String[] {
				"Codigo", "Medico", "Direccion", "Telefono", "Email", "Especialidad"
			}
		));
		scrollPane.setViewportView(table);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1_1);
		panel_1.add(textField);
		panel_1.add(separator_2);
		panel_1.add(lblNewLabel_1_3);
		panel_1.add(textField_1);
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
		panel_1.add(textField_2);
		panel_1.add(separator_2_1);
		panel_1.add(lblNewLabel_1_4);
		panel_1.add(textField_3);
		panel_1.add(separator_2_4);
		panel_1.add(lblNewLabel_1_2);
		panel_1.add(textField_4);
		panel_1.add(lblNewLabel_1_5);
		panel_1.add(separator_2_2);
		panel_1.add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(414, 101, 179, 20);
		panel_1.add(comboBox);
	}
}
