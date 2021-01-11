package ups.edu.ec.vista;

import java.sql.Time;
import java.time.LocalTime;

import ups.edu.ec.controlador.Conexion;
import ups.edu.ec.controlador.ControladorFactura;
import ups.edu.ec.controlador.ControladorHorario;
import ups.edu.ec.controlador.ControladorMedico;

public class Main {

	public static void main(String[] args) {
		
		/*ControladorFactura cf = new ControladorFactura();
		
		cf.InsertarFactura("2021-01-07", (float)5.28, (float)0.72, (float)6.0, "A", "Paracetamol 20mg");
		cf.MostrarFacturas();
		
		ControladorHorario ch = new ControladorHorario();
		
		LocalTime horaIngreso = LocalTime.parse("12:00");
		LocalTime horaSalida = LocalTime.parse("15:00");

		ch.InsertarHorario(Time.valueOf(horaIngreso), Time.valueOf(horaSalida));
		ch.MostrarHorario();
		
		//Index interfaces = new Index();
		//interfaces.setVisible(true);
		
		ControladorMedico cm = new ControladorMedico();
		cm.insertarMedico(1, "Juan", "Ortiz", "0101234567", "jaunortiz@gmail.com", "juan123", 1);
		cm.MostrarMedicos();*/
		
		ControladorHorario ch = new ControladorHorario();
		
		LocalTime horaIngreso = LocalTime.parse("12:00");
		LocalTime horaSalida = LocalTime.parse("15:00");

		ch.InsertarHorario(Time.valueOf(horaIngreso), Time.valueOf(horaSalida));
		ch.MostrarHorario();
		
		Mregistro m = new Mregistro();
		m.setVisible(true);

	}

}
