/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

/**
 *
 * @author droperdev
 */
public class Usuario {
    private int Id;
    private int RoleId;
    private String Nombre;
    private String Apellido;
    private String FotoPerfil;
    private String Correo;
    private String Password;
    private boolean Estado;
    private String Creacion;

    public Usuario() {
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public String getCreacion() {
        return Creacion;
    }

    public void setCreacion(String Creacion) {
        this.Creacion = Creacion;
    }
    
    
    
    
}
