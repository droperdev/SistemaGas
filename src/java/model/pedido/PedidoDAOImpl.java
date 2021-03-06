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
import model.tipoPedido.TipoPedido;

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

    @Override
    public void asignarRepartidor(int pedidoId, int repartidorId) {
        String query
                = "UPDATE Pedido p SET p.RepartidorId =? "
                + "WHERE p.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, repartidorId);
            ps.setInt(2, pedidoId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cambiarEstado(int pedidoId) {
        String query
                = "UPDATE Pedido p SET p.EstadoId = p.EstadoId + 1 "
                + "WHERE p.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pedidoId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void anularPedido(int pedidoId) {
        String query
                = "UPDATE Pedido p SET p.EstadoId = 4 "
                + "WHERE p.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pedidoId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int registrarPedido(Pedido pedido) {
        int id = 0;
        String sql
                = "INSERT INTO Pedido(NroDoc, DireccionId, EstadoId,ComprobanteId, TipoPedidoId, MetodoPagoId) "
                + "VALUES(?,?,?,?,?,?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getNroDoc());
            ps.setInt(2, pedido.getDireccionId());
            ps.setInt(3, pedido.getEstadoId());
            ps.setInt(4, pedido.getComprobanteId());
            ps.setInt(5, pedido.getTipoPedidoId());
            ps.setInt(6, pedido.getMetodoPagoId());
            ps.execute();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}
