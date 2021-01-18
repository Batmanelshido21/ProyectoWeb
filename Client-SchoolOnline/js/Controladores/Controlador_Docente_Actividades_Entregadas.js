var actividades = [];

window.onload = function () {
    ObtenerActividades();
}

function ObtenerActividades() {

    var idActividad = sessionStorage.getItem('idAxtividadEncargada');

    fetch('http://localhost:8080/SchoolOnline/webresources/actividad/obtenerActividadesEntrega/' + idActividad, {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {

            actividades = data;
            console.log(data);
            var cuerpo = document.getElementById('cuerpo');

            for (var i = 0; i < data.length; i++) {

                var tr = document.createElement('tr');

                var button = document.createElement("input");
                button.type = 'button';
                button.id = data[i].idActividadEntrega;
                button.value = data[i].nombre;
                button.archivo= data[i].archivo;
                button.style.border = "none";
                button.style.backgroundColor = "transparent";

                var celda = document.createElement('td')
                celda.appendChild(button);

                var celda2 = document.createElement('td')

                fetch('http://localhost:8080/SchoolOnline/webresources/cuenta/obtenerNombreAlumno/' + data[i].alumno_idAlumno, {
                    method: 'GET',
                })
                    .then(response => response.json())
                    .then(data2 => {
                        celda2.innerHTML = data2.nombre;
                    })


                var celda3 = document.createElement('td')
                celda3.innerHTML = data[i].calificacion;

                tr.appendChild(celda);
                tr.appendChild(celda2);
                tr.appendChild(celda3);
                cuerpo.appendChild(tr);
            }
        })
}

$(function () {
    $(document).on('click', 'input[type="button"]', function (event) {
        let id = this.id;
        let archivo = this.archivo;
        console.log(archivo);
        sessionStorage.setItem('idActividadEntregada', id);
        sessionStorage.setItem('archivo',archivo);
        window.location.href = '../html/Docente_CalificarActividad.html';
    });
});