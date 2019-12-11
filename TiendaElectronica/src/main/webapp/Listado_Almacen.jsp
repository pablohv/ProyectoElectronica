<%-- 
    Document   : Almacen
    Created on : 25/07/2019, 08:58:10 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-light">
                <div class="card-header">Listado de almacenes</div>
                <div class="card-body">

                    <h4 class="card-title">
                        <a href="Agregar_Almacen.jsp" class="btn btn-primary btn-xs">Agregar nuevo Almacen</a>  
                        <a href="menu.jsp" class="btn btn-primary btn-xs">Volver al menu</a>
                    </h4>
                    <table class="table table-striped table-bordered">
                        <thead class="thead-inverse">
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Ubicacion</th>
                                <th>Estado</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <%-- se le asigna una variable y el nombre que viene con el objeto desde el controlador--%>
                        <c:forEach var="listado" items="${almacen}">

                            <c:url var="linkActualizar" value="ControladorElectronica">
                                <c:param name="instruccion" value="cargar_Almacen"></c:param>
                                <c:param name="id_Almacen" value="${listado.id}"></c:param>
                            </c:url>

                            <%-- link para eliminar registros con su campo clave --%>
                            <c:url var="linkEliminar" value="ControladorElectronica">
                                <c:param name="instruccion" value="eliminar_Almacen"></c:param>
                                <c:param name="id_Almacen" value="${listado.id}"></c:param>
                            </c:url>
                            <tbody>
                                <tr>
                                    <td>${listado.id}</td>
                                    <td>${listado.nombre}</td>
                                    <td>${listado.ubicacion}</td>
                                    <td>${listado.estado}</td>
                                    <td><a href="${linkActualizar}" class="btn btn-primary btn-xs">Actualizar</a> <a href="${linkEliminar}" class="btn btn-danger btn-xs">Elimiar </a></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>
