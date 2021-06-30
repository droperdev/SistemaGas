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

    private int id;
    private String nombre;
    private MarcaDTO marca;
    private String descripcion;
    private String fotoUrl;
    private int stock;
    private double precio;

    public ProductoDTO() {
    }

    public ProductoDTO(int id, MarcaDTO marca, String nombre, String descripcion) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ProductoDTO(int id, String nombre, String descripcion, String fotoUrl, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoUrl = fotoUrl;
        this.stock = stock;
        this.precio = precio;
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

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
