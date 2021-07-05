<%-- 
    Document   : eliminarProducto
    Created on : 05/07/2021, 12:53:06 AM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <body>
        <% int productoId = Integer.parseInt(request.getParameter("productoId"));%>
        <div class="container">
            <h5>¿Realmente desea eliminar el producto?</h5>
            <br>
            <form method="POST" action="Main?action=eliminarProducto&productoId=<%=productoId%>">
                <input type="submit" class="btn btn-primary btn-block" value="Aceptar">
            </form>
        </div>
    </body>
</body>
</html>
