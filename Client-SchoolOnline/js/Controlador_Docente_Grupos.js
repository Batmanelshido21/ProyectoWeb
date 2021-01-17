var idDocente;

window.onload = function(){
    MostrarParams();
    ObtenerGrupos(); 
}

function MostrarParams() {

    var paramstr = window.location.search.substr(1);
    var paramarr = paramstr.split("&");
    var params = {};

    for (var i = 0; i < paramarr.length; i++) {
        var tmparr = paramarr[i].split("=");
        params[tmparr[0]] = tmparr[1];
    }

    idDocente = params['idDocente'];
}

function ObtenerGrupos() {
  
    fetch('http://localhost:8084/SchoolOnline/webresources/grupo/getGrupoDocente/3', {
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
       sessionStorage.setItem('idGrupo', id);
       window.location.href = '../html/SolicitarActividad.html';
     });
   });