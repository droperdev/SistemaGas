<%-- 
    Document   : actualizarMarca
    Created on : 04/07/2021, 11:57:02 PM
    Author     : droperdev
--%>

<%@page import="model.marca.Marca"%>
<%@page import="model.marca.MarcaDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int marcaId = Integer.parseInt(request.getParameter("marcaId"));%>
        <% Marca marca = new MarcaDAOImpl().obtenerMarca(marcaId);%>
        <div class="container">
            <form method="POST" action="Main?action=actualizarMarca&marcaId=<%=marcaId%>">
                <div >
                    <div class="form-group">
                        <label>Nombre</label>    
                        <input class="form-control" type="text" value="<%=marca.getNombre()%>" name="nombre" id="nombre">
                    </div>
                    <div class="form-group">
                        <label>Foto Url</label>    
                        <input class="form-control" type="text" value="<%=marca.getLogo()%>" name="fotoUrl" id="fotoUrl">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="submit" value="Guardar Marca">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
