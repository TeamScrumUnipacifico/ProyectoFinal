package com.reservappfinal.entrega.modelo;
// Generated 9/07/2017 10:36:47 AM by Hibernate Tools 5.1.0.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Reserva generated by hbm2java
 */
@SuppressWarnings("serial")
public class Reserva  implements java.io.Serializable {


     private Integer codigoReserva;
     private Mesa mesa;
     private Usuario usuario;
     private Integer usuarioIdUsuario;
     private Date fechaReserva;
     private Integer idMesa;
     private Set<Factura> facturas = new HashSet<Factura>(0);
     private Set<Orden> ordens = new HashSet<Orden>(0);

    public Reserva() {
    }

	
    public Reserva(Mesa mesa, Usuario usuario, Integer usuarioIdUsuario) {
        this.mesa = mesa;
        this.usuario = usuario;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    public Reserva(Mesa mesa, Usuario usuario, Integer usuarioIdUsuario, Date fechaReserva, Integer idMesa, Set<Factura> facturas, Set<Orden> ordens) {
       this.mesa = mesa;
       this.usuario = usuario;
       this.usuarioIdUsuario = usuarioIdUsuario;
       this.fechaReserva = fechaReserva;
       this.idMesa = idMesa;
       this.facturas = facturas;
       this.ordens = ordens;
    }
   
    public Integer getCodigoReserva() {
        return this.codigoReserva;
    }
    
    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
    public Mesa getMesa() {
        return this.mesa;
    }
    
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Integer getUsuarioIdUsuario() {
        return this.usuarioIdUsuario;
    }
    
    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    public Date getFechaReserva() {
        return this.fechaReserva;
    }
    
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public Integer getIdMesa() {
        return this.idMesa;
    }
    
    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
    public Set<Orden> getOrdens() {
        return this.ordens;
    }
    
    public void setOrdens(Set<Orden> ordens) {
        this.ordens = ordens;
    }




}


