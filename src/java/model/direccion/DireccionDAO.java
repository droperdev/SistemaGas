/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.direccion;

import java.util.List;

/**
 *
 * @author droperdev
 */
public interface DireccionDAO {

    List<Direccion> obtenerDirecciones(int nroDoc);

    Direccion obtenerDireccion(int direccionId);
}
