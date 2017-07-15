package com.reservappfinal.entrega.modelo.control;

import java.util.List;

import com.reservappfinal.entrega.modelo.Rol;
import com.reservappfinal.entrega.modelo.dto.RolDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRolLogic {
    public List<Rol> getRol() throws Exception;

    /**
         * Save an new Rol entity
         */
    public void saveRol(Rol entity) throws Exception;

    /**
         * Delete an existing Rol entity
         *
         */
    public void deleteRol(Rol entity) throws Exception;

    /**
        * Update an existing Rol entity
        *
        */
    public void updateRol(Rol entity) throws Exception;

    /**
         * Load an existing Rol entity
         *
         */
    public Rol getRol(Integer codigodelRol) throws Exception;

    public List<Rol> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberRol() throws Exception;

    public List<RolDTO> getDataRol() throws Exception;
}
