var idDocente;

window.onload = function () {
  idDocente = sessionStorage.getItem('idDocente');

  console.log(idDocente);
}

function registrarGrupo() {
  var nombre = document.getElementById("nombre").value;
  var CicloEscolar_idCicloEscolar = 1;

  var details = {
    nombre: nombre,
    CicloEscolar_idCicloEscolar: CicloEscolar_idCicloEscolar,
    Docente_idDocente: idDocente
  };

  var formBody = [];
  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  fetch('http://localhost:8080/SchoolOnline/webresources/grupo/RegistrarGrupo', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  })
    .then(response => response.json())
    .then(data => {
      sessionStorage.setItem('idGrupo', data.idGrupo);
      console.log("IdGrupo: " +  data.idGrupo);
      var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
      myModal.show();
    })
}

function Regresar() {
  window.location.href = '../html/registroAlumno.html'
}