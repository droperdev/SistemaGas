<%-- 
    Document   : mapa
    Created on : 29/06/2021, 02:16:22 AM
    Author     : droperdev
--%>

<%@page import="model.pedido.PedidoDAOImpl"%>
<%@page import="dto.PedidoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="css/mapa.css" >

    </head>
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
                </div> 
                <div class="col-md-7">
                    <div id="map"></div>
                </div>
            </div>
        </div>
        <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOAAHVDvmTffo2K5ojmW_m42n4paYtrL0&callback=initMap">
        </script>
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById("map"), {
                    center: {lat: <%=pedido.getDireccion().getLatitud()%>, lng: <%=pedido.getDireccion().getLongitud()%>},
                    zoom: 14,
                    disableDefaultUI: true,
                });

                new google.maps.Marker({
                    position: {lat: <%=pedido.getDireccion().getLatitud()%>, lng: <%=pedido.getDireccion().getLongitud()%>},
                    icon: 'assets/casa.png',
                    map,
                    title: "<%=pedido.getDireccion().getDireccion()%>"
                });
            }


        </script>
    </body>
</html>
