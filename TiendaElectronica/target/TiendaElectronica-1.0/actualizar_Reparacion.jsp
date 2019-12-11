<%-- 
    Document   : actualizar_Reparacion
    Created on : 2/08/2019, 09:49:39 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualiza Reparaciones</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Registra la entrega</h1>
        <form name="form" method="get" action="ControladorElectronica">
            <input type="hidden" name="instruccion" value="actualizar_estatus">
            <input type="hidden" name="codigo" value="${repareishon.idRep}">

            <label>Id Reparacion</label>
            <input type="text" name="" value="${repareishon.idRep}" disabled="">

            <label>Fecha Recepcion</label>
            <input type="text" name="" value="${repareishon.fechaEntrada}" disabled="">

            <label>Nombre (persona que entrega)</label>
            <input type="text" name="" value="${repareishon.nombre}" disabled="">

            <label>Aparato o servicio</label>
            <input type="text" name="" value="${repareishon.aparato}" disabled="">

            <label>Descripcion</label>
            <input type="text" name="" value="${repareishon.descripcion}" disabled="">

            <label>Costo</label>
            <input type="text" name="" value="${repareishon.costo}" disabled="">

            <label>Fecha Entrega</label>
            <input type="date" name="fecha">

            <label>Nombre (de quien recoge)</label>
            <input type="text" name="nombre">

            <input type="submit" value="Agregar entrega">
        </form>
    </body>
</html>
