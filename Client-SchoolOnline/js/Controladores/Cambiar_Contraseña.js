function volverLogin(){
    window.location.href = '../index.html';
}

function cambiarContraseña(){
    var contrasena = document.getElementById("contrasena").value;
    var contrasena2 = document.getElementById("contrasena2").value;
    var correo = "javierjuarez.jj28@gmail.com"

    if(contrasena==contrasena2){
        var details ={
            correo:correo,
            contrasena:contrasena
        };

        console.log(correo);
        console.log(contrasena);

        var formBody = [];

        for (var property in details) {
          var encodedKey = encodeURIComponent(property);
          var encodedValue = encodeURIComponent(details[property]);
          formBody.push(encodedKey + "=" + encodedValue);
        }
      
        formBody = formBody.join("&");
      
        fetch('http://localhost:8080/SchoolOnline/webresources/cuenta/modificarContrasena', {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
          },
          body: formBody
        })
          .then(response => response.json())
          .then(data => {
            console.log(data);
            if(data.error!=false){
                volverLogin();
            }
          })
    }else{
        console.log("Las contraseñas no son las mismas");
    }
}