var nombreDocente;
var idDocente;

window.onload = function () {
    nombreDocente = sessionStorage.getItem('nombreDocente');
    idDocente = sessionStorage.getItem('idDocente');

    document.getElementById('ln').innerHTML = nombreDocente;
}


function DesplegarGrupos(boton) {

    switch (boton) {
        case 1:
            sessionStorage.setItem('opcionBoton', 1);
            ObtenerGrupos();
            break;
        case 2:
            sessionStorage.setItem('opcionBoton', 2);
            ObtenerGrupos();
            break;
        case 3:
            sessionStorage.setItem('opcionBoton', 3);
            ObtenerGrupos();
            break;
        case 4:
            sessionStorage.setItem('opcionBoton', 4);
            ObtenerGrupos();
        case 5:
            sessionStorage.setItem('opcionBoton', 5);
            ObtenerGrupos();
        case 6:
            sessionStorage.setItem('opcionBoton', 6);
            ObtenerGrupos();
            break;
        default:
            console.log('default');
    }
}

function ObtenerGrupos() {
    window.location.href = '../html/Docente_Grupos.html';
}

function RegistroDeGrupo() {
    window.location.href = '../html/Registro_Grupo.html';
}

function RegistrarBitacora(opcion) {
    window.location.href = '../html/RegistroBitacora.html';
}

function ModificarBitacora(opcion) {
    window.location.href = '../html/Docente_Bitacoras.html';
}

function login(){
    window.location.href = '../html/index.html';
}

function cambiarContraseña(){
    window.location.href = '../html/Cambiar_Contraseña.html';
}