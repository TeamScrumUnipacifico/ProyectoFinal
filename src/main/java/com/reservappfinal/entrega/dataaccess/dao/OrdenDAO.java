package com.reservappfinal.entrega.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.reservappfinal.entrega.dataaccess.api.HibernateDaoImpl;
import com.reservappfinal.entrega.modelo.Orden;


/**
 * A data access object (DAO) providing persistence and search support for
 * Orden entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Orden
 */
@Scope("singleton")
@Repository("OrdenDAO")
public class OrdenDAO extends HibernateDaoImpl<Orden, Integer>
    implements IOrdenDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(OrdenDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IOrdenDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IOrdenDAO) ctx.getBean("OrdenDAO");
    }
}
