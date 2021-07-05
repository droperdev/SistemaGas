/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.producto;

import dto.ProductoDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface ProductoDAO {

    List<ProductoDTO> obtenerProductos(int marcaId);

    ProductoDTO obtenerProducto(int productoId);

    void registrarProducto(Producto producto);

    void actualizarProducto(Producto producto);

    void eliminarProducto(int productoId);
}
