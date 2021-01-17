var nombreU;
var idAlumno;

window.onload = function () {

    var nombreU = sessionStorage.getItem('nombreAlumno');
    var idAlumno = sessionStorage.getItem('idAlumno');
    
    document.getElementById('ln').innerHTML = nombreU;
}
