package com.reservappfinal.entrega.modelo.control;

import java.util.List;

import com.reservappfinal.entrega.modelo.Factura;
import com.reservappfinal.entrega.modelo.dto.FacturaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IFacturaLogic {
    public List<Factura> getFactura() throws Exception;

    /**
         * Save an new Factura entity
         */
    public void saveFactura(Factura entity) throws Exception;

    /**
         * Delete an existing Factura entity
         *
         */
    public void deleteFactura(Factura entity) throws Exception;

    /**
        * Update an existing Factura entity
        *
        */
    public void updateFactura(Factura entity) throws Exception;

    /**
         * Load an existing Factura entity
         *
         */
    public Factura getFactura(Integer codigoFactura) throws Exception;

    public List<Factura> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Factura> findPageFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberFactura() throws Exception;

    public List<FacturaDTO> getDataFactura() throws Exception;
}
