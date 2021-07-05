<%-- 
    Document   : actualizarProducto
    Created on : 05/07/2021, 12:52:41 AM
    Author     : droperdev
--%>

<%@page import="dto.ProductoDTO"%>
<%@page import="model.producto.ProductoDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% int productoId = Integer.parseInt(request.getParameter("productoId"));%>
        <% ProductoDTO producto = new ProductoDAOImpl().obtenerProducto(productoId);%>
        <div class="container">
            <form method="POST" action="Main?action=actualizarProducto&productoId=<%=productoId%>">
                <div >
                    <div class="form-group">
                        <label>Nombre</label>    
                        <input class="form-control" type="text" value="<%=producto.getNombre()%>" name="nombre">
                    </div>
                    <div class="form-group">
                        <label>Descripcion</label>    
                        <input class="form-control" type="text" value="<%=producto.getDescripcion()%>" name="descripcion" >
                    </div>
                    <div class="form-group">
                        <label>Foto Url</label>    
                        <input class="form-control" type="text" value="<%=producto.getFotoUrl()%>" name="fotoUrl">
                    </div>
                    <div class="form-group">
                        <label>Stock</label>    
                        <input class="form-control" type="text" value="<%=producto.getStock()%>" name="stock" >
                    </div>
                    <div class="form-group">
                        <label>Precio</label>    
                        <input class="form-control" type="text" value="<%=producto.getPrecio()%>" name="precio">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="submit" value="Guardar producto">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
