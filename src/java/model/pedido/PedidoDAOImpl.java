/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

import config.Conexion;
import dto.ClienteDTO;
import dto.DireccionDTO;
import dto.PedidoDTO;
import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.comprobante.Comprobante;
import model.estado.Estado;
import model.metodoPago.MetodoPago;
import model.tipoPago.TipoPedido;

/**
 *
 * @author droperdev
 */
public class PedidoDAOImpl implements PedidoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<PedidoDTO> obtenerPedidos(int[] ids) {
        List<PedidoDTO> pedidos = new ArrayList();

        PedidoDTO pedido = null;
        String query
                = "SELECT o.Id, o.NroDoc, c.Nombre ClienteNombre, "
                + "o.DireccionId, ca.Direccion, ca.Referencia, ca.Latitud, ca.Longitud, "
                + "o.EstadoId, s.Nombre EstadoNombre, "
                + "o.ComprobanteId, v.Nombre ComprobanteNombre, "
                + "o.TipoPedidoId, ot.Nombre TipoPedidoNombre, "
                + "o.MetodoPagoId, pm.Nombre MetodoPagoNombre, "
                + "o.RepartidorId, u.Nombre RepartidorNombre, u.Apellido RepartidorApellido, "
                + "SUM(od.Cantidad * od.Precio) Total "
                + "FROM Pedido o "
                + "INNER JOIN DetallePedido od ON o.Id = od.PedidoId "
                + "INNER JOIN Cliente c ON o.NroDoc = c.NroDoc "
                + "INNER JOIN ClienteDireccion ca ON o.DireccionId = ca.Id "
                + "INNER JOIN Estado s ON o.EstadoId = s.Id "
                + "INNER JOIN Comprobante v ON o.ComprobanteId  = v.Id "
                + "INNER JOIN TipoPedido ot ON o.TipoPedidoId = ot.Id "
                + "INNER JOIN MetodoPago pm ON o.MetodoPagoId = pm.Id "
                + "LEFT JOIN Usuario u ON o.RepartidorId = u.Id ";

        String concat = "";
        for (int id : ids) {
            concat += id + ",";
        }
        concat += concat.substring(0, concat.length() - 1);
        query += "WHERE o.EstadoId IN(" + concat + ")";
        query += "GROUP BY o.Id";

        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new PedidoDTO();
                pedido.setId(rs.getInt("Id"));
                pedido.setCliente(
                        new ClienteDTO(
                                rs.getInt("NroDoc"),
                                rs.getString("ClienteNombre")
                        )
                );
                pedido.setDireccion(
                        new DireccionDTO(
                                rs.getInt("DireccionId"),
                                rs.getString("Direccion"),
                                rs.getString("Referencia"),
                                rs.getDouble("Latitud"),
                                rs.getDouble("Longitud")
                        )
                );
                pedido.setEstado(
                        new Estado(
                                rs.getInt("EstadoId"),
                                rs.getString("EstadoNombre")
                        )
                );
                pedido.setComprobante(
                        new Comprobante(
                                rs.getInt("ComprobanteId"),
                                rs.getString("ComprobanteNombre")
                        )
                );
                pedido.setTipoPedido(
                        new TipoPedido(
                                rs.getInt("TipoPedidoId"),
                                rs.getString("TipoPedidoNombre")
                        )
                );
                pedido.setMetodoPago(
                        new MetodoPago(
                                rs.getInt("MetodoPagoId"),
                                rs.getString("MetodoPagoNombre")
                        )
                );
                pedido.setUsuario(
                        new UsuarioDTO(
                                rs.getInt("RepartidorId"),
                                rs.getString("RepartidorNombre"),
                                rs.getString("RepartidorApellido")
                        )
                );
                pedido.setTotal(rs.getDouble("Total"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    @Override
    public PedidoDTO obtenerPedido(int pedidoId) {
        PedidoDTO pedido = null;
        String query
                = "SELECT o.Id, o.NroDoc, c.Nombre ClienteNombre, "
                + "o.DireccionId, ca.Direccion, ca.Referencia, ca.Latitud, ca.Longitud, "
                + "o.EstadoId, s.Nombre EstadoNombre, "
                + "o.ComprobanteId, v.Nombre ComprobanteNombre, "
                + "o.TipoPedidoId, ot.Nombre TipoPedidoNombre, "
                + "o.MetodoPagoId, pm.Nombre MetodoPagoNombre, "
                + "o.RepartidorId, u.Nombre RepartidorNombre, u.Apellido RepartidorApellido, "
                + "SUM(od.Cantidad * od.Precio) Total "
                + "FROM Pedido o "
                + "INNER JOIN DetallePedido od ON o.Id = od.PedidoId "
                + "INNER JOIN Cliente c ON o.NroDoc = c.NroDoc "
                + "INNER JOIN ClienteDireccion ca ON o.DireccionId = ca.Id "
                + "INNER JOIN Estado s ON o.EstadoId = s.Id "
                + "INNER JOIN Comprobante v ON o.ComprobanteId  = v.Id "
                + "INNER JOIN TipoPedido ot ON o.TipoPedidoId = ot.Id "
                + "INNER JOIN MetodoPago pm ON o.MetodoPagoId = pm.Id "
                + "LEFT JOIN Usuario u ON o.RepartidorId = u.Id "
                + "WHERE o.Id = ?";

      

        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pedidoId);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new PedidoDTO();
                pedido.setId(rs.getInt("Id"));
                pedido.setCliente(
                        new ClienteDTO(
                                rs.getInt("NroDoc"),
                                rs.getString("ClienteNombre")
                        )
                );
                pedido.setDireccion(
                        new DireccionDTO(
                                rs.getInt("DireccionId"),
                                rs.getString("Direccion"),
                                rs.getString("Referencia"),
                                rs.getDouble("Latitud"),
                                rs.getDouble("Longitud")
                        )
                );
                pedido.setEstado(
                        new Estado(
                                rs.getInt("EstadoId"),
                                rs.getString("EstadoNombre")
                        )
                );
                pedido.setComprobante(
                        new Comprobante(
                                rs.getInt("ComprobanteId"),
                                rs.getString("ComprobanteNombre")
                        )
                );
                pedido.setTipoPedido(
                        new TipoPedido(
                                rs.getInt("TipoPedidoId"),
                                rs.getString("TipoPedidoNombre")
                        )
                );
                pedido.setMetodoPago(
                        new MetodoPago(
                                rs.getInt("MetodoPagoId"),
                                rs.getString("MetodoPagoNombre")
                        )
                );
                pedido.setUsuario(
                        new UsuarioDTO(
                                rs.getInt("RepartidorId"),
                                rs.getString("RepartidorNombre"),
                                rs.getString("RepartidorApellido")
                        )
                );
                pedido.setTotal(rs.getDouble("Total"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
    }

}
