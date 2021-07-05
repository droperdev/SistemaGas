<%-- 
    Document   : registrarProducto
    Created on : 01/07/2021, 08:29:48 PM
    Author     : droperdev
--%>

<%@page import="model.marca.Marca"%>
<%@page import="model.marca.MarcaDAOImpl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="container">
            <form method="POST" action="Main?action=registrarProducto">
                <div >
                    <div class="form-group">
                        <label>Marca</label>
                        <select class="form-control" name="marcaId">
                            <%! Marca marca;%>
                            <% List<Marca> marcas = new MarcaDAOImpl().obtenerMarcas(); %>
                            <% for (int i = 0; i < marcas.size(); i++) {%>
                            <% marca = marcas.get(i);%>
                            <option value="<%= marca.getId()%>"><%= marca.getNombre()%></option>
                            <% }%> 
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Nombre</label>    
                        <input class="form-control" type="text" name="nombre">
                    </div>
                    <div class="form-group">
                        <label>Descripción</label>    
                        <input class="form-control" type="text" name="descripcion" >
                    </div>
                    <div class="form-group">
                        <label>Foto Url</label>    
                        <input class="form-control" type="text" name="fotoUrl">
                    </div>
                    <div class="form-group">
                        <label>Stock</label>    
                        <input class="form-control" type="number" name="stock">
                    </div>
                    <div class="form-group">
                        <label>Precio</label>    
                        <input class="form-control" type="number" name="precio">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="submit" value="Guardar Producto">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
