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
public class ProductoDTO {

    private int Id;
    private String Nombre;
    private String Descripcion;
    private String FotoUrl;
    private int Stock;
    private double Precio;

    public ProductoDTO() {
    }

    public ProductoDTO(int Id, String Nombre, String Descripcion, String FotoUrl, int Stock, double Precio) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.FotoUrl = FotoUrl;
        this.Stock = Stock;
        this.Precio = Precio;
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

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

}
