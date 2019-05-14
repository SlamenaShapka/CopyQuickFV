<%-- 
    Document   : AgregarSaldo
    Created on : 14-may-2019, 1:29:58
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="jquery-3.3.1.min.js"></script>
    <script src="ajax.js"></script>
    <title>JSP Page</title>
    <style>
            @import url('https://fonts.googleapis.com/css?family=Comfortaa');
			

            body {
                background: #456;
                font-family: 'Comfortaa', cursive;
            }

            .administrador {
                width: 400px;
                margin: 16px auto;
                font-size: 16px;
            }
            .button {
                background-color: #28d;
                border: none;
                color: #fff;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }

            .administrador-header,
            .administrador p {
                margin-top: 0;
                margin-bottom: 0;
            }


            .administrador-triangle {
                width: 0;
                margin-right: auto;
                margin-left: auto;
                border: 12px solid transparent;
                border-bottom-color: #28d;
            }


            .administrador-header {
                background: #28d;
                padding: 30px;
                font-size: 1.4em;
                font-weight: normal;
                text-align: left;
                text-transform: uppercase;
                color: #fff;
            }

            .administrador-container {
                background: #ebebeb;
                padding: 38px;

            }

            .administrador p {
                padding: 12px;
            }

            .administrador input {
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

            .administrador input {
                box-sizing: border-box;
                border-box:center;
                display: block;
                width: 100%;
                border-width: 3px;
                border-style: solid;
                padding: 16px;
                outline: 0;
                font-family: inherit;
                font-size: 0.95em;
            }

            .administrador input[type="text"],
            .administrador input[type="Subir archivos"] {
                background: #fff;
                border-color: #bbb;
                color: #555;
            }




            .administrador input[type="submit"] {

                background: #28d;
                border-color: transparent;
                color: #fff;
                cursor: pointer;
                box-sizing: border-box;
                width: 50%;
                text-align: center;

            }

        </style>
  </head>
  <body>
    <div class="administrador">
      <div class="administrador-triangle"></div>
      <h2 class="administrador-header">CopyQuick</h2>
      <form action="/saldo" class="administrador-container" method="post">
        <p align="center"> Ingrese los datos que se le piden a continuación</p>
        <input action="" id="nomUsuario" placeholder="Nombre de Usuario"> &nbsp;
        <input action="" id="saldo" placeholder="Saldo"> &nbsp;
        <center> <a onclick="agrearSaldo()" class="button">Agregar Saldo</a> </center>
      </form>
      <div> </div>
    </div>
    <script>
  function agregarsaldo(){
  
  }
  </script>
  </body>
</html>

