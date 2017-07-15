package com.reservappfinal.entrega.modelo.control;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.reservappfinal.entrega.modelo.Establecimiento;
import com.reservappfinal.entrega.modelo.dto.EstablecimientoDTO;

public class EstablecimientoLogicTest {

	@Test
	public void testSaveEstablecimiento() {
		//fail("Not yet implemented");
		Establecimiento estable = new Establecimiento();
		estable.setCodigoEstablecimiento(12);
		estable.setCorreo("super@coco.es");
		estable.setDireccion("barrio cristal");
		estable.setLatitud("23");
		estable.setLongitud("12");
		estable.setMesas(11);
		estable.setNit("11");
		estable.setNombre("nombre al");
		estable.setTelefono("318095866");
		
		EstablecimientoLogic esta=new EstablecimientoLogic();
		try {
			esta.saveEstablecimiento(estable);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testSetDataEstablecimiento(){
		EstablecimientoLogic esta=new EstablecimientoLogic();
		try {
			esta.getDataEstablecimiento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
