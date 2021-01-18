window.onload = function () {
    establecerDatos();
  }
  

function establecerDatos(){
    document.getElementById("nombre").value = sessionStorage.getItem('nombreDocente');
    document.getElementById("apellidoPaterno").value = sessionStorage.getItem('apPatDocente');
    document.getElementById("apellidoMaterno").value = sessionStorage.getItem('apMatDocente');
    document.getElementById("gradoAcademico").value = sessionStorage.getItem('GradoAcademico');
    document.getElementById("telefono").value = sessionStorage.getItem('telefono');
}

function ActualizarDatos(){

    var idDocente = sessionStorage.getItem('idDocente');
    var nombre = document.getElementById("nombre").value;
    var ap =  document.getElementById("apellidoPaterno").value;
    var am = document.getElementById("apellidoMaterno").value;
    var ga = document.getElementById("gradoAcademico").value;
    var tel = document.getElementById("telefono").value;

    var details = {
        idDocente: idDocente,
        nombre: nombre,
        apellidoPaterno: ap,
        apellidoMaterno: am,
        gradoAcademico: ga,
        telefono: tel
    };

    var formBody = [];
    for (var property in details) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(details[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    fetch('http://localhost:8084/SchoolOnline/webresources/cuenta/modificarDocente', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: formBody
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            if (data.error == true) {
                window.location.href = '../html/RepresentantePlantel_Inicio.html'
            } else {
                alert("Error al actualizar datos");
            }
        })
}

function Regresar(){
    window.location.href = '../html/RepresentantePlantel_Inicio.html'
}