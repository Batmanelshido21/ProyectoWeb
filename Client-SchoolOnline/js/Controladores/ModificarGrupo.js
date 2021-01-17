function modificarGrupo(){
    var idGrupo=2;
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
    
    fetch('http://localhost:8080/SchoolOnline/webresources/grupo/modificarGrupo', {
      method: 'PUT',
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