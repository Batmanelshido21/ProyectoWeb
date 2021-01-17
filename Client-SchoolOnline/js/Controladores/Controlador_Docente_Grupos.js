var idGrupo;

window.onload = function () {
  idGrupo = sessionStorage.getItem('idGrupo');

  console.log(idGrupo);
}

function registrarAlumno(){

    var nombre = document.getElementById("nombre").value;
    var apellidoPaterno = document.getElementById("apellidoPaterno").value;
    var apellidoMaterno = document.getElementById("apellidoMaterno").value;
    var correo = document.getElementById("correo").value;
    var contrasena = document.getElementById("contrasena").value;
    var Genero_idGenero = document.getElementById("genero").value;
    var nombreUsuario = nombre.substring(0,3)+apellidoPaterno.substring(0,3)+apellidoMaterno.substring(0,3);
    var idPlantel = sessionStorage.getItem('idPlantel');

    var details ={
        correo:correo,
        contrasena:contrasena,
        nombreUsuario:nombreUsuario,
        nombre:nombre,
        apellidoPaterno:apellidoPaterno,
        apellidoMaterno:apellidoMaterno,
        Genero_idGenero:Genero_idGenero,
        PlantelEducativo_clave:idPlantel,
        Grupo_idGrupo:idGrupo
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    
    fetch('http://localhost:8084/SchoolOnline/webresources/cuenta/RegistrarAlumno', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
      var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
      myModal.show(); 
    })
}

function limpiarCampos(){
  document.getElementById("nombre").value = "";
  document.getElementById("apellidoPaterno").value = "";
  document.getElementById("apellidoMaterno").value = "";
  document.getElementById("correo").value = "";
  document.getElementById("contrasena").value = "";
}

function cancelar(){
  window.location.href = '../html/Docente_Inicio.html'
}
