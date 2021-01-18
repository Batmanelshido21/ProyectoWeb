window.onload = function () {
  ObtenerGrupos();
}

function ObtenerGrupos() {
  var idAlumno = sessionStorage.getItem('idAlumno');

  fetch('http://localhost:8080/SchoolOnline/webresources/grupo/getGruposAlumno/' + idAlumno, {
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

$(function() {
  $(document).on('click', 'input[type="button"]', function(event) {
     let id = this.id;
     sessionStorage.setItem('idGrupoAlumno', id);
     window.location.href = '../html/Alumno_Actividades.html';
   });
 });