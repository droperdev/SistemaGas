/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.producto;

import config.Conexion;
import dto.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droperdev
 */
public class ProductoDAOImpl implements ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<ProductoDTO> obtenerProductos(int marcaId) {
        ArrayList<ProductoDTO> productos = new ArrayList<>();
        ProductoDTO producto = null;
        String query = "SELECT p.Id, p.Nombre, p.Descripcion, p.FotoUrl, p.Stock, p.Precio "
                + "FROM Producto p WHERE p.MarcaId=? AND p.Estado = 1";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, marcaId);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new ProductoDTO();
                producto.setId(rs.getInt("Id"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setFotoUrl(rs.getString("FotoUrl"));
                producto.setStock(rs.getInt("Stock"));
                producto.setPrecio(rs.getDouble("Precio"));
                productos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    @Override
    public ProductoDTO obtenerProducto(int productoId) {
        ProductoDTO producto = null;
        String query = "SELECT p.Id, p.Nombre, p.Descripcion, p.FotoUrl, p.Stock, p.Precio "
                + "FROM Producto p WHERE p.Id=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, productoId);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new ProductoDTO();
                producto.setId(rs.getInt("Id"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setFotoUrl(rs.getString("FotoUrl"));
                producto.setStock(rs.getInt("Stock"));
                producto.setPrecio(rs.getDouble("Precio"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    @Override
    public void registrarProducto(Producto producto) {
        String query = "INSERT INTO Producto(MarcaId,Nombre, Descripcion, FotoUrl, Stock, Precio) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, producto.getMarcaId());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getFotoUrl());
            ps.setInt(5, producto.getStock());
            ps.setDouble(6, producto.getPrecio());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarProducto(Producto producto) {
        String query = "UPDATE Producto SET Nombre=?, Descripcion=?, FotoUrl=?, Stock=?, Precio=? "
                + "WHERE Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getFotoUrl());
            ps.setInt(4, producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarProducto(int productoId) {
        String query = "UPDATE Producto SET Estado = 0 "
                + "WHERE Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, productoId);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
