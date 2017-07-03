package com.reservapp.entrega.modelo;
// Generated 3/07/2017 04:06:33 PM by Hibernate Tools 5.1.0.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String documento;
     private Rol rol;
     private String correo;
     private String contrasena;
     private String nombre;
     private String apellido;
     private String telefono;
     private String direccion;
     private String sexo;
     private Set<Reserva> reservas = new HashSet<Reserva>(0);

    public Usuario() {
    }

	
    public Usuario(String documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Usuario(String documento, Rol rol, String correo, String contrasena, String nombre, String apellido, String telefono, String direccion, String sexo, Set<Reserva> reservas) {
       this.documento = documento;
       this.rol = rol;
       this.correo = correo;
       this.contrasena = contrasena;
       this.nombre = nombre;
       this.apellido = apellido;
       this.telefono = telefono;
       this.direccion = direccion;
       this.sexo = sexo;
       this.reservas = reservas;
    }
   
    public String getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Set<Reserva> getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }




}


