function registrarGrupo(){
    var nombre = document.getElementById("nombre").value;
    var Foro_idForo =10;
    var nombreF = nombre;
    var CicloEscolar_idCicloEscolar =1;
    Docente_idDocente=1;

    var details ={
        Foro_idForo,
        nombreF:nombreF,
        nombre:nombre,
        CicloEscolar_idCicloEscolar:CicloEscolar_idCicloEscolar,
        Docente_idDocente:Docente_idDocente
    };

    var formBody = [];
        for (var property in details) {
          var encodedKey = encodeURIComponent(property);
          var encodedValue = encodeURIComponent(details[property]);
          formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");
        
        fetch('http://localhost:8080/SchoolOnline/webresources/grupo/RegistrarGrupo', {
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