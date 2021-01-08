package ups.edu.ec.vista;

import java.sql.Time;
import java.time.LocalTime;

import ups.edu.ec.controlador.ControladorFactura;
import ups.edu.ec.controlador.ControladorHorario;

public class Main {

	public static void main(String[] args) {
		
		ControladorFactura cf = new ControladorFactura();
		
		//cf.InsertarFactura("2021-01-07", (float)5.28, (float)0.72, (float)6.0, "A", "Paracetamol 20mg");
		//cf.MostrarFacturas();
		
		ControladorHorario ch = new ControladorHorario();
		
		LocalTime horaIngreso = LocalTime.parse("12:00");
		LocalTime horaSalida = LocalTime.parse("15:00");

		ch.InsertarHorario(Time.valueOf(horaIngreso), Time.valueOf(horaSalida));
		ch.MostrarHorario();

	}

}
