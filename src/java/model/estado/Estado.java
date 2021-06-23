/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.estado;

/**
 *
 * @author droperdev
 */
public class Estado {

    private int id;
    private String nombre;

    public Estado() {
    }

    public Estado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombreClase() {
        String nombreClase = "";
        switch (id) {
            case 1:
                nombreClase = "badge p-2 badge-pill badge-warning";
                break;
            case 2:
                nombreClase = "badge p-2 badge-pill badge-info";
                break;
            case 3:
                nombreClase = "badge p-2 badge-pill badge-success";
                break;
            case 4:
                nombreClase = "badge p-2 badge-pill badge-success";
                break;
            case 5:
                nombreClase = "badge p-2 badge-pill badge-danger";
                break;
        }
        return nombreClase;
    }

}
