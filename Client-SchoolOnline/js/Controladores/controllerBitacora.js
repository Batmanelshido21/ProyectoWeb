var archivoOriginal;
var archivoNuevo = "";
var id;

window.onload = function () {
  id = sessionStorage.getItem('idBitacora');
  archivo = sessionStorage.getItem('farchivoBitacora');

  if (id != 0) {
    document.getElementById("fecha").value = sessionStorage.getItem('fechaBitacora');
  }
}

function Aceptar() {
  if (id != 0) {
    if (archivoNuevo != "") {
      ModificarBitacora(archivoNuevo);
    } else {
      ModificarBitacora(archivoOriginal);
    }
  } else {
    if (archivoNuevo != "") {
      registrarBitacora();
    } else {
      alert("Debe seleccionar un archivo para registrar su bitácora");
    }
  }
}

function registrarBitacora() {
  var fecha = document.getElementById("fecha").value;
  var Docente_idDocente = sessionStorage.getItem('idDocente');

  var details = {
    Docente_idDocente: Docente_idDocente,
    fecha: fecha,
    archivo: archivo
  };

  var formBody = [];
  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  fetch('http://localhost:8084/SchoolOnline/webresources/bitacora/registrarBitacora', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  })
    .then(response => response.json())
    .then(data => {
      if(data == true){
        window.location.href = '../html/Docente_Inicio.html'
      }else{
        alert("Error al registrar bitacoras");
      }
    })
}

function ModificarBitacora(archivo) {
  var fecha = document.getElementById("fecha").value;

  var details = {
    idBitacora: id,
    fecha: fecha,
    archivo: archivo
  };

  var formBody = [];
  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  fetch('http://localhost:8084/SchoolOnline/webresources/bitacora/modificarBitacora', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  })
    .then(response => response.json())
    .then(data => {
      if(data == true){
        window.location.href = '../html/Docente_Inicio.html'
      }else{
        alert("Error al modificar bitacoras");
      }
    })

}



function convertToBase64() {
  var arch;
  //Read File 
  var selectedFile = document.getElementById("archivo").files;
  //Check File is not Empty 
  if (selectedFile.length > 0) {
    // Select the very first file from list 
    var fileToLoad = selectedFile[0];
    // FileReader function for read the file. 
    var fileReader = new FileReader();
    var base64;
    // Onload of file read the file content 
    fileReader.onload = function (fileLoadedEvent) {
      base64 = fileLoadedEvent.target.result;
      // Print data in console
      archivo = base64;
    };

    // Convert data to base64 
    fileReader.readAsDataURL(fileToLoad);
  }
}

function RegresarAPrincipal() {
  window.location.href = '../html/Docente_Inicio.html';
}