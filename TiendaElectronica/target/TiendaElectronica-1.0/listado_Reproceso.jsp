<%-- 
    Document   : listado_Reproceso
    Created on : 2/08/2019, 07:25:41 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reparaciones en proceso</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-light">
                <div class="card-header">En proceso</div>
                <div class="card-body">

                    <h4 class="card-title">
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
                            <th>Accion</th>
                        </tr>

                        <c:forEach var="listado" items="${reparacionesProceso}">

                            <c:url var="linkActualizar" value="ControladorElectronica">
                                <c:param name="instruccion" value="obtener_Repenproceso"></c:param>
                                <c:param name="id_Reparacion" value="${listado.idRep}"></c:param>
                            </c:url>

                            <tr>
                                <td>${listado.idRep}</td>
                                <td>${listado.fechaEntrada}</td>
                                <td>${listado.nombre}</td>
                                <td>${listado.aparato}</td>
                                <td>${listado.descripcion}</td>
                                <td>${listado.costo}</td>
                                <td><a href="${linkActualizar}" class="btn btn-primary btn-xs">Entregar</a></td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
