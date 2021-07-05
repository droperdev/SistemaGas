/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.marca;

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
public class MarcaDAOImpl implements MarcaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Marca> obtenerMarcas() {
        ArrayList<Marca> marcas = new ArrayList<>();
        Marca marca = null;
        String query = "SELECT m.Id, m.Nombre, m.Logo, m.Estado FROM Marca m "
                + "WHERE m.Estado = 1";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca = new Marca();
                marca.setId(rs.getInt("Id"));
                marca.setNombre(rs.getString("Nombre"));
                marca.setLogo(rs.getString("Logo"));
                marca.setEstado(rs.getBoolean("Estado"));
                marcas.add(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marcas;
    }

    @Override
    public Marca obtenerMarca(int marcaId) {
        Marca marca = null;
        String query = "SELECT m.Id, m.Nombre, m.Logo, m.Estado FROM Marca m "
                + "WHERE m.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, marcaId);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca = new Marca();
                marca.setId(rs.getInt("Id"));
                marca.setNombre(rs.getString("Nombre"));
                marca.setLogo(rs.getString("Logo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marca;
    }

    @Override
    public void registrarMarca(Marca marca) {
        String query = "INSERT INTO Marca(Nombre, Logo) "
                + "VALUES(?,?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, marca.getNombre());
            ps.setString(2, marca.getLogo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarMarca(int marcaId) {
        String query = "UPDATE Marca SET Estado = 0 "
                + "WHERE Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, marcaId);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarMarca(Marca marca) {
        String query = "UPDATE Marca SET Nombre = ?, Logo = ? "
                + "WHERE Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, marca.getNombre());
            ps.setString(2, marca.getLogo());
            ps.setInt(3, marca.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
