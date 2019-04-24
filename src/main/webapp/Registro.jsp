<%-- 
    Document   : Registro
    Created on : 13/03/2019, 03:11:41 PM
    Author     : PC02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>CopyQuick</title>
        <script src="JS/jquery-3.3.1.min.js"></script>
        <script src="JS/ajax.js"></script>
    </head>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Comfortaa');

        body {
            background: #456;
            font-family: 'Comfortaa', cursive;
        }

        .container {
            width: 500px;
            margin: 16px auto;
            font-size: 16px;
            background: rgb(34, 136, 221);
        }

        .header h1 {
            text-align: left;
            padding: 15px;
            margin-left: 15px;
            padding-bottom: 0%;
            color: rgb(255, 255, 255);
        }

        .body {
            background: rgb(233, 232, 232);
            text-align: center;
            padding: 15px;
        }

        .body label {
            color: rgba(0, 0, 0, 0.603);
        }

        .body button.BTN {
            font-size: 5mm;
            border: none;
            border-radius: 8px;
            background: rgb(0, 183, 255);
            font-family: 'Comfortaa', cursive;
            color: white;
            height: 5%;
        }

        .body button.BTN:hover {
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }

        .information input {
            margin-bottom: 15px;
            text-align: center;
            color: rgba(0, 0, 0, 0.603);
            background-color: rgb(233, 232, 232);
            border: none;
            font-family: 'Comfortaa', cursive;
        }

        .information select {
            border: none;
            background: rgb(233, 232, 232);
            font-family: 'Comfortaa', cursive;
            color: rgba(0, 0, 0, 0.603);
            background-color: rgb(233, 232, 232);
        }
        h5#bien{
            font-family: 'Comfortaa', cursive;
            color: rgb(133, 255, 85);
        }
        h5#mal{
            font-family: 'Comfortaa', cursive;
            color: rgb(255, 82, 82);
        }
    </style>

    <body>

        <div class="container">
            <div class="header">
                <h1>CopyQuick</h1>
            </div>

            <div class="body">
                <h1>Bienvenido</h1>
                <h4 class="result">Porfavor ingresar todos los datos pedidos.</h4>
                <br>
                <div class=information>
                    <input id="nomUsuario" placeholder="Nombre de Usuario">
                    <br>
                    <br>
                    <input id="contrasena" type="password" placeholder="Contrasena">
                    <br>
                    <br>
                    <select id="tipoUsuario" onChange="tipoUsuario()">
                        <option>Escoge una opción</option>
                        <option value="estudiante">Estudiante</option>
                        <option value="profesor">Profesor</option>
                       
                    </select>
                </div>
                <br>
                <br>
                <button class="BTN" style="height: 7.5%; width: 30%" onclick="registrar()">Registrar</button>
                <button class="BTN" style="height: 7.5%; width: 30%" onclick="myFunction()">Cancelar</button>
            </div>
        </div>
        <script>
            function myFunction() {
                location.replace("Login.jsp")
            }
        </script>
    </body>

</html>
