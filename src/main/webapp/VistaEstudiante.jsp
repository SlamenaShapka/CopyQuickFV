<%-- 
    Document   : VistaEstudiante
    Created on : 14/03/2019, 02:34:05 AM
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
        .headerStudent h1 {
            text-align: left;
            padding: 15px;
            margin-left: 15px;
            margin-bottom: 0%;
            color: rgb(255, 255, 255);
        }
        .headerStudent #icon img {
            width: 25%;
            margin-right: 0%;
            padding: 0%;
        }
        .bodyStudent {
            background: rgb(233, 232, 232);
            padding: 12px;
            font-size: 7.5mm;
        }
        .containerBody {
            margin: 15px;
        }
        .opciones {
            margin-top: 30px;
            margin-bottom: 0px;
        }
        .opcion {
            padding: 40px;
            text-align: center;
        }
        .opcion img {
            width: 5%;
        }
        .opcion button.opcionBTN {
            font-size: 7.5mm;
            border: transparent;
            background: rgb(233, 232, 232);
            font-family: 'Comfortaa', cursive;
        }
        .opcion button.opcionBTN:hover {
            font-size: 8mm;
        }
    </style>

    <body>

        <div class="container">
            <div class="headerStudent">
                <h1>CopyQuick</h1>
            </div>

            <div class="bodyStudent">
                <div class="containerBody">
                    <label>Saldo: </label><label id="saldo"></label>

                    <div class="opciones">

                        <div class="opcion">
                            <button class="opcionBTN" onclick="location.href = 'MostrarArchivos.jsp'">
                                <img src="Imagenes/arrow-icon.png" />
                                Ver lista de archivos.
                            </button>
                        </div>

                        <div class="opcion">
                            <button class="opcionBTN" onclick="location.href = '#'">
                                <img src="Imagenes/arrow-icon.png" />
                                Ver mis archivos.
                            </button>
                        </div>

                    </div>

                </div>
            </div>
        </div>
        <script>
            var token;
            $(document).ready(verSaldo());
        </script>
    </body>

</html>
