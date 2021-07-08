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
    private String celular;
    private String correo;
    private boolean estado;

    public Cliente() {
    }

    public Cliente(int nroDoc, String nombre, String celular, String correo, boolean estado) {
        this.nroDoc = nroDoc;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
    }

    public Cliente(int nroDoc, String nombre, String celular, String correo) {
        this.nroDoc = nroDoc;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
