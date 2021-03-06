package com.reservappfinal.entrega.modelo;
// Generated 9/07/2017 10:36:47 AM by Hibernate Tools 5.1.0.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Establecimiento generated by hbm2java
 */
@SuppressWarnings("serial")
public class Establecimiento  implements java.io.Serializable {


     private Integer codigoEstablecimiento;
     private String nombre;
     private String nit;
     private String direccion;
     private String correo;
     private String telefono;
     private String longitud;
     private String latitud;
     private Integer mesas;
     private Set<Menu> menus = new HashSet<Menu>(0);
     private Set<Mesa> mesas_1 = new HashSet<Mesa>(0);

    public Establecimiento() {
    }

	
    public Establecimiento(Integer codigoEstablecimiento, String nit, Integer mesas) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.nit = nit;
        this.mesas = mesas;
    }
    public Establecimiento(Integer codigoEstablecimiento, String nombre, String nit, String direccion, String correo, String telefono, String longitud, String latitud, Integer mesas, Set<Menu> menus, Set<Mesa> mesas_1) {
       this.codigoEstablecimiento = codigoEstablecimiento;
       this.nombre = nombre;
       this.nit = nit;
       this.direccion = direccion;
       this.correo = correo;
       this.telefono = telefono;
       this.longitud = longitud;
       this.latitud = latitud;
       this.mesas = mesas;
       this.menus = menus;
       this.mesas_1 = mesas_1;
    }
   
    public Integer getCodigoEstablecimiento() {
        return this.codigoEstablecimiento;
    }
    
    public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public Integer getMesas() {
        return this.mesas;
    }
    
    public void setMesas(Integer mesas) {
        this.mesas = mesas;
    }
    public Set<Menu> getMenus() {
        return this.menus;
    }
    
    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
    public Set<Mesa> getMesas_1() {
        return this.mesas_1;
    }
    
    public void setMesas_1(Set<Mesa> mesas_1) {
        this.mesas_1 = mesas_1;
    }




}


