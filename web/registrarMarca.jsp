<%-- 
    Document   : registrarMarca
    Created on : 01/07/2021, 08:22:49 PM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
        <div class="container">
            <form method="POST" action="Main?action=registrarMarca">
                <div >
                    <div class="form-group">
                        <label>Nombre</label>    
                        <input class="form-control" type="text" value="" name="nombre" id="nombre">
                    </div>
                    <div class="form-group">
                        <label>Foto Url</label>    
                        <input class="form-control" type="text" value="" name="fotoUrl" id="fotoUrl">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="submit" value="Guardar Marca">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
