package com.reservappfinal.entrega.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.reservappfinal.entrega.dataaccess.api.HibernateDaoImpl;
import com.reservappfinal.entrega.modelo.Menu;


/**
 * A data access object (DAO) providing persistence and search support for
 * Menu entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Menu
 */
@Scope("singleton")
@Repository("MenuDAO")
public class MenuDAO extends HibernateDaoImpl<Menu, Integer> implements IMenuDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MenuDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IMenuDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IMenuDAO) ctx.getBean("MenuDAO");
    }
}
