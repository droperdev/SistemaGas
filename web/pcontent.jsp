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
            <div class="dropdown">
                <a class="btn fa fa-ellipsis-v" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <button class="dropdown-item" onclick="actualizarProducto('<%=producto.getId()%>');" ><i class="fa fa-pencil"></i>&nbsp;&nbsp;&nbsp;Actualizar producto</button>
                    <button class="dropdown-item" onclick="eliminarProducto('<%=producto.getId()%>');" ><i class="fa fa-trash"></i>&nbsp;&nbsp;&nbsp;Eliminar producto</button>
                </div>
            </div>
            <img src="<%=producto.getFotoUrl()%>" />
            <%=producto.getNombre()%><br>
            S/&nbsp;<%=String.format("%.2f", producto.getPrecio())%>
        </div>
        <%}%>
    </body>
</html>
