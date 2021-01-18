window.onload = function () {
    getPlantel();
}

function ActualizarDatos() {

    var idPlantel = document.getElementById("clave").value; 
    var sector =  document.getElementById("sector").value;
    var niv = document.getElementById("nivelEscolar").value;
    var zona = document.getElementById("zona").value;
    var dir = document.getElementById("direccion").value;
   
    var details = {
        clave: idPlantel,
        sector: sector,
        nivelEscolar: niv,
        zona: zona,
        direccion: dir
    };

    var formBody = [];
    for (var property in details) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(details[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    fetch('http://localhost:8084/SchoolOnline/webresources/plantel/modificarPlantel', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: formBody
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            if (data.error == true) {
                window.location.href = '../html/RepresentantePlantel_Inicio.html'
            } else {
                alert("Error al actualizar datos");
            }
        })
}

function getPlantel() {
    var idPlantel = sessionStorage.getItem('clavePlantel');

    fetch('http://localhost:8084/SchoolOnline/webresources/plantel/getPlantel/' + idPlantel, {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("clave").value = data.clave;
            document.getElementById("sector").value = data.sector;
            document.getElementById("nivelEscolar").value = data.nivelEscolar;
            document.getElementById("zona").value = data.zona;
            document.getElementById("direccion").value = data.direccion;
        })
}

function Regresar() {
    window.location.href = '../html/RepresentantePlantel_Inicio.html'
}