<%-- 
    Document   : eliminarMarca
    Created on : 04/07/2021, 11:41:25 PM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <% int marcaId = Integer.parseInt(request.getParameter("marcaId"));%>
        <div class="container">
            <h5>¿Realmente desea eliminar la marca?</h5>
            <br>
            <form method="POST" action="Main?action=eliminarMarca&marcaId=<%=marcaId%>">
                <input type="submit" class="btn btn-primary btn-block" value="Aceptar">
            </form>
        </div>
    </body>
</html>
