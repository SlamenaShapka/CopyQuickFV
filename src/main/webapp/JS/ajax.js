
var token;
var uri = "http://localhost:8080/copyquickmaven/";
////Registro
//----------Ingresar---------------------------------------------------------------------------------------------
function ingresar() {
    var nomUsuario = $('#nomUsuario').val();
    var contrasena = $('#contrasena').val();
    info = {
        "nomUsuario": nomUsuario,
        "contrasena": contrasena
    };
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "http://localhost:8080/CopyQuick/ServletLogin",
        type: "POST",
        data: dataToSend,
        success: function (rta) {
            var result = rta.toString();
            if (result === "UsuarioNoRegistrado") {
                console.log("Usuario no registrado.");
                $("#mal").remove();
                $(".result").append('<h5 id="mal">El usuario no está registrado.</h5>');
            } else {
                $("#mal").remove();
                $(".result").append('<h5 id="mal">La contraseña es incorrecta.</h5>');
                console.log("Contrasena incorrecta.");
            }
        }
    });
}
//----------Registrar--------------------------------------------------------------------------------------------
function tipoUsuario() {
    var name = $('#tipoUsuario').val();
    if (name === "estudiante") {
        $("#tipoProfesor").remove();
        $(".1").remove();
        $(".information").append('<br class="1"><br class="1"><input id="carrera" placeholder="Carrera"><br class="1"><br class="1"><input id="semestre" placeholder="Semestre">');
    } else {
        $("#carrera").remove();
        $("#semestre").remove();
        $(".1").remove();
        $(".information").append('<br class="1"><br class="1"><select id="tipoProfesor"><option>Escoge una opción</option><option value="planta">Planta</option><option value="catedra">Catedra</option></select>');
    }
}

function registrar() {
    var name = $('#tipoUsuario').val();
    var nomUsuario = $('#nomUsuario').val();
    var contrasena = $('#contrasena').val();
    var usuario;
    if (name === "estudiante") {
        var carrera = $('#carrera').val();
        var semestre = $('#semestre').val();
        usuario = "estudiante";
        info = {
            "nomUsuario": nomUsuario,
            "contrasena": contrasena,
            "carrera": carrera,
            "semestre": semestre,
            "usuario": usuario
        };
    } else {
        var tipoProfesor = $('#tipoProfesor').val();
        usuario = "profesor";
        info = {
            "nomUsuario": nomUsuario,
            "contrasena": contrasena,
            "tipoProfesor": tipoProfesor,
            "usuario": usuario
        };
    }
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "http://localhost:8080/CopyQuick/ServletRegistro",
        type: "POST",
        data: dataToSend,
        success: function (rta) {
            var result = rta.toString();
            if (result === "UsuarioRegistrado") {
                console.log("UsuarioRegistrado");
                console.log(result);
                $("#bien").remove();
                $("#mal").remove();
                $(".result").append('<h5 id="bien">El usuario ha sido registrado.</h5>');
                nomUsuario = $('#nomUsuario').val("");
                contrasena = $('#contrasena').val("");
                if (name == "estudiante") {
                    carrera = $('#carrera').val("");
                    semestre = $('#semestre').val("");
                } else {
                    var tipoProfesor = $('#tipoProfesor').val("Tipo profesor");
                }
            } else {
                console.log("UsuarioExistente");
                console.log(result);
                $("#bien").remove();
                $("#mal").remove();
                $(".result").append('<h5 id="mal">El nombre de usuario ya existe.</h5>');
            }
        }
    });

}

////Vista estudiante
//----------Ver saldo--------------------------------------------------------------------------------------------
function verSaldo() {
    $.ajax({
        url: "ServletEstudiante",
        type: "GET",
        headers: {"token": token},
        data: {"idPersona": "34"},
        success: function (rta) {
            console.log(rta);
        }
    });
}

////Vista completa de archivos
//----------Archivo escogido-------------------------------------------------------------------------------------
function archivoEscogido(idFile) {
    var id = idFile;
    info = {
        "idArchivo": id,
    };
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "http://localhost:8080/CopyQuick/ServletArchivos",
        type: "POST",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: info,
        success: function () {
            console.log(dataToSend);
        }
    });
}
//----------Ver archivos----------------------------------------------------------------------------------------
function mostrarArchivos() {
    $.ajax({
        url: "http://localhost:8080/CopyQuick/ServletArchivos",
        type: "GET",
        success: function (rta) {
            var archivos = rta.toString().split("-");
            for (var i = 0; i < archivos.length; i++) {
                var detalle = archivos[i].split(",");
                $(".listArchivos").append('<tr>\n\
                                                <td><button class="idArchivoo" onclick="archivoEscogido(' + detalle[0] + ')">' + detalle[0] + '</button></td>\n\
                                                <td>' + detalle[1] + '</td>\n\
                                                <td>' + detalle[2] + '</td>\n\
                                                <td>' + detalle[3] + '</td>\n\
                                           </tr>');
            }
        }
    });
}

//----------Agregar saldo---------------------------------------------------------------------------------------
function agrearSaldo() {
    var correo = $('#correo').val();
    var usuario = $('#nomusuario').val();
    var saldo = $('#saldo').val();
    info = {
        "correo": correo,
        "usuario": usuario,
        "saldo": saldo
    };
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "http://localhost:8080/CopyQuickV2/ServletSaldo",
        type: "POST",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: dataToSend,
        beforeSend: function () {
            console.log(dataToSend);
        }
    });
}
//----------Subir Archivo---------------------------------------------------------------------------------------
function collectFILES() {
    var files = $('input:file');
    var myFiles = [];
    for (var itF = 0; itF < files.length; itF++) {

        var file_data = $(files[itF]).prop('files')[0];
        if (file_data !== undefined) {
            filename = saveFile(file_data);
            console.log(filename);
            if (filename !== "error") {
                //Hacer lo necesario con el nombre del archivo.
            }
        }
    }

    return myFiles;
}

function saveFile(file_data) {
    var form_data = new FormData();
    var nombre = $("#fileName").val();
    var semestre = $("#semestre").val();
    var escuela = $("#escuela").val();
    var numPaginas = $("#numPaginas").val();
    var nomUsuario = $("#nomUsuario").val();
    form_data.append('file', file_data);
    filename = "";
    info = {
        "nombre": nombre,
        "semestre": semestre,
        "escuela": escuela,
        "numPaginas": numPaginas,
        "numUsuario": nomUsuario
    };
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "http://localhost:8080/CopyQuick/SubirArchivoArchivo", //La url del servlet.
        type: "POST",
        data: form_data,
        processData: false,
        contentType: false,
        cache: false,
        async: false,
        dataType: 'json',
        complete: function (ans) {
            if (ans.statusText === "OK") {
                filename = ans.responseJSON;
            } else {
                filename = "error";
            }
        }
    });
    $.ajax({
        url: "http://localhost:8080/CopyQuick/SubirArchivoDatos",
        type: "POST",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: dataToSend,
        complete: function (rta) {
            var result = rta.toString();
            if(result === "ArchivoSubido"){
                console.log("ArchivoSubido");
                console.log(result);
            }else if(result === "ErrorAlSubir"){
                console.log("ErrorAlSubir");
                console.log(result);
            }else{//Usuario Invalido
                console.log("UsuarioInvalido");
                console.log(result);
            }
        }
    });
    return filename;
}   