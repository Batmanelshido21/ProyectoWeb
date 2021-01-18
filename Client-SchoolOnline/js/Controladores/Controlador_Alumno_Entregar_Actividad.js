var archivo = "";

window.onload = function () {
  EstablecerDatos();
}

function registrarActividad() {
  if (archivo != "") {
    RegistrarActividad();
  } else {
    alert("Debe seleccionar un archivo para registrar su respuesta a esta actividad");
  }
}

function descargarMaterialApoyo(){

  var idActividad = sessionStorage.getItem('idActividad');;
  console.log(idActividad);
  var details = {
    idActividad:idActividad
  };


  var formBody = [];
  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  fetch('http://localhost:8084/SchoolOnline/webresources/actividad/obtenerArchivoActividad', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  })
    .then(response => response.json())
    .then(data => {
      archivo=data.archivo;
      descargarArchivo();
    })
}

function descargarArchivo(){
  let a = document.createElement("a");
  a.href = archivo;
  a.download = "documentName.pdf"
  a.click();
}

function RegistrarActividad() {

  var nombre = document.getElementById("nombre").value;
  var Actividad_idActividad = sessionStorage.getItem('idActividad');
  var idAlumno = sessionStorage.getItem('idAlumno');

  var details = {
    archivo: archivo,
    nombre: nombre,
    Actividad_idActividad: Actividad_idActividad,
    Alumno_idAlumno: idAlumno
  };

  var formBody = [];
  for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  fetch('http://localhost:8084/SchoolOnline/webresources/actividad/EntregarActividad', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  })
    .then(response => response.json())
    .then(data => {
      console.log(data);
      if (data.error == false) {
        MostrarVentanaModal();
      }else{
        alert("Error al registrar actividad");
      }
    })

}

function EstablecerDatos(){
  
    document.getElementById("nombre").value = sessionStorage.getItem('nombreActividad');
    document.getElementById("fechaCreada").value = sessionStorage.getItem('fechaCreada');
    document.getElementById("fechaEntrega").value = sessionStorage.getItem('fechaEntrega');
    document.getElementById("descripcion").value = sessionStorage.getItem('descripcion');

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
  window.location.href = '../html/Alumno_Inicio.html';
}

function MostrarVentanaModal() {
  var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
  myModal.show();
}