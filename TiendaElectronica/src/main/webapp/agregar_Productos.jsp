<%-- 
    Document   : agregar_Productos
    Created on : 30/07/2019, 03:07:54 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar nuevo producto</h1>
        <form name="form1" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="agregar_Producto">
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre">
            <label for="costo">Costo</label>
            <input type="text" name="costo">
            <label for="cantidad">Cantidad</label>
            <input type="text" name="cantidad">
            <br>
            <input type="submit" value="Agregar">
        </form>
    </body>
</html>
