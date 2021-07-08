/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

/**
 *
 * @author droperdev
 */
public class Cliente {

    private int nroDoc;
    private String nombre;
    private String Celular;
    private String Correo;
    private boolean Estado;

    public Cliente() {
    }

    public Cliente(int nroDoc, String nombre, String Celular, String Correo, boolean Estado) {
        this.nroDoc = nroDoc;
        this.nombre = nombre;
        this.Celular = Celular;
        this.Correo = Correo;
        this.Estado = Estado;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public int getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}
