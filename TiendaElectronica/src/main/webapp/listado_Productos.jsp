<%-- 
    Document   : listado_Productos
    Created on : 27/07/2019, 12:50:01 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-light">
                <div class="card-header">Listado de productos</div>
                <div class="card-body">

                    <h4 class="card-title">
                        <a href="agregar_Productos.jsp" class="btn btn-primary btn-xs">Agregar producto</a>
                        <a href="menu.jsp" class="btn btn-primary btn-xs">Volver al menu</a>
                    </h4>
                    <table class="table table-striped table-bordered">
                        <tr class="thead-inverse">
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Costo</th>
                            <th>Cantidad</th>
                            <th>Accion</th>
                        </tr>

                        <c:forEach var="listado" items="${producto}">

                            <c:url var="linkActualizar" value="ControladorElectronica">
                                <c:param name="instruccion" value="cargar_Producto"></c:param>
                                <c:param name="id_Producto" value="${listado.id}"></c:param>
                            </c:url>

                            <%-- link para eliminar registros con su campo clave --%>
                            <c:url var="linkEliminar" value="ControladorElectronica">
                                <c:param name="instruccion" value="eliminar_Producto"></c:param>
                                <c:param name="id_Producto" value="${listado.id}"></c:param>
                            </c:url>

                            <tr>
                                <td>${listado.id}</td>
                                <td>${listado.nombre}</td>
                                <td>${listado.costo}</td>
                                <td>${listado.cantidad}</td>
                                <td><a href="${linkActualizar}" class="btn btn-primary btn-xs">Actualizar</a> <a href="${linkEliminar}" class="btn btn-danger btn-xs">Eliminar </a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>
