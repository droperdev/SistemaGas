/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.rol.Rol;

/**
 *
 * @author droperdev
 */
public class UsuarioDTO {

    private int id;
    private Rol rol;
    private String nombre;
    private String apellido;
    private String fotoPerfil;
    private String correo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, Rol rol, String nombre, String apellido, String fotoPerfil, String correo) {
        this.id = id;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
        this.correo = correo;
    }

    public UsuarioDTO(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFullName() {
        return this.nombre + " " + this.apellido;
    }

}
