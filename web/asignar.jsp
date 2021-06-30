<%-- 
    Document   : asignar
    Created on : 30/06/2021, 01:20:02 AM
    Author     : droperdev
--%>

<%@page import="model.usuario.UsuarioDAOImpl"%>
<%@page import="dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));%>
        <% List<UsuarioDTO> usuarios = new UsuarioDAOImpl().obtenerDistribuidores();%>
        <div class="container">
            <form method="POST" action="Main?action=asignar&pedidoId=<%=pedidoId%>">
                <div class="form-group">
                    <label>Distribuidores</label>
                    <select name="repartidorId" class="form-control">
                        <%for (UsuarioDTO usuario : usuarios) {%>
                        <option value="<%=usuario.getId()%>"><%=usuario.getFullName()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="form-group">
                    <input class="btn btn-primary btn-block" type="submit" value="Asignar">
                </div>   
            </form>

        </div>
    </body>
</html>
