var Cuenta_nombreUsuario;
var idGrupo;
var Foro_idForo;

window.onload = function(){
  Cuenta_nombreUsuario = sessionStorage.getItem('nombreUsuario');
  idGrupo = sessionStorage.getItem('idGrupo');
  ObtenerIDForo();
}

function enviarMensaje(){
    var mensaje=document.getElementById("mensaje").value;

    var details ={
        mensaje:mensaje,
        Foro_idForo:Foro_idForo,
        Cuenta_nombreUsuario:Cuenta_nombreUsuario
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    
    fetch('http://localhost:8084/SchoolOnline/webresources/foro/enviarMensaje', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
      document.getElementById("mensaje").value = "";
    })
}

function obtenerMensajes(){
    
  console.log(Foro_idForo);

    fetch('http://localhost:8084/SchoolOnline/webresources/foro/mensajeForo/' + Foro_idForo, {
        method: 'GET',
      })
        .then(response => response.json())
        .then(data => {
  
          console.log(data);
  
          var cuerpo = document.getElementById('cuerpo');
          cuerpo.innerHTML = '';
            
          for (var i = 0; i < data.length; i++) {
                  var tr = document.createElement('tr');
  
                  var mensaje = document.createElement("input");
                  mensaje.type = 'text';
                  mensaje.id = data[i].mensaje;
                  mensaje.value = data[i].cuenta_nombreUsuario+": "+ data[i].mensaje;
                  mensaje.style.border = "none";
                  mensaje.style.backgroundColor = "transparent";
                  mensaje.readOnly=true;
                  mensaje.style.width = '2000px'
                  
                  var celda = document.createElement('td')
                  celda.appendChild(mensaje);
  
                  tr.appendChild(celda);
                  cuerpo.appendChild(tr);
            }
        })
}

function ObtenerIDForo(){

  fetch('http://localhost:8084/SchoolOnline/webresources/foro/idForo/' + idGrupo, {
        method: 'GET',
      })
        .then(response => response.json())
        .then(data => {
          Foro_idForo = data.foro_idForo;
          console.log(Foro_idForo);
        })
}