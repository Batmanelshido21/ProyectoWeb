function recuperarContraseña(){
    var correo = document.getElementById("correo").value;

    var details ={
        correo:correo
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    
    fetch('http://localhost:8084/SchoolOnline/webresources/cuenta/recuperarContraseña', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
      window.location.href = '../html/index.html';
    })
}

function volverLogin(){
  window.location.href = '../html/index.html';
}