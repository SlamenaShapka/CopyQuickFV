..<%-- 
    Document   : ArchivoEscogido
    Created on : 17/04/2019, 04:47:55 PM
    Author     : PC02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

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
            margin-bottom: 0%;
            color: rgb(255, 255, 255);
        }

        .body {
            background: rgb(233, 232, 232);
            padding: 12px;
        }

        .containerBody {
            margin: 15px;
        }

        .containerBody h4 {
            text-align: center;
        }
        
        label.name {
            text-align: center;
        }

        #archivo {
            width: 500;
            height: 350;
            background: black;
            margin-left: auto;
            margin-right: auto;
            display: block;
        }

        button {
            display: block;
            font-size: 5mm;
            border: none;
            border-radius: 8px;
            background: rgb(0, 183, 255);
            font-family: 'Comfortaa', cursive;
            color:white;
            height: 5%;
            margin-left: auto;
            margin-right: auto;
        }

        .footer h3 {
            display: inline-block;
        }
    </style>

    <body>
        <div class="container">
            <div class="header">
                <h1>CopyQuick</h1>
            </div>

            <div class="body">
                <div class="containerBody">
                    <h4 id="nombreArchivo">Archivo Escogido = </h4>
                    <br>
                    <div class="archivo">
                    </div>
                    <br>
                    <br>
                    <div class="footer">
                    <button id="" class="btn" onclick="generarqr()">Generar código QR</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script>
        var name;
        $(document).ready(name = nameFile());
        function generarqr() {
            window.location.href = "QR.jsp?nameFile="+name;
        }
    </script>
</html>

