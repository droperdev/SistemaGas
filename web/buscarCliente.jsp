<%-- 
    Document   : buscarCliente
    Created on : 07/07/2021, 04:16:53 AM
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
            <div class="form-group">
                <label>DNI | RUC</label>    
                <div class="input-group">
                    <input id="nroDocumento" class="form-control" type="number" value="" name="nroDocumento">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button" onclick="buscarCliente();">Buscar</button>
                    </div>
                </div>
            </div>
            <div id="direcciones">

            </div>
        </div>
    </body>
</html>
