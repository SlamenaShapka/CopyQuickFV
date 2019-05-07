<%-- 
    Document   : LecturaQR
    Created on : 25/04/2019, 11:02:10 AM
    Author     : PC02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>CopyQuick</title>
    <script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js" ></script>	
  </head>
  <style>
    @import url('https://fonts.googleapis.com/css?family=Comfortaa');

    body {
        background: #456;
        font-family: 'Comfortaa', cursive;
    }

    .container {
        width: 700px;
        margin: 16px auto;
        font-size: 16px;
        background: rgb(34, 136, 221);
    }
    .QR-triangle {
  width: 0;
  margin-right: auto;
  margin-left: auto;
  border: 12px solid transparent;
  border-bottom-color: #28d;
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

    #archivo {
        width: 500;
        height: 350;
        background: black;
        margin-left: auto;
        margin-right: auto;
        display: block;
    }

    .footer button {
        font-size: 7.5mm;
        background: #28d;
        border-color: transparent;
        color: #fff;
        cursor: pointer;
        box-sizing: border-box;
        width: 35%;
        display: inline-block;
        font-family: 'Comfortaa', cursive;
        margin-left: 22.5mm;
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
                  <h2>Acerca el codigo QR para iniciar a escanear</h2>
    <video id="preview"></video>
    
   
    <script>
        let scanner = new Instascan.Scanner(
            {
                video: document.getElementById('preview')
        
            }
        );
        scanner.addListener('scan', function(content) {
            alert('Ve por tu fotocopia ' + content + datos);
            window.open(content, "_blank");
        });
        Instascan.Camera.getCameras().then(cameras => 
        {
            if(cameras.length > 0){
                scanner.start(cameras[0]);
            } else {
                console.error("No hay cámara en el dispositivo!");
            }
        });
    </script>
    
     <script>
        var id; 
        var nombre;
        
        var datos = content.toString().split("-");
        for (var i = 0; i < datos.length; i++) {
           datos[i]= id;
           datos[i+1] = nombre;
    
}
      
            
   
        
    </script>
    
    </div>
    </div>
    </div>

 </body>
</html>
