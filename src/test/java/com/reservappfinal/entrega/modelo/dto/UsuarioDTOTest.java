package com.reservappfinal.entrega.modelo.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioDTOTest {

	@Test
	public void testUsuarioDTO() {
		UsuarioDTO usuarioDTO = new UsuarioDTO();	
		
		assertNull( usuarioDTO.getNombre() );
		assertNull( usuarioDTO.getApellido() );
		assertNull( usuarioDTO.getContrasena() );
		assertNull( usuarioDTO.getCorreo() );
		assertNull( usuarioDTO.getDireccion() );
		assertNull( usuarioDTO.getDocumento() );
		assertNull( usuarioDTO.getSexo() );
		assertNull( usuarioDTO.getTelefono() );
		assertNull( usuarioDTO.getCodigodelRol_Rol() );	
		 
		usuarioDTO.setNombre("Pepe");
		usuarioDTO.setApellido("Perez");
		usuarioDTO.setContrasena("123456");
		usuarioDTO.setCorreo("Perez@gmail.com");
		usuarioDTO.setDireccion("Cr 5 No. 3a-3");
		usuarioDTO.setDocumento("21324254");
		usuarioDTO.setSexo("Masculino");
		usuarioDTO.setTelefono("314234567");
		usuarioDTO.setCodigodelRol_Rol(1);
		assertNotNull(usuarioDTO);
		
        assertEquals( usuarioDTO.getNombre(), "Pepe");
        assertEquals( usuarioDTO.getApellido(), "Perez");
        assertEquals( usuarioDTO.getContrasena(), "123456");
        assertEquals( usuarioDTO.getCorreo(), "Perez@gmail.com");
        assertEquals( usuarioDTO.getDireccion(), "Cr 5 No. 3a-3");
        assertEquals( usuarioDTO.getDocumento(), "21324254");
        assertEquals( usuarioDTO.getSexo(), "Masculino");
        assertEquals( usuarioDTO.getTelefono(), "314234567");
        assertEquals( usuarioDTO.getCodigodelRol_Rol(), new Integer(1));
	}

}