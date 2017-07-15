package com.reservappfinal.entrega.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstablecimientoTest {

	Establecimiento estable = new Establecimiento();
	
	@Test
	public void testGetCodigoEstablecimiento() {
		//fail("Not yet implemented");
		assertNull(estable.getCodigoEstablecimiento());
	}

	@Test
	public void testSetCodigoEstablecimiento() {
		estable.setCodigoEstablecimiento(32);
	}

	@Test
	public void testGetNombre() {
		assertNull(estable.getNombre());
	}

	@Test
	public void testSetNombre() {
		estable.setNombre("juan carlos");
	}

	@Test
	public void testGetNit() {
		assertNull(estable.getNit());
	}

	@Test
	public void testSetNit() {
		estable.setNit("900.5667.88");
	}

	@Test
	public void testGetDireccion() {
		assertNull(estable.getDireccion());
	}

	@Test
	public void testSetDireccion() {
		estable.setDireccion("Barri Cristal");
	}

	@Test
	public void testGetCorreo() {
		assertNull(estable.getCorreo());
	}

	@Test
	public void testSetCorreo() {
		estable.setCorreo("sinSali@yahoo.es");
	}

	@Test
	public void testGetTelefono() {
		assertNull(estable.getTelefono());
	}

	@Test
	public void testSetTelefono() {
		estable.setTelefono("09225");
	}

	@Test
	public void testGetLongitud() {
		assertNull(estable.getLongitud());
	}

	@Test
	public void testSetLongitud() {
		estable.setLongitud("5");
	}

	@Test
	public void testGetLatitud() {
		assertNull(estable.getLatitud());
	}

	@Test
	public void testSetLatitud() {
		estable.setLatitud("5");
	}

	@Test
	public void testGetMesas() {
		assertNull(estable.getMesas());
	}

	@Test
	public void testSetMesas() {
		estable.setMesas(4);        
	}
	
	
	public void validacion(){
		assertEquals( estable.getNombre(), "juan carlos");
	    assertEquals( estable.getNit(), "900.5667.88");
	    assertEquals( estable.getDireccion(), "Barri Cristal");
	    assertEquals( estable.getCorreo(), "sinSali@yahoo.es");
	    assertEquals( estable.getTelefono(), "09225");
	    assertEquals( estable.getLongitud(), "5");
	    assertEquals( estable.getLatitud(), "5");
	    assertEquals( estable.getMesas(), "4");	
	}
}
