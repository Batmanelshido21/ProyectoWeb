var archivo;
function registrarBitacora(){
    var fecha = document.getElementById("fecha").value;
    var  Docente_idDocente= 1;
   console.log(archivo);

   var details ={
       Docente_idDocente:Docente_idDocente,
       fecha:fecha,
       archivo:archivo
   };

   var formBody = [];
        for (var property in details) {
          var encodedKey = encodeURIComponent(property);
          var encodedValue = encodeURIComponent(details[property]);
          formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");
        
        fetch('http://localhost:8080/SchoolOnline/webresources/bitacora/registrarBitacora', {
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
