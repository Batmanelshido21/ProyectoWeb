
function modificarGrupo(){
    var idGrupo= sessionStorage.getItem('idGrupo');
    var nombre = document.getElementById("nombre").value;

    var details ={
        idGrupo:idGrupo,
        nombre:nombre
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    
    fetch('http://localhost:8084/SchoolOnline/webresources/grupo/modificarGrupo', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
      if(data.error == true){
        window.location.href = '../html/Docente_Inicio.html';
      }else{
        alert("Error al modificar grupo");
      }
    })
}