/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ups.edu.ec.controlador.ControladorCitas;

/**
 *
 * @author kevingodoy
 */
public class ControladorCitasTest {
    @Test
	public void testInsertarCita() {
		
		ControladorCitas cf = new ControladorCitas();
		boolean banderaIngreso = cf.InsertarCita(Date.valueOf("2021-01-22"),Time.valueOf(LocalTime.parse("15:00")),1,1,1);
		boolean banderaEsperada = true;
		assertEquals(banderaEsperada, banderaIngreso);
		
	}

	@Test
	public void testObtenerMaximaId() {
		
		ControladorCitas cf = new ControladorCitas();
		int idCita = cf.ObtenerMaximaId();
		int valorEsperado = 3;
		assertEquals(valorEsperado, idCita);

	}
}
