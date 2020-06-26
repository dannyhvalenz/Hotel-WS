const queryStringHabitacion = window.location.search;
const urlParamsHabitacion = new URLSearchParams(queryStringHabitacion);
let numHabitacion = urlParamsHabitacion.get('numHabitacion');

function listarHabitaciones(){
    new Vue({
        el:"#tablaHabitaciones",
        created: function(){
            this.recuperarHabitaciones();
        },
        data:{
            habitaciones : []
        },
        methods:{
            recuperarHabitaciones:function(){
                
                this.$http.get(URL_SERVICE + 'habitaciones')
                    .then(function(respuesta){
                        this.habitaciones = respuesta.data.habitaciones;
                        //console.log(this.habitaciones);
                    }).catch((error) =>{
                        console.log(error);
                    })
            }
        }
    });
}

function consultarHabitacion(){
    new Vue({
        el:"#informacion-habitacion",
        created: function(){
            this.recuperarHabitacion();
        },
        data:{
            habitacion : []
        },
        methods:{
            recuperarHabitacion:function(){
                
                this.$http.get(URL_SERVICE + 'habitaciones/'+numHabitacion )
                    .then(function(respuesta){
                        this.habitacion = respuesta.data.habitacion;
                        console.log(this.habitacion);
                        //document.getElementById("precio").value = this.reservaciones.precio;
                        document.getElementById("numHabitacion").value = numHabitacion;
                        document.getElementById("piso").value = this.habitacion.piso;
                        document.getElementById("status").value = this.habitacion.status;
                        document.getElementById("tipoHabitacion").value = this.habitacion.tipoHabitacion;
                        setNumCamas();
                    }).catch((error) =>{
                        console.log(error);
                    })
            }
        }
    });
}

function registrarHabitacion(){
    var habitacion = {
        numHabitacion: $('#numHabitacion').val(),
        tipoHabitacion: $('#tipoHabitacion').val(),
        cupoPersonas: parseInt($('#cupoPersonas').val(), 10),
        numCamas: parseInt($('#numCamas').val(), 10),
        piso: parseInt($('#piso').val(), 10),
        status: $('#status').val(),
    }
    console.log(JSON.stringify(habitacion));
    
    axios.post(URL_SERVICE + 'habitacion', habitacion
    ).then((response) => {
        window.location = "habitaciones.html";
    }).catch((error) => {
        console.log(error);
        $('#errorModal').modal('show');
    });
}

function actualizarHabitacion(){
    var habitacion = {
        tipoHabitacion: $('#tipoHabitacion').val(),
        cupoPersonas: parseInt($('#cupoPersonas').val(), 10),
        numCamas: parseInt($('#numCamas').val(), 10),
        piso: parseInt($('#piso').val(), 10),
        status: $('#status').val(),
    }
    console.log(JSON.stringify(habitacion));
    axios.put(URL_SERVICE + 'habitacion/' + numHabitacion, habitacion
    ).then((response) => {
        var data = response.data;
        window.location = "habitaciones.html";
    }).catch((error) => {
        console.log(error);
        $('#errorModal').modal('show');
    });
}

function eliminarHabitacion(){
    console.log("numhabitacion = " + numHabitacion);
    axios.delete(URL_SERVICE + 'habitacion/'+numHabitacion).then((response) => {
        // Refresh de la tabla
        location.reload();
    }).catch((error) => {
        console.log(error);
    });
}

function clickEliminar(id){
    numHabitacion = id;
    console.log("numhabitacion click = " + numHabitacion);
    $('#confirm-delete').modal('show');
}

function editarHabitacion(numHabitacion){
    window.location = "editarHabitacion.html?numHabitacion="+numHabitacion;
}
                            
function setNumCamas() {
    switch (document.getElementById('tipoHabitacion').value) {
        case "Sencilla":
            document.getElementById('numCamas').value = "1";
            document.getElementById('cupoPersonas').value = "2";
            break;
    
        case "Doble":
            document.getElementById('numCamas').value = "2";
            document.getElementById('cupoPersonas').value = "4";
            break;
        case "Junior":
            document.getElementById('numCamas').value = "3";
            document.getElementById('cupoPersonas').value = "6";
            break;

        case "Suite":
            document.getElementById('numCamas').value = "4";
            document.getElementById('cupoPersonas').value = "8";
        break;
    }
}