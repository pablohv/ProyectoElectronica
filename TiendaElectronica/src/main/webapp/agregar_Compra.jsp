<%-- 
    Document   : compra
    Created on : 31/07/2019, 08:47:35 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body>
        <h1>Registra la compra</h1>
        <form name="form1" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="agregar_Compras">

            <label for="productos">Productos</label> 
            <input name="producto" list="productos" placeholder="Escribe tu producto">
            <datalist id="productos">
                <c:forEach var="listaP" items="${productoLista}">
                    <option value="${listaP.id}">${listaP.nombre}</option>
                </c:forEach>
            </datalist>

            <label for="cantidad">Cantidad</label>
            <input name="cantidad" type="text">

            <label for="fecha">Fecha de compra</label>
            <input type="date" name="fecha">

            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
