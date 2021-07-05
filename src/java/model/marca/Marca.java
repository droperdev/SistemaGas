/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.marca;

/**
 *
 * @author droperdev
 */
public class Marca {

    private int id;
    private String nombre;
    private String logo;
    private boolean estado;

    public Marca() {
    }

    public Marca(int id, String nombre, String logo, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
        this.estado = estado;
    }

    public Marca(int id, String nombre, String logo) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
    }

    public Marca(String nombre, String photoUrl) {
        this.nombre = nombre;
        this.logo = photoUrl;
    }

    @Override
    public String toString() {
        return "Marca{" + "id=" + id + ", nombre=" + nombre + ", logo=" + logo + ", estado=" + estado + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
