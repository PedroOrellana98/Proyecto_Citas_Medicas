package ups.edu.ec.test;

import static org.junit.Assert.*;


import org.junit.Test;

import ups.edu.ec.controlador.ControladorFactura;

public class ControladorFacturaTest {	
	
	@Test
	public void testInsertarFactura() {
		
		ControladorFactura cf = new ControladorFactura();
		boolean banderaIngresoFact = cf.InsertarFactura("2021-01-01", (float)0.0, (float)0.0, (float)0.0, "T", "Descripcion");
		boolean banderaEsperada = true;
		assertEquals(banderaEsperada, banderaIngresoFact);
		
	}

	@Test
	public void testObtenerMaximaId() {
		
		ControladorFactura cf = new ControladorFactura();
		int idFactura = cf.ObtenerMaximaId();
		int valorEsperado = 3;
		assertEquals(valorEsperado, idFactura);

	}
}