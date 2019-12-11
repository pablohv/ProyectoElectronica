<%-- 
    Document   : listado_Ubicacion
    Created on : 31/07/2019, 03:22:50 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubicaciones</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-light">
                <div class="card-header">Listado de las ubicaciones</div>
                <div class="card-body">

                    <h4 class="card-title">
                        <a href="menu.jsp" class="btn btn-primary btn-xs">Volver al menu</a>
                    </h4>
                    <table class="table table-striped table-bordered">
                        <tr class="thead-inverse">
                            <th>idProducto</th>
                            <th>Nombre</th>
                            <th>Costo</th>
                            <th>idAlmacen</th>
                            <th>Nombre</th>
                            <th>Ubicacion</th>
                            <th>Accion</th>
                        </tr>

                        <c:url var="linkCarga" value="ControladorElectronica">
                            <c:param name="instruccion" value="cargar_Ubicaciones"></c:param>
                        </c:url>

                        <c:forEach var="listado" items="${ubicate}">

                            <%-- link para eliminar registros con su campo clave --%>
                            <c:url var="linkEliminar" value="ControladorElectronica">
                                <c:param name="instruccion" value="eliminar_Ubicacion"></c:param>
                                <c:param name="id_Producto" value="${listado.idProducto}"></c:param>
                                <c:param name="id_Almacen" value="${listado.idAlm}"></c:param>
                            </c:url>

                            <tr>
                                <td>${listado.idProducto}</td>
                                <td>${listado.nombrePro}</td>
                                <td>${listado.costo}</td>
                                <td>${listado.idAlm}</td>
                                <td>${listado.nombreAl}</td>
                                <td>${listado.ubicacion}</td>
                                <td><a href="${linkEliminar}" class="btn btn-danger btn-xs">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="${linkCarga}" class="btn btn-primary btn-xs">Registar ubicacion</a>
                </div>
            </div>
        </div>
    </body>
</html>
