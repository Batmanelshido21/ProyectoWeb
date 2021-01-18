var nombreU;
var idAlumno;

window.onload = function () {

    var nombreU = sessionStorage.getItem('nombreAlumno');
    var idAlumno = sessionStorage.getItem('idAlumno');
    
    document.getElementById('ln').innerHTML = nombreU;
}

function login(){
    window.location.href = '../html/index.html';
}

function cambiarContraseña(){
    window.location.href = '../html/Cambiar_Contraseña.html';
}