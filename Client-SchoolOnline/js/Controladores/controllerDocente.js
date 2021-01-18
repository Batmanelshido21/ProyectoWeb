var clavePlantel; 

window.onload = function () {

  clavePlantel = sessionStorage.getItem('clavePlantel');
  
  console.log("cla: " + clavePlantel);
}

function registrarDocente(){

    var nombre = document.getElementById("nombre").value;
    var apellidoPaterno = document.getElementById("apellidoPaterno").value;
    var apellidoMaterno = document.getElementById("apellidoMaterno").value;
    var gradoAcademico = document.getElementById("gradoAcademico").value;
    var correo = document.getElementById("correo").value;
    var contrasena = document.getElementById("contrasena").value;
    var telefono = document.getElementById("telefono").value;
    var Genero_idGenero = document.getElementById("genero").value;
    var nombreUsuario = nombre.substring(0,3)+apellidoPaterno.substring(0,3)+apellidoMaterno.substring(0,3);
    var PlantelEducativo_clave = clavePlantel;
    
    var details ={
        correo:correo,
        contrasena:contrasena,
        nombreUsuario:nombreUsuario,
        nombre:nombre,
        apellidoPaterno:apellidoPaterno,
        apellidoMaterno:apellidoMaterno,
        gradoAcademico:gradoAcademico,
        telefono:telefono,
        Genero_idGenero:Genero_idGenero,
        PlantelEducativo_clave:PlantelEducativo_clave
    };

    var formBody = [];
        for (var property in details) {
          var encodedKey = encodeURIComponent(property);
          var encodedValue = encodeURIComponent(details[property]);
          formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");
        
        fetch('http://localhost:8080/SchoolOnline/webresources/cuenta/RegistrarDocente', {
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
}

function Regresar(){
  window.location.href = '../html/RepresentantePlantel_Inicio.html'
}