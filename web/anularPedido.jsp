<%-- 
    Document   : anularPedido
    Created on : 30/06/2021, 02:55:43 AM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
      <% int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));%>
        <div class="container">
            <h5>¿Realmente desea anular el pedido?</h5>
            <br>
            <form method="POST" action="Main?action=anular&pedidoId=<%=pedidoId%>">
                <input type="submit" class="btn btn-primary btn-block" value="Aceptar">
            </form>
        </div>
    </body>
</html>
