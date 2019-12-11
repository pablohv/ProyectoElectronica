<%-- 
    Document   : index
    Created on : 17/07/2019, 02:38:23 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/normalize.css">
        <link rel="stylesheet" href="resources/estilos.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Electronica - Iniciar sesion</title>
    </head>
    <body>
        <header>
            <h1>Bienvenido - Electronica Sony</h1>
        </header>
        <div class="main-div">
            <h2 class="main-title">Iniciar sesion</h2>
            <form name="form1" class="main-form" method="POST" action="ControladorElectronica">
                <input type="hidden" name="instruccion" value="validar">
                <label for="usuario" class="main-form__label">Usuario</label>
                <input name="usuario" class="main-form__input" id="usuario" autofocus="" type="text" required="required"
                       placeholder="Ingrese usuario">

                <label for="password" class="main-form__label">Password</label>
                <input name="password" class="main-form__input" id="password" type="password" required="required"
                       placeholder="Ingrese una contrasena">
                <br>
                <input class="main-form__submit" type="submit" value="Ingresar">
                <button type="button" class="btn btn-primary">Primary</button>
            </form>
            <div class="main-cont"></div>
        </div>
    </body>
</html>
