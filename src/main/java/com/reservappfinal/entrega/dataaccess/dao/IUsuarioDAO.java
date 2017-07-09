package com.reservappfinal.entrega.dataaccess.dao;

import com.reservappfinal.entrega.dataaccess.api.Dao;
import com.reservappfinal.entrega.modelo.Usuario;


/**
* Interface for   UsuarioDAO.
*
*/
public interface IUsuarioDAO extends Dao<Usuario, String> {
	public Usuario consultarUsuarioPorUsuLogin(String usuLogin);
}
