/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.UsuarioDTO;
import java.util.List;
import model.marca.Marca;
import model.marca.MarcaDAOImpl;
import model.usuario.UsuarioDAOImpl;

/**
 *
 * @author droperdev
 */
public class Test {
    public static void main(String[] args) {
    
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        UsuarioDTO usuario = usuarioDAO.validarCredenciales("jaguirre@gmail.com", "123456");
        System.out.println("Usuario -> " + usuario.toString());
        
         MarcaDAOImpl marcaDAO = new MarcaDAOImpl();
        
        List<Marca> marcas = marcaDAO.obtenerMarcas();
        
        for(int i=0; i< marcas.size(); i++){
            System.out.println("Marca ->  " + i+1 + marcas.get(i).toString());    
        }
        
    }
}
