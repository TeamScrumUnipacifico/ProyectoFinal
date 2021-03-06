package com.reservappfinal.entrega.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reservappfinal.entrega.dataaccess.dao.IOrdenDAO;
import com.reservappfinal.entrega.exceptions.ZMessManager;
import com.reservappfinal.entrega.modelo.Orden;
import com.reservappfinal.entrega.modelo.dto.OrdenDTO;
import com.reservappfinal.entrega.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("OrdenLogic")
public class OrdenLogic implements IOrdenLogic {
    private static final Logger log = LoggerFactory.getLogger(OrdenLogic.class);

    /**
     * DAO injected by Spring that manages Orden entities
     *
     */
    @Autowired
    private IOrdenDAO ordenDAO;

    /**
    * Logic injected by Spring that manages Menu entities
    *
    */
    @Autowired
    IMenuLogic logicMenu1;

    /**
    * Logic injected by Spring that manages Reserva entities
    *
    */
    @Autowired
    IReservaLogic logicReserva2;

    @Transactional(readOnly = true)
    public List<Orden> getOrden() throws Exception {
        log.debug("finding all Orden instances");

        List<Orden> list = new ArrayList<Orden>();

        try {
            list = ordenDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Orden failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Orden");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveOrden(Orden entity) throws Exception {
        log.debug("saving Orden instance");

        try {
            if (entity.getMenu() == null) {
                throw new ZMessManager().new ForeignException("menu");
            }

            if (entity.getReserva() == null) {
                throw new ZMessManager().new ForeignException("reserva");
            }

            if (entity.getCodigoOrden() == null) {
                throw new ZMessManager().new EmptyFieldException("codigoOrden");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if ((entity.getImagen() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getImagen(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("imagen");
            }

            if (entity.getNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("nombre");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getPrecio() == null) {
                throw new ZMessManager().new EmptyFieldException("precio");
            }

            if (entity.getMenu().getCodigoMenu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "codigoMenu_Menu");
            }

            if (entity.getReserva().getCodigoReserva() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "codigoReserva_Reserva");
            }

            if (getOrden(entity.getCodigoOrden()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            ordenDAO.save(entity);

            log.debug("save Orden successful");
        } catch (Exception e) {
            log.error("save Orden failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteOrden(Orden entity) throws Exception {
        log.debug("deleting Orden instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Orden");
        }

        if (entity.getCodigoOrden() == null) {
            throw new ZMessManager().new EmptyFieldException("codigoOrden");
        }

        try {
            ordenDAO.delete(entity);

            log.debug("delete Orden successful");
        } catch (Exception e) {
            log.error("delete Orden failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateOrden(Orden entity) throws Exception {
        log.debug("updating Orden instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Orden");
            }

            if (entity.getMenu() == null) {
                throw new ZMessManager().new ForeignException("menu");
            }

            if (entity.getReserva() == null) {
                throw new ZMessManager().new ForeignException("reserva");
            }

            if (entity.getCodigoOrden() == null) {
                throw new ZMessManager().new EmptyFieldException("codigoOrden");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if ((entity.getImagen() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getImagen(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("imagen");
            }

            if (entity.getNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("nombre");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getPrecio() == null) {
                throw new ZMessManager().new EmptyFieldException("precio");
            }

            if (entity.getMenu().getCodigoMenu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "codigoMenu_Menu");
            }

            if (entity.getReserva().getCodigoReserva() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "codigoReserva_Reserva");
            }

            ordenDAO.update(entity);

            log.debug("update Orden successful");
        } catch (Exception e) {
            log.error("update Orden failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<OrdenDTO> getDataOrden() throws Exception {
        try {
            List<Orden> orden = ordenDAO.findAll();

            List<OrdenDTO> ordenDTO = new ArrayList<OrdenDTO>();

            for (Orden ordenTmp : orden) {
                OrdenDTO ordenDTO2 = new OrdenDTO();

                ordenDTO2.setCodigoOrden(ordenTmp.getCodigoOrden());
                ordenDTO2.setDescripcion((ordenTmp.getDescripcion() != null)
                    ? ordenTmp.getDescripcion() : null);
                ordenDTO2.setEstado((ordenTmp.getEstado() != null)
                    ? ordenTmp.getEstado() : null);
                ordenDTO2.setImagen((ordenTmp.getImagen() != null)
                    ? ordenTmp.getImagen() : null);
                ordenDTO2.setNombre((ordenTmp.getNombre() != null)
                    ? ordenTmp.getNombre() : null);
                ordenDTO2.setPrecio((ordenTmp.getPrecio() != null)
                    ? ordenTmp.getPrecio() : null);
                ordenDTO2.setCodigoMenu_Menu((ordenTmp.getMenu().getCodigoMenu() != null)
                    ? ordenTmp.getMenu().getCodigoMenu() : null);
                ordenDTO2.setCodigoReserva_Reserva((ordenTmp.getReserva()
                                                            .getCodigoReserva() != null)
                    ? ordenTmp.getReserva().getCodigoReserva() : null);
                ordenDTO.add(ordenDTO2);
            }

            return ordenDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Orden getOrden(Integer codigoOrden) throws Exception {
        log.debug("getting Orden instance");

        Orden entity = null;

        try {
            entity = ordenDAO.findById(codigoOrden);
        } catch (Exception e) {
            log.error("get Orden failed", e);
            throw new ZMessManager().new FindingException("Orden");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Orden> findPageOrden(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Orden> entity = null;

        try {
            entity = ordenDAO.findPage(sortColumnName, sortAscending, startRow,
                    maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Orden Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberOrden() throws Exception {
        Long entity = null;

        try {
            entity = ordenDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Orden Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Orden> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Orden> list = new ArrayList<Orden>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = ordenDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
