package ups.edu.ec.vista;

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
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import ups.edu.ec.controlador.*;
import ups.edu.ec.modelo.Medico;
import ups.edu.ec.modelo.Horario;

import java.util.List;
import javax.swing.JOptionPane;
import ups.edu.ec.modelo.Especialidad;

public class Mregistro extends JFrame {

    private JPanel contentPane;
    private JTextField txtnombre;
    private JTextField txtapellidos;
    private JTextField txtcorreo;
    private JTextField txtcedula;
    private JTextField txtpassword;
    private JTextField txtespecialidad;
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
        lblNewLabel.setIcon(new ImageIcon(Mregistro.class.getResource("/imagen/doctor.png")));
        panel.add(lblNewLabel);

        JButton btnvolver = new JButton("");
        btnvolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Psecretaria ps = new Psecretaria();
                ps.setVisible(true);
                dispose();
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

        JLabel lblNewLabel_1_4 = new JLabel("Clave:");
        lblNewLabel_1_4.setForeground(new Color(210, 105, 30));
        lblNewLabel_1_4.setBounds(347, 56, 64, 14);
        panel_1.add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Especialidad:");
        lblNewLabel_1_5.setForeground(new Color(210, 105, 30));
        lblNewLabel_1_5.setBounds(315, 97, 100, 14);
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

        txtpassword = new JTextField();
        txtpassword.setToolTipText("");
        txtpassword.setColumns(10);
        txtpassword.setBorder(null);
        txtpassword.setBounds(401, 49, 179, 20);
        panel_1.add(txtpassword);

        JSeparator separator_2_4 = new JSeparator();
        separator_2_4.setForeground(new Color(192, 192, 192));
        separator_2_4.setBackground(Color.BLACK);
        separator_2_4.setBounds(401, 69, 179, 14);
        panel_1.add(separator_2_4);

        txtespecialidad = new JTextField();
        txtespecialidad.setToolTipText("");
        txtespecialidad.setColumns(10);
        txtespecialidad.setBorder(null);
        txtespecialidad.setBounds(401, 94, 179, 20);
        panel_1.add(txtespecialidad);

        JSeparator separator_2_5 = new JSeparator();
        separator_2_5.setForeground(new Color(192, 192, 192));
        separator_2_5.setBackground(Color.BLACK);
        separator_2_5.setBounds(401, 114, 179, 14);
        panel_1.add(separator_2_5);

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

        JButton btnregistrar = new JButton("Mostrar");
        btnregistrar.setBackground(new Color(244, 164, 96));
        btnregistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(0, 236, 662, 184);
                panel_1.add(scrollPane);

                ControladorMedico cm = new ControladorMedico();
                ControladorEspecialidad ce = new ControladorEspecialidad();
                ControladorHorario ch = new ControladorHorario();
                DefaultTableModel modelo = new DefaultTableModel();
                List<Medico> lista = cm.ListarMedicos();
                List<Especialidad> lista1 = ce.ListarEspecialidades();
                List<Horario> lista2 = ch.ListarHorarios();
                String columna1 = "Nombre";
                String columna2 = "Apellido";
                String columna3 = "Cedula";
                String columna4 = "Correo";
                String columna5 = "Especialidad";
                String columna6 = "Hora Ingreso";
                String columna7 = "Hora Salida";
                modelo.addColumn(columna1);
                modelo.addColumn(columna2);
                modelo.addColumn(columna3);
                modelo.addColumn(columna4);
                modelo.addColumn(columna5);
                modelo.addColumn(columna6);
                modelo.addColumn(columna7);
                Object[] objeto = new Object[7];
                
                for (int i = 0; i < lista.size(); i++) {
                    objeto[0] = lista.get(i).getPer_nombre();
                    objeto[1] = lista.get(i).getPer_apellido();
                    objeto[2] = lista.get(i).getPer_cedula();
                    objeto[3] = lista.get(i).getPer_email();
                    objeto[4] = lista1.get(i).getEsp_nombre();
                    objeto[5] = lista2.get(i).getHoraIngreso();
                    objeto[6] = lista2.get(i).getHoraSalida();
                    modelo.addRow(objeto);
                }
                
