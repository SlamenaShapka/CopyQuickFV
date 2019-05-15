////////Cookies
//----------Crear Cookie
function setCookie(cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = "NomUsuario=" + cvalue + ";" + expires + ";path=/";
    console.log(getCookie("NomUsuario"));
}

//----------Obtener Cookie
function getCookie(cname) {
    var name = "NomUsuario=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

////////Registro
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
        url: "CopyQuickFV/ServletLogin",
        type: "POST",
        data: dataToSend,
        success: function (rta) {
            var result = rta.toString();
            if (result.startsWith("UsuarioNoRegistrado")) {
                $("#mal").remove();
                $(".result").append('<h5 id="mal">El usuario no está registrado.</h5>');
            } else if (result.startsWith("ContrasenaIncorrecta")) {
                $("#mal").remove();
                $(".result").append('<h5 id="mal">La contraseña es incorrecta.</h5>');
            } else {
                var usuario = JSON.parse(result);
                setCookie(nomUsuario, 1);
                if (usuario.tipo === "Estudiante") {
                    window.location.replace("VistaEstudiante.jsp");
                } else {
                    window.location.replace("VistaProfesor.jsp");
                }
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
        url: "CopyQuickFV/ServletRegistro",
        type: "POST",
        data: dataToSend,
        success: function (rta) {
            var result = rta.toString();
            if (result.startsWith("UsuarioRegistrado")) {
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
    var nomUsuario = getCookie();
    console.log(nomUsuario);
    info = {
        "nomUsuario": nomUsuario
    };
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "CopyQuickFV/ServletSaldo",
        type: "POST",
        data: dataToSend,
        success: function (rta) {
            $("#saldo").append('<label class="saldo">' + rta + '</label>');
        }
    });
}

////Vista completa de archivos
//----------Archivo escogido-------------------------------------------------------------------------------------
function archivoEscogido(idFile) {
    var id = idFile;
    info = {
        "idArchivo": id
    };
    dataToSend = JSON.stringify(info);
    $.ajax({
        url: "CopyQuickFV/ServletArchivoEscogido",
        type: "POST",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: dataToSend,
        success: function (rta) {
            console.log(rta);
            var result = rta.toString();
            console.log(result);
//            $('.archivo').append('<embed src="C:/Users/PC02/Desktop/ArchivosCopyQuick/'+rta.nombre+'#toolbar=0" width="450" height="500" id="archivo">');
//            $('.nombreArchivo').append('<label id="nameFile">'+rta.nombre+'</label>');
            window.location.href = "ArchivoEscogido.jsp?Archivo=" + rta.nombre;
        }
    });


}
//----------Ver archivos----------------------------------------------------------------------------------------
function mostrarArchivos() {
    $.ajax({
        url: "CopyQuickFV/ServletArchivos",
        type: "GET",
        success: function (rta) {
            var archivos = rta.toString().split("-");
            for (var i = 0; i < archivos.length; i++) {
                var detalle = archivos[i].split(",");
                $(".listArchivos").append('<tr>\n\
                                                <td><button class="idArchivoo" onclick="archivoEscogido(' + detalle[1] + ')">' + detalle[1] + '</button></td>\n\
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
        url: "CopyQuickV2/ServletSaldo",
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
        url: "CopyQuickFV/SubirArchivoArchivo", //La url del servlet.
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
        url: "CopyQuickFV/SubirArchivoDatos",
        type: "POST",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: dataToSend,
        complete: function (rta) {
            var result = rta.toString();
            if (result === "ArchivoSubido") {
                console.log("ArchivoSubido");
                console.log(result);
            } else if (result === "ErrorAlSubir") {
                console.log("ErrorAlSubir");
                console.log(result);
            } else {//Usuario Invalido
                console.log("UsuarioInvalido");
                console.log(result);
            }
        }
    });
    return filename;
}

function generarqr2(nameFile) {
    var name = nameFile;

}

function nameFile() {
    var sPaginaURL = window.location.search.substring(1);
    var nameFile = sPaginaURL.substring(sPaginaURL.indexOf("=") + 1, sPaginaURL.length);
    $('#nombreArchivo').append('<label class="name">' + nameFile + '</label>');
    $(".archivo").html('<embed src="C:/Users/PC02/Desktop/ArchivosCopyQuick/' + nameFile + '.pdf#toolbar=0" type="application/pdf" id="archivo">');
    return nameFile;
}




