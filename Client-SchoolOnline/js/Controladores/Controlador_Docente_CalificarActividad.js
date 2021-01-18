var archivo;
window.onload = function () {
    EstablecerDatos();
}

function EstablecerDatos(){
  
    document.getElementById("nombre").value = sessionStorage.getItem('nombreActividad');
    document.getElementById("fechaCreada").value = sessionStorage.getItem('fechaCreada');
    document.getElementById("fechaEntrega").value = sessionStorage.getItem('fechaEntrega');
    document.getElementById("descripcion").value = sessionStorage.getItem('descripcion');
    archivo = sessionStorage.getItem("archivo");
    console.log(archivo);

}

function descargarArchivo(){
   let a = document.createElement("a");
   a.href = archivo;
   a.download = "documentName.pdf"
   a.click();
}


function CalificarActividad() {

    var idActividad = sessionStorage.getItem('idActividadEntregada');

    var calificacion = document.getElementById("calificacion").value;

  
    var details = {
      idActividadEntrega: idActividad,
      calificacion: calificacion,
    };
  
    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
  
    fetch('http://localhost:8080/SchoolOnline/webresources/actividad/calificarActividad', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        if (data.error == false) {
            alert("Actividad calificada");
        }else{
          alert("Error al registrar actividad");
        }
      })
  
}