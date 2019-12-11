<%-- 
    Document   : agregar_Reparaciones
    Created on : 2/08/2019, 06:52:06 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Reparacion o servicio</title>
    </head>
    <body>
        <h1>Agregar</h1>
        <form name="form1" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="agregar_Reparacion">
            
            <label>Fecha Recepcion</label>
            <input type="date" name="fecha">
            
            <label>Nombre (persona que entrega)</label>
            <input type="text" name="nombre">
            
            <label>Aparato o servicio</label>
            <input type="text" name="aparato">
            
            <label>Descripcion</label>
            <input type="text" name="descripcion">
            
            <label>Costo</label>
            <input type="number" name="costo">
            
            <input type="submit" value="Agregar reparacion">
        </form>
    </body>
</html>
