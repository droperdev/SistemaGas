<%-- 
    Document   : direcciones
    Created on : 07/07/2021, 04:24:45 AM
    Author     : droperdev
--%>

<%@page import="model.direccion.Direccion"%>
<%@page import="model.direccion.DireccionDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="model.cliente.ClienteDAOImpl"%>
<%@page import="model.cliente.Cliente"%>
<%@page import="model.cliente.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% int nroDocumento = Integer.parseInt(request.getParameter("nroDocumento"));%>
        <% Cliente cliente = new ClienteDAOImpl().obtenerCliente(nroDocumento);%>
        <% if (cliente != null) {%>
        <div class="form-group">
            <label>Nombre</label>    
            <input class="form-control" disabled="true" type="text" value="<%= cliente.getNombre()%>" name="nombre" id="nombre">
        </div>
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Dirección</th>
                        <th>Referencia</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Direccion> direcciones = new DireccionDAOImpl().obtenerDirecciones(nroDocumento); %>
                    <%! Direccion direccion;%>
                    <% for (int i = 0; i < direcciones.size(); i++) { %>
                    <% direccion = direcciones.get(i);%>
                    <tr onclick="abrirRegistrarPedido(<%=nroDocumento%>,<%=direccion.getId()%>);">
                        <td><%=direccion.getDireccion()%></td>
                        <td><%=direccion.getReferencia()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <% } else {%>
        <div class="text-center">
            No se encontro ningun cliente con este documento, ¿Desea registrarlo?<br><br>
            <div class="form-group">
                <input class="btn btn-primary" type="button" value="Registrar" onclick="registrarCliente();">
            </div>
        </div>
        <%}%>
    </body>
</html>
