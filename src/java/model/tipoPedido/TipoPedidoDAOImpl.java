/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tipoPedido;

import config.Conexion;
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
public class TipoPedidoDAOImpl implements TipoPedidoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<TipoPedido> obtenerTipoPedidos() {
        ArrayList<TipoPedido> tipoPedidos = new ArrayList<>();
        TipoPedido tipoPedido = null;
        String query = "SELECT tp.Id, tp.Nombre FROM TipoPedido tp";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoPedido = new TipoPedido();
                tipoPedido.setId(rs.getInt("Id"));
                tipoPedido.setNombre(rs.getString("Nombre"));
                tipoPedidos.add(tipoPedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoPedidos;
    }

}
