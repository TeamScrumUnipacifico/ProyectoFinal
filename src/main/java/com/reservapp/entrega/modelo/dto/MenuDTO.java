package com.reservapp.entrega.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class MenuDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MenuDTO.class);
    private Integer codigoMenu;
    private String descripcion;
    private Integer estado;
    private String imagen;
    private String nombre;
    private Integer precio;
    private Integer codigoEstablecimiento_Establecimiento;

    public Integer getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(Integer codigoMenu) {
        this.codigoMenu = codigoMenu;
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

    public Integer getCodigoEstablecimiento_Establecimiento() {
        return codigoEstablecimiento_Establecimiento;
    }

    public void setCodigoEstablecimiento_Establecimiento(
        Integer codigoEstablecimiento_Establecimiento) {
        this.codigoEstablecimiento_Establecimiento = codigoEstablecimiento_Establecimiento;
    }
}
