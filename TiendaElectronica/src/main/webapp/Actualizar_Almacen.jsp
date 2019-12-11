<%-- 
    Document   : Actualizar_Almacen
    Created on : 25/07/2019, 10:11:21 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar los datos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container py-4">

            <div class="card bg-dark text-white">
                <div class="card-header">Actualizar Almacen</div>
                <div class="card-body">
                    <form name="form1" method="get" action="ControladorElectronica" >
                        <input type="hidden" name="instruccion" value="actualizar_Almacen">
                        <input type="hidden" name="codigo" value="${AlmacenActualizar.id}">

                        <div class="form-group row">
                            <label for="id" class="col-sm-2 col-form-label">Codigo</label>
                            <div class="col-sm-6">
                                <input disabled="" name="id" type="text" value="${AlmacenActualizar.id}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                            <div class="col-sm-6">
                                <input name="nombre" type="text" value="${AlmacenActualizar.nombre}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="ubicacion" class="col-sm-2 col-form-label">Ubicacion</label>
                            <div class="col-sm-6">
                                <input name="ubicacion" type="text" value="${AlmacenActualizar.ubicacion}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="estado" class="col-sm-2 col-form-label">Estado</label>
                            <div class="col-sm-6">
                                <input name="estado" type="text" value="${AlmacenActualizar.estado}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-6">
                                <input type="submit" name="envio" value="Actualizar" id="envio" class="btn btn-secondary">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
