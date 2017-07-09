package com.reservappfinal.entrega.modelo.dto;

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
public class MesaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MesaDTO.class);
    private Integer codigoMesa;
    private String estado;
    private Integer puestos;
    private String ubicacion;
    private Integer codigoEstablecimiento_Establecimiento;

    public Integer getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(Integer codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public void setPuestos(Integer puestos) {
        this.puestos = puestos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCodigoEstablecimiento_Establecimiento() {
        return codigoEstablecimiento_Establecimiento;
    }

    public void setCodigoEstablecimiento_Establecimiento(
        Integer codigoEstablecimiento_Establecimiento) {
        this.codigoEstablecimiento_Establecimiento = codigoEstablecimiento_Establecimiento;
    }
}
