<%-- 
    Document   : pcontent
    Created on : 22/06/2021, 10:58:15 PM
    Author     : droperdev
--%>

<%@page import="model.producto.ProductoDAOImpl"%>
<%@page import="dto.ProductoDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <% int marcaId = Integer.parseInt(request.getParameter("marcaId"));%>
          <% List<ProductoDTO> productos = new ProductoDAOImpl().obtenerProductos(marcaId); %>
                <%! ProductoDTO producto;%>
                <% for (int i = 0; i < productos.size(); i++) { %>
                <% producto = productos.get(i);%>
                <div class="card producto">
                    <img src="<%=producto.getFotoUrl()%>" />
                    <%=producto.getNombre()%><br>
                    S/&nbsp;<%=String.format("%.2f", producto.getPrecio())%>
                </div>
                <%}%>
    </body>
</html>
