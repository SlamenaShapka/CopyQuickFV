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

        .login {
            width: 400px;
            margin: 16px auto;
            font-size: 16px;
        }


        .login-header,
        .login p {
            margin-top: 0;
            margin-bottom: 0;
        }


        .login-triangle {
            width: 0;
            margin-right: auto;
            margin-left: auto;
            border: 12px solid transparent;
            border-bottom-color: #28d;
        }

        .login-header {
            background: #28d;
            padding: 30px;
            font-size: 1.4em;
            font-weight: normal;
            text-align: center;
            text-transform: uppercase;
            color: #fff;
        }

        .login-container {
            background: #ebebeb;
            padding: 12px;
        }

        .login p {
            padding: 12px;
        }

        .login input {
            box-sizing: border-box;
            display: block;
            width: 100%;
            border-width: 3px;
            border-style: solid;
            padding: 16px;
            outline: 0;
            font-family: inherit;
            font-size: 0.95em;
        }

        .login input {
            box-sizing: border-box;
            display: block;
            width: 100%;
            border-width: 3px;
            border-style: solid;
            padding: 16px;
            outline: 0;
            font-family: inherit;
            font-size: 0.95em;
        }  
        .login input[type="text"],
        .login input[type="password"] {
            background: #fff;
            border-color: #bbb;
            color: #555;
        }


        .login input[type="text"]:focus,
        .login input[type="password"]:focus {
            border-color: #888;
        }

        .login input[type="submit"] {
            background: #28d;
            border-color: transparent;
            color: #fff;
            cursor: pointer;
            box-sizing: border-box;
            width: 50%;
        }

        .login input[type="submit"]:hover {
            background: #17c;
        }

        .login input[type="submit"]:focus {

            border-color: #05a;
        }
        #item_txt{
            width: 20%;
        }
        #generarCodigo{
            width: 20%;
            background-color: #5AA1E3;
            color: #fff;
        }
        #descargarCodigo{
            width: 10%;
            background-color: #3CB371;
            color: #fff;
            display: none;
            text-align: center;
            border: #eee solid 2px;
            text-decoration: none;
        }
        #codigoQR{
            width: 256px;
            height: 256px;
            margin-top: 25px;
            border: 2px solid #eee;
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
    </style>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <title>Código QR</title>
            <link rel='stylesheet' href='style.css' type='text/css'>
        </head>
        <body>

            <div class="login">
                <div class="login-container">
                    <text id="item_txt" type="text" placeholder="Ingresa algún texto" value="">

                    <button id="generarqr" onclick="generateQR()">Generar</button> 
                    <div id="codigoQR"></div> 
                    <h1>Dirigete a la fotocopiadora con este código y recibe tu impresion</h1>

                </div>
            </div>
        </body>

        <script src="JS/jquery.min.js"></script>
        <script src="JS/qrcode.js"></script>
        <script>
            var sPaginaURL = window.location.search.substring(1);
            var nameFile = sPaginaURL.substring(sPaginaURL.indexOf("=") + 1, sPaginaURL.length);
            var miCodigoQR = new QRCode("codigoQR");
            function generateQR() {
                var cadena = nameFile;
                if (cadena == "") {
                    alert("Ingresa un texto");
                    $("#item_txt").focus();
                } else {
                    miCodigoQR.makeCode(cadena);
                }
            }


        </script>
    </html>



