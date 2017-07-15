package com.reservappfinal.entrega.modelo.dto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.reservappfinal.entrega.modelo.Establecimiento;

public class EstablecimientoDTOTest {
	 EstablecimientoDTO establ = new EstablecimientoDTO();

	@Test
	public void test() {
		assertNull( establ.getNombre());
		assertNull( establ.getNit());
		assertNull( establ.getCodigoEstablecimiento());
		assertNull( establ.getCorreo());
		assertNull( establ.getDireccion());
		assertNull( establ.getLatitud());
		assertNull( establ.getLongitud());
		assertNull( establ.getMesas());
		assertNull( establ.getTelefono());	
		
		establ.setNombre("Pepe");
		establ.setNit("900.800.567");
		establ.setCodigoEstablecimiento(12);
		establ.setCorreo("Perez@gmail.com");
		establ.setDireccion("Cr 5 No. 3a-3");
		establ.setLongitud("213");
		establ.setLatitud("567");
		establ.setMesas(10);
		establ.setTelefono("2597");
		
		String numeroEstablecimiento=""+establ.getCodigoEstablecimiento();
		String mesas=""+establ.getMesas();
		assertEquals( establ.getNombre(),"Pepe");
		assertEquals( establ.getNit(),"900.800.567");
		assertEquals( numeroEstablecimiento, "12");
		assertEquals( establ.getCorreo(),"Perez@gmail.com");
		assertEquals( establ.getDireccion(),"Cr 5 No. 3a-3");
		assertEquals( establ.getLatitud(),"567");
		assertEquals( establ.getLongitud(),"213");
		assertEquals( mesas,"10");
		assertEquals( establ.getTelefono(),"2597");	
		
	}

}
