/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedidoDetalle;

import config.Conexion;
import dto.MarcaDTO;
import dto.PedidoDetalleDTO;
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
public class PedidoDetalleDAOImpl implements PedidoDetalleDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<PedidoDetalleDTO> obtenerDetalle(int pedidoId) {
        List<PedidoDetalleDTO> pedidoDetalles = new ArrayList<>();
        PedidoDetalleDTO pedidoDetalle = null;
        String query
                = "SELECT od.Id, od.Cantidad, od.Precio, "
                + "od.ProductoId, p.Nombre ProductoNombre, p.Descripcion, p.Precio, "
                + "p.MarcaId, m.Nombre MarcaNombre "
                + "FROM DetallePedido od "
                + "INNER JOIN Producto p ON od.ProductoId = p.Id "
                + "INNER JOIN Marca m ON p.MarcaId = m.Id "
                + "WHERE od.PedidoId=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pedidoId);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedidoDetalle = new PedidoDetalleDTO();
                pedidoDetalle.setId(rs.getInt("Id"));
                pedidoDetalle.setProducto(
                        new ProductoDTO(
                                rs.getInt("ProductoId"),
                                new MarcaDTO(
                                        rs.getInt("MarcaId"),
                                        rs.getString("MarcaNombre")
                                ),
                                rs.getString("ProductoNombre"),
                                rs.getString("Descripcion")
                        )
                );
                pedidoDetalle.setCantidad(rs.getInt("Cantidad"));
                pedidoDetalle.setPrecio(rs.getDouble("Precio"));
             
                pedidoDetalles.add(pedidoDetalle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDetalleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidoDetalles;
    }
    
}
