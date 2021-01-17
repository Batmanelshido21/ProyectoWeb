//Como enviar parametros entre ventanas
//window.location.href = 'html/Actividad.html?num=0&postal=28400';

function Login() {
  var correo = document.getElementById('correo').value;
  var contrasena = document.getElementById('contrasena').value;

  LoginAlumno(correo, contrasena); 

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

  fetch('http://localhost:8084/SchoolOnline/webresources/cuenta/Login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: cuerpo
  })
    .then(response => response.json())
    .then(data => {

      if (data.id != '') {
        if(data.rol == 'Plantel'){
          sessionStorage.setItem('clavePlantel', data.clave);
          window.location.href = '../html/RepresentantePlantel_Inicio.html'
        }else if (data.rol == 'Docente') {
          sessionStorage.setItem('nombreDocente', data.nombre);
          sessionStorage.setItem('idDocente', data.id);
          sessionStorage.setItem('idPlantel', data.clave);
          window.location.href = '../html/Docente_Inicio.html'
        } else {
         
          sessionStorage.setItem('nombreAlumno', data.nombre);
          sessionStorage.setItem('idAlumno', data.id);
          window.location.href = '../html/Alumno_Inicio.html'

        }
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