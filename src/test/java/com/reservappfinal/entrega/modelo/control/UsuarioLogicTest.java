package com.reservappfinal.entrega.modelo.control;

import static org.junit.Assert.*;

import org.junit.Test;

import com.reservappfinal.entrega.modelo.Rol;
import com.reservappfinal.entrega.modelo.Usuario;

public class UsuarioLogicTest {
	UsuarioLogic usuarioLogic = new UsuarioLogic();
	
	@Test
	public void testValidarUsuario() {
		try {
			usuarioLogic.validarUsuario("ok", "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveUsuario() {
		
		Usuario usuario = new Usuario();
		Rol rol = new Rol();
		
		usuario.setNombre("Pepe");
		usuario.setApellido("Perez");
		usuario.setContrasena("123456");
		usuario.setCorreo("Perez@gmail.com");
		usuario.setDireccion("Cr 5 No. 3a-3");
		usuario.setDocumento("21324254");
		usuario.setSexo("Masculino");
		usuario.setTelefono("314234567");
		usuario.setRol(rol);
		
		try {
			usuarioLogic.saveUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}