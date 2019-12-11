<%-- 
    Document   : agregar_Ubicacion
    Created on : 31/07/2019, 04:49:15 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar ubicaciones</title>
    </head>
    <body>
        <h1>Agrega ubicacion a tus productos</h1>
        <form name="form1" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="agregar_Ubicaciones">

            <label for="productos">Productos</label> 
            <input name="producto" list="productos" placeholder="Escribe tu producto">
            <datalist id="productos">
                <c:forEach var="listaP" items="${productoLista}">
                    <option value="${listaP.id}">${listaP.nombre}</option>
                </c:forEach>
            </datalist>

            <label for="pais">Ubicacion</label> 
            <input name="almacen" list="almacenes" placeholder="Escribe tu ubicacion">
            <datalist id="almacenes">
                <c:forEach var="listado" items="${almacenLista}">
                    <option value="${listado.id}">${listado.nombre}</option>
                </c:forEach>
            </datalist>

            <input type="submit" value="Anadir">
        </form>
    </body>
</html>
