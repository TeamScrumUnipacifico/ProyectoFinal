package com.reservappfinal.entrega.modelo.control;

import java.util.List;

import com.reservappfinal.entrega.modelo.Mesa;
import com.reservappfinal.entrega.modelo.dto.MesaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IMesaLogic {
    public List<Mesa> getMesa() throws Exception;

    /**
         * Save an new Mesa entity
         */
    public void saveMesa(Mesa entity) throws Exception;

    /**
         * Delete an existing Mesa entity
         *
         */
    public void deleteMesa(Mesa entity) throws Exception;

    /**
        * Update an existing Mesa entity
        *
        */
    public void updateMesa(Mesa entity) throws Exception;

    /**
         * Load an existing Mesa entity
         *
         */
    public Mesa getMesa(Integer codigoMesa) throws Exception;

    public List<Mesa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Mesa> findPageMesa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMesa() throws Exception;

    public List<MesaDTO> getDataMesa() throws Exception;
}
