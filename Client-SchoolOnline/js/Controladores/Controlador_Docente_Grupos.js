var idDocente;
var calificarActividad;

window.onload = function () {
  idDocente = sessionStorage.getItem('idDocente');
  calificarActividad = sessionStorage.getItem('calificarActividad');
  ObtenerGrupos();
}

function ObtenerGrupos() {

  fetch('http://localhost:8080/SchoolOnline/webresources/grupo/getGrupoDocente/' + idDocente, {
    method: 'GET',
  })
    .then(response => response.json())
    .then(data => {

      console.log(data);

      var cuerpo = document.getElementById('cuerpo');

      for (var i = 0; i < data.length; i++) {
        var tr = document.createElement('tr');

        var button = document.createElement("input");
        button.type = 'button';
        button.id = data[i].idGrupo;
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
    sessionStorage.setItem('idGrupo', id);

    var boton = sessionStorage.getItem('opcionBoton');

    console.log(boton);

    DesplegarVentana(boton);
  });
});

function DesplegarVentana(op){

  console.log(op);

  switch (op) {
    case '1':
      window.location.href = '../html/SolicitarActividad.html';
      break;
    case '2':
      //window.location.href = '../html/Alumno_Actividades.html';
      break;
    case '3':
      window.location.href = '../html/Actividades_Encargadas.html';
      break;
    case '4':
      window.location.href = '../html/Actividades_Encargadas.html';
      break;
    default:
      console.log('default');
  }
}