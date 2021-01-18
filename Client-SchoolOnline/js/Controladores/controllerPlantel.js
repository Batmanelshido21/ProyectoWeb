function ObtenerDatos() {

  var clave = document.getElementById("clave").value;
  var sector = document.getElementById("sector").value;
  var nivelEscolar = document.getElementById("nivelEscolar").value;
  var zona = document.getElementById("zona").value;
  var direccion = document.getElementById("direccion").value;
  var correo = document.getElementById("correo").value;
  var contrasena = document.getElementById("contrasena").value;

  registrarPlantel(clave, sector, nivelEscolar, zona, direccion, correo, contrasena);

  return false;
}


function registrarPlantel(clave, sector, nivelEscolar, zona, direccion, correo, contrasena) {

  console.log(clave + sector + nivelEscolar + zona + direccion + correo + contrasena);

  var nombreUsuario = clave.substring(0, 3) + sector.substring(0, 3);

  var details = {
    clave: clave,
    sector: sector,
    nivelEscolar: nivelEscolar,
    zona: zona,
    direccion: direccion,
    correo: correo,
    contrasena: contrasena,
    nombreUsuario: nombreUsuario
  };


  var formBody = [];

  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }

  formBody = formBody.join("&");

  fetch('http://localhost:8084/SchoolOnline/webresources/plantel/RegistrarPlantel', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
}

function DesplegarLogin() {
  window.location.href = '../index.html';
}