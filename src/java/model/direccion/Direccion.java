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
    private String Direccion;
    private String Referencia;
    private double Latitud;
    private double Longitud;

    public Direccion() {
    }

    public Direccion(int id, int nroDoc, String Direccion, String Referencia, double Latitud, double Longitud) {
        this.id = id;
        this.nroDoc = nroDoc;
        this.Direccion = Direccion;
        this.Referencia = Referencia;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
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
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double Latitud) {
        this.Latitud = Latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double Longitud) {
        this.Longitud = Longitud;
    }
}
