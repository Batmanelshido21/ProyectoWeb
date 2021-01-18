var bitacoras = [];

window.onload = function () {
    ObtenerBitacoras();
  }
  
  function ObtenerBitacoras() {
    
    idDocente = sessionStorage.getItem('idDocente');
  
    fetch('http://localhost:8084/SchoolOnline/webresources/bitacora/getBitacoras/' + idDocente, {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {
  
        bitacoras = data;
  
        var cuerpo = document.getElementById('cuerpo');
          
        for (var i = 0; i < data.length; i++) {
          var tr = document.createElement('tr');
  
          var button = document.createElement("input");
          button.type = 'button';
          button.id = data[i].idBitacora;
          button.value = data[i].fecha;
          button.style.border = "none";
          button.style.backgroundColor = "transparent";
          
          var celda = document.createElement('td')
          celda.appendChild(button);
  
          tr.appendChild(celda);
          cuerpo.appendChild(tr);
          }
      })
  }
  
  $(function() {
    $(document).on('click', 'input[type="button"]', function(event) {
       let id = this.id;
       var bitacora = bitacoras.find( a => a.idBitacora == id);
       sessionStorage.setItem('idBitacora', id);
       sessionStorage.setItem('fechaBitacora', bitacora.fecha);
       sessionStorage.setItem('archivoBitacora', bitacora.archivo);
       window.location.href = '../html/RegistroBitacora.html';
     });
   });