package com.reservappfinal.entrega.presentation.businessDelegate;

import java.util.List;

import com.reservappfinal.entrega.modelo.Establecimiento;
import com.reservappfinal.entrega.modelo.Factura;
import com.reservappfinal.entrega.modelo.Menu;
import com.reservappfinal.entrega.modelo.Mesa;
import com.reservappfinal.entrega.modelo.Orden;
import com.reservappfinal.entrega.modelo.Reserva;
import com.reservappfinal.entrega.modelo.Rol;
import com.reservappfinal.entrega.modelo.Usuario;
import com.reservappfinal.entrega.modelo.dto.EstablecimientoDTO;
import com.reservappfinal.entrega.modelo.dto.FacturaDTO;
import com.reservappfinal.entrega.modelo.dto.MenuDTO;
import com.reservappfinal.entrega.modelo.dto.MesaDTO;
import com.reservappfinal.entrega.modelo.dto.OrdenDTO;
import com.reservappfinal.entrega.modelo.dto.ReservaDTO;
import com.reservappfinal.entrega.modelo.dto.RolDTO;
import com.reservappfinal.entrega.modelo.dto.UsuarioDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
	
	public Usuario validarUsuario(String usuLogin, String usuClave) throws Exception;
	
    public List<Establecimiento> getEstablecimiento() throws Exception;

    public void saveEstablecimiento(Establecimiento entity)
        throws Exception;

    public void deleteEstablecimiento(Establecimiento entity)
        throws Exception;

    public void updateEstablecimiento(Establecimiento entity)
        throws Exception;

    public Establecimiento getEstablecimiento(Integer codigoEstablecimiento)
        throws Exception;

    public List<Establecimiento> findByCriteriaInEstablecimiento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Establecimiento> findPageEstablecimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEstablecimiento() throws Exception;

    public List<EstablecimientoDTO> getDataEstablecimiento()
        throws Exception;

    public List<Factura> getFactura() throws Exception;

    public void saveFactura(Factura entity) throws Exception;

    public void deleteFactura(Factura entity) throws Exception;

    public void updateFactura(Factura entity) throws Exception;

    public Factura getFactura(Integer codigoFactura) throws Exception;

    public List<Factura> findByCriteriaInFactura(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Factura> findPageFactura(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberFactura() throws Exception;

    public List<FacturaDTO> getDataFactura() throws Exception;

    public List<Menu> getMenu() throws Exception;

    public void saveMenu(Menu entity) throws Exception;

    public void deleteMenu(Menu entity) throws Exception;

    public void updateMenu(Menu entity) throws Exception;

    public Menu getMenu(Integer codigoMenu) throws Exception;

    public List<Menu> findByCriteriaInMenu(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Menu> findPageMenu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMenu() throws Exception;

    public List<MenuDTO> getDataMenu() throws Exception;

    public List<Mesa> getMesa() throws Exception;

    public void saveMesa(Mesa entity) throws Exception;

    public void deleteMesa(Mesa entity) throws Exception;

    public void updateMesa(Mesa entity) throws Exception;

    public Mesa getMesa(Integer codigoMesa) throws Exception;

    public List<Mesa> findByCriteriaInMesa(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Mesa> findPageMesa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMesa() throws Exception;

    public List<MesaDTO> getDataMesa() throws Exception;

    public List<Orden> getOrden() throws Exception;

    public void saveOrden(Orden entity) throws Exception;

    public void deleteOrden(Orden entity) throws Exception;

    public void updateOrden(Orden entity) throws Exception;

    public Orden getOrden(Integer codigoOrden) throws Exception;

    public List<Orden> findByCriteriaInOrden(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Orden> findPageOrden(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberOrden() throws Exception;

    public List<OrdenDTO> getDataOrden() throws Exception;

    public List<Reserva> getReserva() throws Exception;

    public void saveReserva(Reserva entity) throws Exception;

    public void deleteReserva(Reserva entity) throws Exception;

    public void updateReserva(Reserva entity) throws Exception;

    public Reserva getReserva(Integer codigoReserva) throws Exception;

    public List<Reserva> findByCriteriaInReserva(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Reserva> findPageReserva(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberReserva() throws Exception;

    public List<ReservaDTO> getDataReserva() throws Exception;

    public List<Rol> getRol() throws Exception;

    public void saveRol(Rol entity) throws Exception;

    public void deleteRol(Rol entity) throws Exception;

    public void updateRol(Rol entity) throws Exception;

    public Rol getRol(Integer codigodelRol) throws Exception;

    public List<Rol> findByCriteriaInRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberRol() throws Exception;

    public List<RolDTO> getDataRol() throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(String documento) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;
}
