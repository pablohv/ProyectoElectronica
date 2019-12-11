<%-- 
    Document   : menu
    Created on : 17/07/2019, 02:39:07 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/menu-estilos.css">
        <link rel="stylesheet" href="resources/normalize.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
        <title>Electronica - Menu</title>
    </head>
    <body>
        <header>
            <h1>Menu - Electronica Sony</h1>
        </header>
        <div class="d-flex">
            <div class="div-productos">
            <h3>Productos</h3>
            <c:url var="linkAlmacen" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_Almacen"></c:param>
            </c:url>
            <a href="${linkAlmacen}">Almacen</a>

            <c:url var="linkProductos" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_Producto"></c:param>
            </c:url>
            <a href="${linkProductos}">Producto</a>

            <c:url var="linkUbicacion" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_ubicacion"></c:param>
            </c:url>
            <a href="${linkUbicacion}">ubicacion</a>
        </div>

        <div class="div-servicios">
            <h3>Servicios</h3>
            <c:url var="linkReparaciones" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_Reparaciones"></c:param>
            </c:url>
            <a href="${linkReparaciones}">Reparaciones</a>

            <c:url var="linkRepProceso" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_Repenproceso"></c:param>
            </c:url>
            <a href="${linkRepProceso}">Reparaciones en proceso</a>
        </div>

        <div class="div-ventas">
            <h3>Ventas</h3>
            <c:url var="linkCompras" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_Compras"></c:param>
            </c:url>
            <a href="${linkCompras}">Compras</a>

            <c:url var="linkVentas" value="ControladorElectronica">
                <c:param name="instruccion" value="listar_Ventas"></c:param>
            </c:url>
            <a href="${linkVentas}">Ventas</a>
        </div>
            
        </div>
        
    </body>
</html>
