/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedidoDetalle;

import dto.PedidoDetalleDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface PedidoDetalleDAO {
     public List<PedidoDetalleDTO> obtenerDetalle(int pedidoId);
}
