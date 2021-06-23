/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author droperdev
 */
public class DireccionDTO {

    private int id;
    private String direccion;
    private String referencia;
    private Double latitud;
    private Double longitud;

    public DireccionDTO() {
    }

    public DireccionDTO(int id, String direccion, String referencia, Double latitud, Double longitud) {
        this.id = id;
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

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

}
