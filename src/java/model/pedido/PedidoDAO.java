/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

import dto.PedidoDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface PedidoDAO {

    public List<PedidoDTO> obtenerPedidos(int[] ids);
}
