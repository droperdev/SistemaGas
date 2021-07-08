/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.comprobante;

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
public class ComprobanteDAOImpl implements ComprobanteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Comprobante> obtenerComprobantes() {
        ArrayList<Comprobante> comprobantes = new ArrayList<>();
        Comprobante comprobante = null;
        String query = "SELECT c.Id, c.Nombre FROM Comprobante c";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                comprobante = new Comprobante();
                comprobante.setId(rs.getInt("Id"));
                comprobante.setNombre(rs.getString("Nombre"));
                comprobantes.add(comprobante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComprobanteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprobantes;
    }

}
