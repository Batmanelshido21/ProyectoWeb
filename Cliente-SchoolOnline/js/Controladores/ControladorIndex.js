//Como enviar parametros entre ventanas
//window.location.href = 'html/Actividad.html?num=0&postal=28400';

function Login() {
  var rolAlumno = document.getElementById('alumno');
  var rolDocente = document.getElementById('docente');
  var correo = document.getElementById('correo').value;
  var contrasena = document.getElementById('contrasena').value;

  if (rolAlumno.checked == true)
    LoginAlumno(correo, contrasena);
  else if (rolDocente.checked == true)
    LoginDocente(correo, contrasena);
  else
    LoginRepresentante(correo, contrasena);

  return false;
}

function FormarCuerpoDePeticion(correo, contrasena){

  var details = {
    correo: correo,
    contrasena: contrasena
  };

  var formBody = [];

  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }

  formBody = formBody.join("&");

  return formBody;
}

function LoginAlumno(correo, contrasena) {

  var cuerpo = FormarCuerpoDePeticion(correo, contrasena);

  fetch('http://localhost:8084/SchoolOnline/webresources/cuenta/LoginAlumno/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: cuerpo
  })
    .then(response => response.json())
    .then(data => {
      if (data.idAlumno != 0) {
        var nombreUsuario = data.nombre;
        window.location.href = 'html/Alumno_Inicio.html?nombre=' + nombreUsuario;
      } else {
        MostrarVentanaModal();
      }
    })
}

function LoginDocente(correo, contrasena) {

  var cuerpo = FormarCuerpoDePeticion(correo, contrasena);

  fetch('http://localhost:8084/SchoolOnline/webresources/cuenta/LoginDocente/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: cuerpo
  })
    .then(response => response.json())
    .then(data => {
      if (data.idDocente != 0) {
        var nombreUsuario = data.nombre;
        window.location.href = 'html/Docente_Inicio.html?nombre=' + nombreUsuario;
      } else {
        MostrarVentanaModal();
      }
    })
}

function LoginRepresentante(correo, contrasena) {

  var cuerpo = FormarCuerpoDePeticion(correo, contrasena);

  fetch('http://localhost:8084/SchoolOnline/webresources/plantel/LoginPlantel/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: cuerpo
  })
    .then(response => response.json())
    .then(data => {
      if (data.clave != "0") {
        window.location.href = 'html/RepresentantePlantel_Inicio.html';
      } else {
        MostrarVentanaModal();
      }
    })
}

function MostrarVentanaModal() {
  var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
  myModal.show();
}

function DesplegarRegistroDePlantel(){
  window.location.href = 'html/RegistroPlantelEducativo.html';
}