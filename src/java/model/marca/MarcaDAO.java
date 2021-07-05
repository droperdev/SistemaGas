/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.marca;

import java.util.List;

/**
 *
 * @author droperdev
 */
public interface MarcaDAO {

    List<Marca> obtenerMarcas();

    Marca obtenerMarca(int marcaId);

    void registrarMarca(Marca marca);

    void eliminarMarca(int marcaId);

    void actualizarMarca(Marca marca);
}
