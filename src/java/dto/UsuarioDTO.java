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
   private int Id;
    private Rol Rol;
    private String Nombre;
    private String Apellido;
    private String FotoPerfil;
    private String Correo;

    public UsuarioDTO() {
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "Id=" + Id + ", Rol=" + Rol + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", FotoPerfil=" + FotoPerfil + ", Correo=" + Correo + '}';
    }
    
    public UsuarioDTO(int Id, Rol Rol, String Nombre, String Apellido, String FotoPerfil, String Correo) {
        this.Id = Id;
        this.Rol = Rol;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FotoPerfil = FotoPerfil;
        this.Correo = Correo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(String FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
    public String getFullName(){
        return this.Nombre + " "+ this.Apellido;
    }
    
}
