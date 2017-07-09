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
public class ReservaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ReservaDTO.class);
    private Integer codigoReserva;
    private Date fechaReserva;
    private Integer idMesa;
    private Integer usuarioIdUsuario;
    private Integer codigoMesa_Mesa;
    private String documento_Usuario;

    public Integer getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Integer getCodigoMesa_Mesa() {
        return codigoMesa_Mesa;
    }

    public void setCodigoMesa_Mesa(Integer codigoMesa_Mesa) {
        this.codigoMesa_Mesa = codigoMesa_Mesa;
    }

    public String getDocumento_Usuario() {
        return documento_Usuario;
    }

    public void setDocumento_Usuario(String documento_Usuario) {
        this.documento_Usuario = documento_Usuario;
    }
}
