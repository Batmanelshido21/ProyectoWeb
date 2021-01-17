var nombreDocente;
var idDocente;

window.onload = function () {
    nombreDocente = sessionStorage.getItem('nombreDocente');
    idDocente = sessionStorage.getItem('idDocente');

    document.getElementById('ln').innerHTML = nombreDocente;
  }
  

function DesplegarGrupos(){
    window.location.href = '../html/Docente_Grupos.html';
}

function RegistroDeGrupo(){
    window.location.href = '../html/Registro_Grupo.html';
}