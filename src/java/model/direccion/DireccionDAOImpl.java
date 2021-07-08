/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.direccion;

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
public class DireccionDAOImpl implements DireccionDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Direccion> obtenerDirecciones(int nroDoc) {
        ArrayList<Direccion> direcciones = new ArrayList<>();
        Direccion direccion = null;
        String query = "SELECT cd.Id, cd.Direccion, cd.Referencia, cd.Latitud, cd.Longitud "
                + "FROM ClienteDireccion cd "
                + "WHERE cd.NroDoc = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, nroDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                direccion = new Direccion();
                direccion.setId(rs.getInt("Id"));
                direccion.setDireccion(rs.getString("Direccion"));
                direccion.setReferencia(rs.getString("Referencia"));
                direccion.setLatitud(rs.getDouble("Latitud"));
                direccion.setLongitud(rs.getDouble("Longitud"));
                direcciones.add(direccion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return direcciones;
    }

    @Override
    public Direccion obtenerDireccion(int direccionId) {
        Direccion direccion = null;
        String query = "SELECT cd.Id, cd.Direccion, cd.Referencia, cd.Latitud, cd.Longitud "
                + "FROM ClienteDireccion cd "
                + "WHERE cd.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, direccionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                direccion = new Direccion();
                direccion.setId(rs.getInt("Id"));
                direccion.setDireccion(rs.getString("Direccion"));
                direccion.setReferencia(rs.getString("Referencia"));
                direccion.setLatitud(rs.getDouble("Latitud"));
                direccion.setLongitud(rs.getDouble("Longitud"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return direccion;
    }
}
