/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droperdev
 */
public class ClienteDAOImpl implements ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Cliente obtenerCliente(long nroDocumento) {
        Cliente cliente = null;
        String query = "SELECT c.NroDoc, c.Nombre, c.Celular, c.Correo, c.Estado FROM Cliente c "
                + "WHERE c.NroDoc = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, nroDocumento);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setNroDoc(rs.getInt("NroDoc"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setCorreo(rs.getString("Correo"));
                cliente.setEstado(rs.getBoolean("Estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        String sql
                = "INSERT INTO Cliente(NroDoc, Nombre, Celular,Correo) "
                + "VALUES(?,?,?,?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getNroDoc());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getCorreo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
