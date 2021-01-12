var archivo;
function registrarActividad(){
    var nombre=document.getElementById("nombre").value;
    var descripcion=document.getElementById("descripcion").value;
    var fechaCreada=document.getElementById("fechaCreada").value;
    var fechaEntrega=document.getElementById("fechaEntrega").value;
    console.log(archivo);
    var Grupo_idGrupo=2;
    var idActividad=34


    if(EmpName == 'undefined'){
      console.log("Ingresa archivo")
    }else{
      var details = {
        nombre:nombre,
        descripcion:descripcion,
        fechaCreada:fechaCreada,
        fechaEntrega:fechaEntrega,
        Grupo_idGrupo:Grupo_idGrupo,
        archivo:archivo,
        idActividad:idActividad
    };

    var formBody = [];
        for (var property in details) {
          var encodedKey = encodeURIComponent(property);
          var encodedValue = encodeURIComponent(details[property]);
          formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");
        
        fetch('http://localhost:8080/SchoolOnline/webresources/actividad/registroActividadArchivo', {
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
     fileReader.onload = function(fileLoadedEvent) { 
      base64 = fileLoadedEvent.target.result; 
      // Print data in console
      archivo= base64; 
     }; 

     // Convert data to base64 
     fileReader.readAsDataURL(fileToLoad); 
    } 
}