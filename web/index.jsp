<%-- 
    Document   : index
    Created on : 17/04/2021, 04:20:02 AM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("usuario") == null) {

%>
<html lang="es">
    <head>
        <meta charset="utf-8" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Iniciar sesión</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link  rel="stylesheet"  href="css/login.css" >
        <link  rel="stylesheet"  href="css/common.css" >

    </head>
    <body>
        <%            
          String message = (String) session.getAttribute("mensaje");
        %>
        <div class="card content-login">
            <img src="./assets/logo.png" alt="">
            <hr>
            <form method="POST" action="Login?action=login">
                <div class="form-group">
                    <label for="usuario">Usuario</label>
                    <input id="usuario" class="form-control" type="text" name="usuario" value ="jaguirre@gmail.com"/>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input id="password" class="form-control" maxlength="6" type="password" name="password" value="123456"/>
                </div>
                <input class="btn btn-primary btn-block" type="submit" value="Iniciar sesion">
                <% if (message != null) {%>
                <br>
                <label class="text-danger"> ${message} </label>
                <% session.removeAttribute("message");
                    }%>           
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("marcas.jsp");
    }
%>
