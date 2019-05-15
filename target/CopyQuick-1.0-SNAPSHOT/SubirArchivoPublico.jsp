<%-- 
    Document   : SubirArchivoPublico
    Created on : 17/04/2019, 05:24:37 PM
    Author     : PC02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        .body{
            background: rgb(233, 232, 232);
            text-align: center;
            padding: 15px;
        }

        .body label{
            color: rgba(0, 0, 0, 0.603);
        }

        .body button.BTN{
            font-size: 5mm;
            border: none;
            border-radius: 8px;
            background: rgb(0, 183, 255);
            font-family: 'Comfortaa', cursive;
            color:white;
            height: 5%;
        }

        .body button.BTN:hover{
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }

        .searchDoc{
            margin: 30px;
        }

        .information input{
            margin-bottom: 15px;
            text-align: center;
            color: rgba(0, 0, 0, 0.603);
            background-color: rgb(233, 232, 232);
            border:none;
            font-family: 'Comfortaa', cursive;
        }

    </style>

    <body>

        <div class="container">
            <div class="header">
                <h1>CopyQuick</h1>
            </div>

            <div class="body">
                <h4>Selecciona un archivo que quieras publicar.</h4>

                <div class="searchDoc">
                    <input type="file" style="background: rgb(0, 183, 255);">
                </div>

                <div class=information>
                    <input id="fileName" placeholder="Nombre del Archivo">
                    <br>
                    <input id="semestre" placeholder="Semestre">
                    <br>
                    <input id="escuela" placeholder="Escuela">
                    <br>
                    <input id="numPaginas" placeholder="Numero de paginas">
                    <br>
                    <input id="nomUsuario" placeholder="Nombre del usuario">
                    <br>
                    <button onclick="collectFILES()" class="BTN" style="height: 7.5%; width: 30%">Subir</button>
                </div>
            </div>
        </div>

    </body>

</html>
