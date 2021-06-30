<%-- 
    Document   : detallePedido
    Created on : 29/06/2021, 01:05:49 AM
    Author     : droperdev
--%>

<%@page import="model.pedidoDetalle.PedidoDetalleDAOImpl"%>
<%@page import="dto.PedidoDetalleDTO"%>
<%@page import="model.pedido.PedidoDAOImpl"%>
<%@page import="dto.PedidoDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <% int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));%>
        <% PedidoDTO pedido = new PedidoDAOImpl().obtenerPedido(pedidoId);%>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="form-group">
                        <label>Cliente</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=pedido.getCliente().getNombre()%>">
                    </div>
                    <div class="form-group">
                        <label>Dirección</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=pedido.getDireccion().getDireccion()%>">
                    </div>
                    <div class="form-group">
                        <label>Referencia</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=pedido.getDireccion().getReferencia()%>">
                    </div>
                    <div class="form-group">
                        <label>Tipo de pago</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=pedido.getMetodoPago().getNombre()%>">
                    </div>
                    <div class="form-group">
                        <label>Comprobante</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=pedido.getComprobante().getNombre()%>">
                    </div>
                    <div class="form-group">
                        <label>Tipo de pedido</label>    
                        <input class="form-control" type="text" disabled="true" value="<%=pedido.getTipoPedido().getNombre()%>">
                    </div>
                </div> 
                <% Double sum = 0.0; %>
                <div class="col-md-7">
                    <% List<PedidoDetalleDTO> pedidoDetalles = new PedidoDetalleDAOImpl().obtenerDetalle(pedidoId);%>
                    <label>Productos</label>    
                    <div class="table-responsible">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Cantidad</th>
                                    <th>Producto</th>
                                    <th>Precio</th>
                                    <th>Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%! PedidoDetalleDTO pedidoDetalle;%>
                                <% for (int i = 0; i < pedidoDetalles.size(); i++) {%>
                                <% pedidoDetalle = pedidoDetalles.get(i);%>
                                <% sum = sum + (pedidoDetalle.getCantidad() * pedidoDetalle.getPrecio());%>
                                <tr >
                                    <td class="align-middle"><%=pedidoDetalle.getCantidad()%></td>
                                    <td class="align-middle">
                                        <%=pedidoDetalle.getProducto().getMarca().getNombre()%><br>
                                        <%=pedidoDetalle.getProducto().getDescripcion()%>
                                    </td>
                                    <td class="align-middle">S/&nbsp;<%=String.format("%.2f", pedidoDetalle.getPrecio())%></td>
                                    <td class="align-middle">S/&nbsp;<%=String.format("%.2f", pedidoDetalle.getCantidad() * pedidoDetalle.getPrecio())%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>

                    </div>
                    <div class="total">
                        Total S/&nbsp; <%=String.format("%.2f", sum)%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
