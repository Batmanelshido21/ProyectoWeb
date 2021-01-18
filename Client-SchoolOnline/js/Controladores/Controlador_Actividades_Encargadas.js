var actividades = [];

window.onload = function () {
    ObtenerActividades();
}

function ObtenerActividades() {

    var idGrupo = sessionStorage.getItem('idGrupo');

    fetch('http://localhost:8080/SchoolOnline/webresources/grupo/getActividadesAlumnoId/' + idGrupo, {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {

        actividades = data;
  
        var cuerpo = document.getElementById('cuerpo');
        
        for (var i = 0; i < data.length; i++) {
                var tr = document.createElement('tr');
  
                var button = document.createElement("input");
                button.type = 'button';
                button.id = data[i].idActividad;
                button.value = data[i].nombre;
                button.style.border = "none";
                button.style.backgroundColor = "transparent";
                
                var celda = document.createElement('td')
                celda.appendChild(button);
  
                var celda2 = document.createElement('td')
                celda2.innerHTML = data[i].fechaCreada;
  
  
                var celda3 = document.createElement('td')
                celda3.innerHTML = data[i].fechaEntrega;
  
                tr.appendChild(celda);
                tr.appendChild(celda2);
                tr.appendChild(celda3);
                cuerpo.appendChild(tr);
          }
      })


  }

  $(function() {
    $(document).on('click', 'input[type="button"]', function(event) {
       let id = this.id;
       var actividad = actividades.find( a => a.idActividad == id);
       
       sessionStorage.setItem('idAxtividadEncargada', id);
       sessionStorage.setItem('nombreActividad', actividad.nombre);
       sessionStorage.setItem('fechaCreada', actividad.fechaCreada);
       sessionStorage.setItem('fechaEntrega', actividad.fechaEntrega);
       sessionStorage.setItem('descripcion', actividad.descripcion);

       var boton = sessionStorage.getItem('opcionBoton');

       if(boton == '3'){
        window.location.href = '../html/Docente_ModificarActividad.html';
       }else{
        window.location.href = '../html/Docente_ActividadesEntregadas.html';
       }
     });
   });