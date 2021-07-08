<%-- 
    Document   : registrarPedido
    Created on : 29/06/2021, 01:42:33 AM
    Author     : droperdev
--%>

<%@page import="model.marca.MarcaDAOImpl"%>
<%@page import="model.marca.Marca"%>
<%@page import="model.direccion.DireccionDAOImpl"%>
<%@page import="model.direccion.Direccion"%>
<%@page import="model.direccion.Direccion"%>
<%@page import="model.cliente.ClienteDAOImpl"%>
<%@page import="model.cliente.Cliente"%>
<%@page import="model.metodoPago.MetodoPagoDAOImpl"%>
<%@page import="model.metodoPago.MetodoPago"%>
<%@page import="model.comprobante.ComprobanteDAOImpl"%>
<%@page import="model.comprobante.Comprobante"%>
<%@page import="model.tipoPedido.TipoPedidoDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="model.tipoPedido.TipoPedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div class="container">
            <% int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));%>
            <% int direccionId = Integer.parseInt(request.getParameter("direccionId"));%>
            <form method="POST" action="Main?action=registrarPedido&nroDoc=<%=nroDocumento%>&direccionId=<%=direccionId%>">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>DNI | RUC</label>    
                            <input class="form-control" disabled="true" maxlength="11" type="number" value="<%=nroDocumento%>">
                        </div>
                        <% Cliente cliente = new ClienteDAOImpl().obtenerCliente(nroDocumento);%>
                        <div class="form-group">
                            <label>Cliente</label>    
                            <input class="form-control" disabled="true" type="text" value="<%=cliente.getNombre()%>">
                        </div>

                        <% Direccion direccion = new DireccionDAOImpl().obtenerDireccion(direccionId);%>
                        <div class="form-group">
                            <label>Dirección</label>    
                            <input class="form-control" disabled="true" type="text" value="<%=direccion.getDireccion()%>">
                        </div>
                        <div class="form-group">
                            <label>Referencia</label>    
                            <input class="form-control" disabled="true" type="text" value="<%=direccion.getReferencia()%>">
                        </div>
                        <div class="form-group" >
                            <label>Método de pago</label>    
                            <select class="form-control" name="metodoPagoId">
                                <%! MetodoPago metodo;%>
                                <% List<MetodoPago> metodos = new MetodoPagoDAOImpl().obtenerMetodos(); %>
                                <% for (int i = 0; i < metodos.size(); i++) {%>
                                <% metodo = metodos.get(i);%>
                                <option value="<%= metodo.getId()%>"><%= metodo.getNombre()%></option>
                                <% }%> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Comprobante</label>    
                            <select class="form-control"  name="comprobanteId">
                                <%! Comprobante comprobante;%>
                                <% List<Comprobante> comprobantes = new ComprobanteDAOImpl().obtenerComprobantes(); %>
                                <% for (int i = 0; i < comprobantes.size(); i++) {%>
                                <% comprobante = comprobantes.get(i);%>
                                <option value="<%= comprobante.getId()%>"><%= comprobante.getNombre()%></option>
                                <% }%> 
                            </select>
                        </div>
                        <div class="form-group" >
                            <label>Tipo de pedido</label>   
                            <select class="form-control" name="tipoPedidoId">
                                <%! TipoPedido tipoPedido;%>
                                <% List<TipoPedido> tipoPedidos = new TipoPedidoDAOImpl().obtenerTipoPedidos(); %>
                                <% for (int i = 0; i < tipoPedidos.size(); i++) {%>
                                <% tipoPedido = tipoPedidos.get(i);%>
                                <option value="<%= tipoPedido.getId()%>"><%= tipoPedido.getNombre()%></option>
                                <% }%> 
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label>Marcas</label>    
                                    <select class="form-control marcas" >
                                        <%! Marca marca;%>
                                        <% List<Marca> marcas = new MarcaDAOImpl().obtenerMarcas(); %>
                                        <% for (int i = 0; i < marcas.size(); i++) {%>
                                        <% marca = marcas.get(i);%>
                                        <option value="<%= marca.getId()%>"><%= marca.getNombre()%></option>
                                        <% }%> 
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Cantidad</label>    
                                    <input id="cantidad" class="form-control" type="number">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label>Productos</label>    
                                    <select id="productos" class="productos form-control">
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input id="agregar" class="btn btn-primary btn-block" onclick="agregarProducto();" type="button" value="Agregar">
                                </div>
                            </div>

                        </div>
                        <div id="detalle">

                        </div>
                        <div class="text-right">
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="Registrar pedido">
                            </div>   
                        </div>

                    </div>

                </div>
            </form>
        </div>
    </body>

    <script>
        $(document).ready(function () {
            obtenerProductos(1);
        });

        $("select.marcas").change(function () {
            var marcaId = $(this).children("option:selected").val();
            obtenerProductos(marcaId);
        });

        function obtenerProductos(marcaId) {
            $.ajax(
                    {
                        url: "Main?action=obtenerProductos&marcaId=" + marcaId,
                        type: "POST",
                        dataType: "json",
                        success: function (data) {
                            $("#productos").empty();
                            for (i = 0; i < data.length; i++) {
                                var option = document.createElement("option");
                                option.value = data[i].id;
                                option.text = data[i].nombre;
                                option.setAttribute('precio', data[i].precio);
                                $("#productos").append(option);
                            }

                        }
                    }
            );
        }
    </script>
</html>