                tableusu = new JTable();
                tableusu.setBorder(new LineBorder(new Color(218, 165, 32)));
                tableusu.setBackground(new Color(255, 255, 255));
                tableusu.setModel(modelo);
                scrollPane.setViewportView(tableusu);
            }
        });
        btnregistrar.setBounds(230, 202, 89, 23);
        panel_1.add(btnregistrar);

        JButton btnRestablecer = new JButton("Registrar");
        btnRestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean bandera = false;
                if (bandera == false) {
                    String entrada = JOptionPane.showInputDialog("Hora de Entrada");
                    String salida = JOptionPane.showInputDialog("Hora de Salida");
                    ControladorHorario ch = new ControladorHorario();

                    LocalTime horaIngreso = LocalTime.parse(entrada);
                    LocalTime horaSalida = LocalTime.parse(salida);

                    ch.InsertarHorario(Time.valueOf(horaIngreso), Time.valueOf(horaSalida));
                    bandera = true;
                    System.out.println(bandera);
                }

                if (bandera == true) {
                    ControladorMedico cm = new ControladorMedico();
                    cm.insertarMedico(txtnombre.getText(), txtapellidos.getText(), txtcedula.getText(), txtcorreo.getText(), txtpassword.getText());

                }

                ControladorEspecialidad ce = new ControladorEspecialidad();
                ce.insertarEspecialidad(txtespecialidad.getText());
            }
        });
        btnRestablecer.setBounds(10, 202, 89, 23);
        panel_1.add(btnRestablecer);
        btnRestablecer.setBackground(new Color(244, 164, 96));

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(0, 236, 662, 184);
                panel_1.add(scrollPane);

                ControladorMedico cm = new ControladorMedico();
                cm.BuscarMedico(txtbuscar.getText());

                tableusu = new JTable();
                tableusu.setBorder(new LineBorder(new Color(218, 165, 32)));
                tableusu.setBackground(new Color(255, 255, 255));
                tableusu.setModel(new DefaultTableModel(
                        new Object[][]{
                            {cm.m.getPer_nombre(), cm.m.getPer_apellido(), cm.m.getPer_cedula(), cm.m.getPer_email()},},
                        new String[]{
                            "Nombres", "Apellidos", "Cedula", "Correo"
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
        btnBuscar.setBounds(120, 202, 89, 23);
        panel_1.add(btnBuscar);
        btnBuscar.setBackground(new Color(244, 164, 96));

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(0, 236, 662, 184);
                panel_1.add(scrollPane);

                ControladorMedico cm = new ControladorMedico();
                DefaultTableModel modelo = new DefaultTableModel();
                List<Medico> lista = cm.MostrarMedico();
                String columna1 = "Nombre";
                String columna2 = "Apellido";
                String columna3 = "Cedula";
                String columna4 = "Correo";
                modelo.addColumn(columna1);
                modelo.addColumn(columna2);
                modelo.addColumn(columna3);
                modelo.addColumn(columna4);
                Object[] objeto = new Object[4];

                for (int i = 0; i < lista.size(); i++) {
                    objeto[0] = lista.get(i).getPer_nombre();
                    objeto[1] = lista.get(i).getPer_apellido();
                    objeto[2] = lista.get(i).getPer_cedula();
                    objeto[3] = lista.get(i).getPer_email();
                    modelo.addRow(objeto);
                }
                tableusu = new JTable();
                tableusu.setBorder(new LineBorder(new Color(218, 165, 32)));
                tableusu.setBackground(new Color(255, 255, 255));
                tableusu.setModel(modelo);
                scrollPane.setViewportView(tableusu);
            }
        });

        btnListar.setBounds(340, 202, 89, 23);
        panel_1.add(btnListar);
        btnListar.setBackground(new Color(244, 164, 96));

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControladorMedico cm = new ControladorMedico();
                cm.EliminarMedico(txtbuscar.getText());
            }
        });
        btnEliminar.setBounds(450, 202, 89, 23);
        panel_1.add(btnEliminar);
        btnEliminar.setBackground(new Color(244, 164, 96));

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtcedula.setText("");
                txtapellidos.setText("");
                txtbuscar.setText("");
                txtcorreo.setText("");
                txtespecialidad.setText("");
                txtnombre.setText("");
                txtpassword.setText("");
            }
        });
        btnLimpiar.setBounds(560, 202, 89, 23);
        panel_1.add(btnLimpiar);
        btnLimpiar.setBackground(new Color(244, 164, 96));

    }
}
