/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.direccion;

/**
 *
 * @author droperdev
 */
public class Direccion {

    private int id;
    private int nroDoc;
    private String direccion;
    private String referencia;
    private double latitud;
    private double longitud;

    public Direccion() {
    }

    public Direccion(int nroDoc, String direccion, String referencia, double latitud, double longitud) {
        this.nroDoc = nroDoc;
        this.direccion = direccion;
        this.referencia = referencia;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Direccion(int id, int nroDoc, String direccion, String referencia, double latitud, double longitud) {
        this.id = id;
        this.nroDoc = nroDoc;
        this.direccion = direccion;
        this.referencia = referencia;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

}
