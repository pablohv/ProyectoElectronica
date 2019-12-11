<%-- 
    Document   : agregar_Venta
    Created on : 1/08/2019, 07:59:25 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <h1>Registra venta</h1>
        <form name="form1" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="agregar_Ventas">

            <label for="productos">Productos</label> 
            <input name="producto" list="productos" placeholder="Escribe tu producto">
            <datalist id="productos">
                <c:forEach var="listaP" items="${productoLista}">
                    <option value="${listaP.id}">${listaP.nombre}</option>
                </c:forEach>
            </datalist>

            <label for="cantidad">Cantidad</label>
            <input name="cantidad" type="text">

            <label for="fecha">Fecha de venta</label>
            <input type="date" name="fecha">

            <input type="submit" value="Registrar">
        </form>
        <div>${mensaje}</div>
        <c:url var="linkVentas" value="ControladorElectronica">
            <c:param name="instruccion" value="listar_Ventas"></c:param>
        </c:url>
        <a href="${linkVentas}">Listado de ventas</a>
    </body>
</html>
