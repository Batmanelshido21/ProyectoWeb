var Cuenta_nombreUsuario="alumnopostmannombreusuario";
var Foro_idForo =1;

window.onload = function(){
    obtenerMensajes();
}
var intervalo = setInterval(obtenerMensajes,5000);

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
    
    fetch('http://localhost:8080/SchoolOnline/webresources/foro/enviarMensaje', {
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

    mensaje.resultados.innerHTML = '';
}

function obtenerMensajes(){
    var mensaje = document.getElementById("mensaje").value;

    fetch('http://localhost:8080/SchoolOnline/webresources/foro/mensajeForo/1', {
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
                  mensaje.value =data[i].cuenta_nombreUsuario+": "+data[i].mensaje;
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