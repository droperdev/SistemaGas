/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.productos;

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
import model.marca.Marca;
import model.marca.MarcaDAOImpl;

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
                + "FROM Producto p WHERE p.MarcaId=?";
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
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

}
