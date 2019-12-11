<%-- 
    Document   : Agregar_Almacen
    Created on : 25/07/2019, 10:10:50 PM
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
        <h1>Agregar nuevo estante</h1>
        <form name="form2" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="agregar_Almacen">
            <label for="nombre">Nombre</label>
            <input name="nombre" type="text">
            <label for="ubicacion">Ubicacion</label>
            <input name="ubicacion" type="text">
            <label for="estado">Estado</label>
            <input name="estado" type="text">
            <br>
            <input type="submit" value="Agregar">
        </form>
        <a></a>
    </body>
</html>
