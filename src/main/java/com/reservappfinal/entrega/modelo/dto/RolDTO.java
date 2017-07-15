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
public class RolDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RolDTO.class);
    private Integer codigodelRol;
    private String rolNombre;

    public Integer getCodigodelRol() {
        return codigodelRol;
    }

    public void setCodigodelRol(Integer codigodelRol) {
        this.codigodelRol = codigodelRol;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
}
