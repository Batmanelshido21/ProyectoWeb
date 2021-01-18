var archivo = "";
var idAct

window.onload = function () {

    idAct = sessionStorage.getItem('idAxtividadEncargada');
    
    document.getElementById("nombre").value = sessionStorage.getItem('nombreActividad');
    document.getElementById("fechaCreada").value = sessionStorage.getItem('fechaCreada');
    document.getElementById("fechaEntrega").value = sessionStorage.getItem('fechaEntrega');
    document.getElementById("descripcion").value = sessionStorage.getItem('descripcion');
}

function registrarActividad() {
    if (archivo != "") {
        ModificarConArchivo();
    } else {
        ModificarSinArchivo();
    }
}

function ModificarConArchivo() {
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;
    var fechaCreada = document.getElementById("fechaCreada").value;
    var fechaEntrega = document.getElementById("fechaEntrega").value;
    console.log("Entro al registar con archivo");

    var details = {
        idActividad: idAct,
        nombre: nombre,
        descripcion: descripcion,
        fechaCreada: fechaCreada,
        fechaEntrega: fechaEntrega,
        archivo: archivo
    };

    var formBody = [];
    for (var property in details) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(details[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    fetch('http://localhost:8084/SchoolOnline/webresources/actividad/modificarActividadArchivo', {
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
                MostrarVentanaModal();
            } else {
                alert("Error al registrar actividad");
            }
        })

}

function ModificarSinArchivo() {
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;
    var fechaCreada = document.getElementById("fechaCreada").value;
    var fechaEntrega = document.getElementById("fechaEntrega").value;
    console.log("Entro al registar sin archivo");

    var details = {
        idActividad: idAct,
        nombre: nombre,
        descripcion: descripcion,
        fechaCreada: fechaCreada,
        fechaEntrega: fechaEntrega
    };

    var formBody = [];
    for (var property in details) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(details[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    fetch('http://localhost:8084/SchoolOnline/webresources/actividad/modificarActividad', {
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
                MostrarVentanaModal();
            } else {
                alert("Error al registrar actividad");
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

function MostrarVentanaModal() {
    var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
    myModal.show();
}