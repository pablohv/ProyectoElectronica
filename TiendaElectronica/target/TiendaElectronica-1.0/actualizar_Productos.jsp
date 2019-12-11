<%-- 
    Document   : actualizar_Productos
    Created on : 30/07/2019, 03:08:15 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Actualizar Producto</h1>
        <form name="form1" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="actualizar_Producto">
            <input type="hidden" name="codigo" value="${obtenProducto.id}">
            <input type="hidden" name="cantidad" value="${obtenProducto.cantidad}">
            
            <label for="id">Codigo</label>
            <input type="text" name="id" value="${obtenProducto.id}" disabled="">
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" value="${obtenProducto.nombre}">
            <label for="costo">Costo</label>
            <input type="text" name="costo" value="${obtenProducto.costo}">
            <label for="cantidad">Cantidad</label>
            <input type="text" name="" value="${obtenProducto.cantidad}" disabled="">
            <br>
            <input type="submit" value="Actualizar">
        </form>
    </body>
</html>
