<%-- 
    Document   : listado_Reparaciones
    Created on : 2/08/2019, 05:32:26 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-light">
                <div class="card-header">Reparaciones y/o servicios completados</div>
                <div class="card-body">

                    <h4 class="card-title">
                        <a href="agregar_Reparaciones.jsp" class="btn btn-primary btn-xs">Agregar reparacion</a>
                        <a href="menu.jsp" class="btn btn-primary btn-xs">Volver al menu</a>
                    </h4>
                    <table class="table table-striped table-bordered">
                        <tr class="thead-inverse">
                            <th>IdReparacion</th>
                            <th>Fecha Recepcion</th>
                            <th>Nombre de quien entrega</th>
                            <th>Aparato o servicio</th>
                            <th>Descripcion</th>
                            <th>Costo</th>
                            <th>Fecha entrega</th>
                            <th>Nombre de quien recibe</th>
                        </tr>

                        <c:forEach var="listado" items="${reparacionesTerminadas}">
                            <tr>
                                <td>${listado.idRep}</td>
                                <td>${listado.fechaEntrada}</td>
                                <td>${listado.nombre}</td>
                                <td>${listado.aparato}</td>
                                <td>${listado.descripcion}</td>
                                <td>${listado.costo}</td>
                                <td>${listado.fechaSalida}</td>
                                <td>${listado.nombreRecoge}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>


    </body>
</html>
