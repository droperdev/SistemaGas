<%-- 
    Document   : registrarDetallePedido
    Created on : 08/07/2021, 01:36:46 AM
    Author     : droperdev
--%>

<%@page import="dto.DetalleDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="table-responsive">
            <% Double sum = 0.0; %>
            <%

                List<DetalleDTO> detalles = (List<DetalleDTO>) session.getAttribute("detalles");
            %>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Cantidad</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>SubTotal</th>
                    </tr>
                </thead>
                <tbody>
                    <%! DetalleDTO detalle;%>
                    <% for (int i = 0; i < detalles.size(); i++) { %>
                    <% detalle = detalles.get(i);%>
                    <% sum += detalle.getCantidad() * detalle.getPrecio();%>
                    <tr>
                        <td><%=detalle.getCantidad()%></td>
                        <td><%=detalle.getNombre()%></td>
                        <td><%=detalle.getPrecio()%></td>
                        <td class="text-center">S/ <%=String.format("%.2f", detalle.getCantidad() * detalle.getPrecio())%></td>
                    </tr>
                    <% }%>
                    <tr>
                        <td class="text-right" colspan="3">Total:</td>
                        <td class="text-center">S/&nbsp; <%=String.format("%.2f", sum)%></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>

