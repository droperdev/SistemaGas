/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import config.Conexion;
import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.rol.Rol;

/**
 *
 * @author droperdev
 */
public class UsuarioDAOImpl implements UsuarioDAO{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public UsuarioDTO validarCredenciales(String correo, String password) {
       UsuarioDTO usuario = null;
        String query
                = "SELECT u.Id, u.RolId, u.Nombre, u.Apellido, u.FotoPerfil, u.Correo, r.Nombre NombreRol FROM Usuario u "
                + "INNER JOIN Rol r ON r.Id = u.RolId "
                + "WHERE u.Correo=? AND u.Password=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new UsuarioDTO();
                usuario.setId(rs.getInt("Id"));
                usuario.setRol(new Rol(rs.getInt("RolId"), rs.getString("NombreRol")));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setFotoPerfil(rs.getString("FotoPerfil"));
                usuario.setCorreo(rs.getString("Correo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE,null, ex);
        }
        return usuario;
    }
    
}
