package com.reservappfinal.entrega.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.reservappfinal.entrega.dataaccess.api.HibernateDaoImpl;
import com.reservappfinal.entrega.modelo.Usuario;


/**
 * A data access object (DAO) providing persistence and search support for
 * Usuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Usuario
 */
@Scope("singleton")
@Repository("UsuarioDAO")
public class UsuarioDAO extends HibernateDaoImpl<Usuario, String>
    implements IUsuarioDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UsuarioDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IUsuarioDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IUsuarioDAO) ctx.getBean("UsuarioDAO");
    }
    
    @Override
	public Usuario consultarUsuarioPorUsuLogin(String correo) {
		String hql="SELECT usu FROM Usuario usu WHERE usu.correo=:login";
		Usuario usuarios=(Usuario)sessionFactory.getCurrentSession().createQuery(hql).setParameter("login", correo).getSingleResult();
		
		System.out.println(""+usuarios);
		return usuarios;
	}
}
