/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.producto;

/**
 *
 * @author droperdev
 */
public class Producto {
    private int Id;
    private int MarcaId;
    private String Nombre;
    private String Descripcion;
    private String FotoUrl;
    private int Stock;
    private int Precio;
    private int Estado;
    private int Creacion;

    public Producto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getMarcaId() {
        return MarcaId;
    }

    public void setMarcaId(int MarcaId) {
        this.MarcaId = MarcaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFotoUrl() {
        return FotoUrl;
    }

    public void setFotoUrl(String FotoUrl) {
        this.FotoUrl = FotoUrl;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getCreacion() {
        return Creacion;
    }

    public void setCreacion(int Creacion) {
        this.Creacion = Creacion;
    }
    
    
}
