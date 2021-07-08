/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metodoPago;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.metodoPago.MetodoPago;
import model.metodoPago.MetodoPagoDAO;

/**
 *
 * @author droperdev
 */
public class MetodoPagoDAOImpl implements MetodoPagoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<MetodoPago> obtenerMetodos() {
        ArrayList<MetodoPago> metodos = new ArrayList<>();
        MetodoPago metodo = null;
        String query = "SELECT tp.Id, tp.Nombre FROM MetodoPago tp";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                metodo = new MetodoPago();
                metodo.setId(rs.getInt("Id"));
                metodo.setNombre(rs.getString("Nombre"));
                metodos.add(metodo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetodoPagoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return metodos;
    }

}
