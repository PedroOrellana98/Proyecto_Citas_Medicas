package ups.edu.ec.test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.time.LocalTime;

import org.junit.Test;

import ups.edu.ec.controlador.ControladorHorario;

public class ControladorHorarioTest {

	@Test
	public void testObtenerMaximaId() {
		ControladorHorario ch = new ControladorHorario();
		int idHorario = ch.ObtenerMaximaId();
		int valorEsperado = 2;
		assertEquals(valorEsperado, idHorario);
	}

	@Test
	public void testInsertarHorario() {
		ControladorHorario ch = new ControladorHorario();
		boolean banderaIngresoH = ch.InsertarHorario(Time.valueOf(LocalTime.parse("00:00")), Time.valueOf(LocalTime.parse("00:00")));
		boolean banderaEsperada = true;
		assertEquals(banderaEsperada, banderaIngresoH);
	}
}