package com.reservappfinal.entrega.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class OrdenDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(OrdenDTO.class);
    private Integer codigoOrden;
    private String descripcion;
    private Integer estado;
    private String imagen;
    private String nombre;
    private Integer precio;
    private Integer codigoMenu_Menu;
    private Integer codigoReserva_Reserva;

    public Integer getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(Integer codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCodigoMenu_Menu() {
        return codigoMenu_Menu;
    }

    public void setCodigoMenu_Menu(Integer codigoMenu_Menu) {
        this.codigoMenu_Menu = codigoMenu_Menu;
    }

    public Integer getCodigoReserva_Reserva() {
        return codigoReserva_Reserva;
    }

    public void setCodigoReserva_Reserva(Integer codigoReserva_Reserva) {
        this.codigoReserva_Reserva = codigoReserva_Reserva;
    }
}
