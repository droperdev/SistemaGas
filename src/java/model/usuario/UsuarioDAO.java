/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface UsuarioDAO {

    public UsuarioDTO validarCredenciales(String correo, String password);

    public List<UsuarioDTO> obtenerDistribuidores();
}
