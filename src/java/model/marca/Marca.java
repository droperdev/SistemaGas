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
    private int Id;
    private String Nombre;
    private String Logo;
    private boolean Estado;

    public Marca() {
    }

    public Marca(int Id, String Nombre, String Logo, boolean Estado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Logo = Logo;
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Marca{" + "Id=" + Id + ", Nombre=" + Nombre + ", Logo=" + Logo + ", Estado=" + Estado + '}';
    }

    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String Logo) {
        this.Logo = Logo;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
    
}
