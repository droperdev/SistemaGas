<%-- 
    Document   : registrarCliente
    Created on : 07/07/2021, 05:11:01 AM
    Author     : droperdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="css/mapa.css" >
    </head>
    <body>
        <% Long nroDocumento = Long.parseLong(request.getParameter("nroDocumento"));%>
        <div class="container">
            <form id="form-registrar">
                <div class="row">
                    <div class="col-lg-6">

                        <div class="form-group">
                            <label>DNI | RUC (*)</label>    
                            <input class="form-control" type="text" value="<%=nroDocumento%>" name="nroDoc">
                        </div>
                        <div class="form-group">
                            <label>Nombre (*)</label>    
                            <input class="form-control" type="text" value="" name="nombre">
                        </div>
                        <div class="form-group">
                            <label>Celular</label>    
                            <input class="form-control" type="text" value="" name="celular">
                        </div>
                        <div class="form-group">
                            <label>Correo electrónico</label>    
                            <input class="form-control" type="text" value="" name="correo">
                        </div>
                        <div class="form-group">
                            <label>Dirección(*)</label>    
                            <input class="form-control" type="text" value="" name="direccion">
                        </div>
                        <div class="form-group">
                            <label>Referencia (*)</label>    
                            <input class="form-control" type="text" value="" name="referencia">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <input id="latitud" class="form-control" type="hidden" name="latitud"/>
                        <input id="longitud" class="form-control" type="hidden" name="longitud"/>
                        <div class="form-group">
                            <div id="map"></div>
                        </div>

                        <div class="form-group">
                            <input class="btn btn-primary btn-block" type="button" onclick="registrarCliente();" value="Guardar cliente">
                        </div>
                    </div>
            </form>
        </div>
    </body>
    <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOAAHVDvmTffo2K5ojmW_m42n4paYtrL0&callback=iniciarMapa">
    </script>
    <<script>
        function iniciarMapa() {
            document.getElementById("latitud").value = -12.049163;
            document.getElementById("longitud").value = -76.967201;

            var map = new google.maps.Map(document.getElementById("map"), {
                center: {lat: -12.049163, lng: -76.967201},
                zoom: 14,
                disableDefaultUI: true,
            });

            var marker = new google.maps.Marker({
                position: {lat: -12.049163, lng: -76.967201},
                icon: 'assets/casa.png',
                map,
                draggable: true
            });

            google.maps.event.addListener(marker, 'dragend', function (event) {
                document.getElementById("latitud").value = event.latLng.lat();
                document.getElementById("longitud").value = event.latLng.lng();
            });
        }

    </script>
</html>
