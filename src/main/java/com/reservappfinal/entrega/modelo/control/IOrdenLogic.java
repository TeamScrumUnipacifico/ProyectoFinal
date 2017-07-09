package com.reservappfinal.entrega.modelo.control;

import com.reservappfinal.entrega.modelo.Orden;
import com.reservappfinal.entrega.modelo.dto.OrdenDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IOrdenLogic {
    public List<Orden> getOrden() throws Exception;

    /**
         * Save an new Orden entity
         */
    public void saveOrden(Orden entity) throws Exception;

    /**
         * Delete an existing Orden entity
         *
         */
    public void deleteOrden(Orden entity) throws Exception;

    /**
        * Update an existing Orden entity
        *
        */
    public void updateOrden(Orden entity) throws Exception;

    /**
         * Load an existing Orden entity
         *
         */
    public Orden getOrden(Integer codigoOrden) throws Exception;

    public List<Orden> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Orden> findPageOrden(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberOrden() throws Exception;

    public List<OrdenDTO> getDataOrden() throws Exception;
}
