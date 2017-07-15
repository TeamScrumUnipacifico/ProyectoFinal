package com.reservappfinal.entrega.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void testUsuario() {
		Usuario usuario = new Usuario();
		Rol rol = new Rol();
		
		assertNull( rol.getCodigodelRol() );
		assertNull( rol.getRolNombre() );
		
		assertNull( usuario.getNombre() );
		assertNull( usuario.getApellido() );
		assertNull( usuario.getContrasena() );
		assertNull( usuario.getCorreo() );
		assertNull( usuario.getDireccion() );
		assertNull( usuario.getDocumento() );
		assertNull( usuario.getSexo() );
		assertNull( usuario.getRol() );		
		
		rol.setCodigodelRol(1);
		rol.setRolNombre("ADMINISTRADOR");;
		
		usuario.setNombre("Pepe");
		usuario.setApellido("Perez");
		usuario.setContrasena("123456");
		usuario.setCorreo("Perez@gmail.com");
		usuario.setDireccion("Cr 5 No. 3a-3");
		usuario.setDocumento("21324254");
		usuario.setSexo("Masculino");
		usuario.setTelefono("314234567");
		usuario.setRol(rol);
		
        assertEquals( usuario.getNombre(), "Pepe");
        assertEquals( usuario.getApellido(), "Perez");
        assertEquals( usuario.getContrasena(), "123456");
        assertEquals( usuario.getCorreo(), "Perez@gmail.com");
        assertEquals( usuario.getDireccion(), "Cr 5 No. 3a-3");
        assertEquals( usuario.getDocumento(), "21324254");
        assertEquals( usuario.getSexo(), "Masculino");
        assertEquals( usuario.getTelefono(), "314234567");
        assertNotNull(rol);
	}

}