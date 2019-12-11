<%-- 
    Document   : listado_Compra
    Created on : 31/07/2019, 09:24:23 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-light">
                <div class="card-header">Listado de compras</div>
                <div class="card-body">

                    <h4 class="card-title">
                        
                        <a href="menu.jsp" class="btn btn-primary btn-xs">Volver al menu</a>
                    </h4>
                    <table class="table table-striped table-bordered">
                        <tr class="thead-inverse">
                            <th>IdCompra</th>
                            <th>IdProducto</th>
                            <th>Cantidad</th>
                            <th>Fecha</th>
                        </tr>

                        <c:url var="linkCarga" value="ControladorElectronica">
                            <c:param name="instruccion" value="cargar_Compras"></c:param>
                        </c:url>

                        <c:forEach var="listado" items="${compras}">
                            <tr>
                                <td>${listado.idCom}</td>
                                <td>${listado.idPro}</td>
                                <td>${listado.cantidadCom}</td>
                                <td>${listado.fechaCom}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="${linkCarga}" class="btn btn-primary btn-xs">Registar compras</a> 
                </div>
            </div>
        </div>

    </body>
</html>
