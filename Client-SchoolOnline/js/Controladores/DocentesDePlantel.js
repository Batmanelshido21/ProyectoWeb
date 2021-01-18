var docentes = [];

window.onload = function () {
  ObtenerDocentes();
}


function ObtenerDocentes() {

  var clave = sessionStorage.getItem('clavePlantel');

  fetch('http://localhost:8084/SchoolOnline/webresources/plantel/getDocete/' + clave, {
    method: 'GET',
  })
    .then(response => response.json())
    .then(data => {

      docentes = data;

      var cuerpo = document.getElementById('cuerpo');

      for (var i = 0; i < data.length; i++) {
        var tr = document.createElement('tr');

        var button = document.createElement("input");
        button.type = 'button';
        button.id = data[i].idDocente;
        button.value = data[i].nombre;
        button.style.border = "none";
        button.style.backgroundColor = "transparent";

        var celda = document.createElement('td')
        celda.appendChild(button);

        tr.appendChild(celda);
        cuerpo.appendChild(tr);
      }
    })
}

$(function () {
  $(document).on('click', 'input[type="button"]', function (event) {
    let id = this.id;

    var docente = docentes.find( a => a.idDocente == id);
    
    sessionStorage.setItem('idDocente', docente.idDocente);
    sessionStorage.setItem('nombreDocente', docente.nombre);
    sessionStorage.setItem('apPatDocente', docente.apellidoPaterno);
    sessionStorage.setItem('apMatDocente', docente.apellidoMaterno);
    sessionStorage.setItem('telefono', docente.telefono);
    sessionStorage.setItem('GradoAcademico', docente.gradoAcademico);

    window.location.href = '../html/Representante_ActualizarDocente.html';

  });
});