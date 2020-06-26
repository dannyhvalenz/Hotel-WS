const queryStringReservaciones = window.location.search;
const urlParamsReservaciones = new URLSearchParams(queryStringReservaciones);
const id = urlParamsReservaciones.get('reservacion');

// Lista de reservaciones
function listarReservaciones(){
    new Vue({
        el:"#tablaReservaciones",
        created: function(){
            this.recuperarReservaciones();
        },
        data:{
            reservaciones : []
        },
        methods:{
            recuperarReservaciones:function(){
                console.log(URL_SERVICE);
                this.$http.get(URL_SERVICE + 'reservaciones')
                    .then(function(respuesta){
                        this.reservaciones = respuesta.data.reservaciones;
                    }).catch((error) =>{
                        console.log(error);
                    })
            }
        }
    });
}

// Consultar reservacion
function consultarReservacion(){
    new Vue({
        el:"#informacion-reservacion",
        created: function(){
            this.recuperarReservacion();
        },
        data:{
            reservaciones : []
        },
        methods:{
            recuperarReservacion:function(){
                
                this.$http.get(URL_SERVICE + 'reservaciones/'+id )
                    .then(function(respuesta){
                        this.reservaciones = respuesta.data.reservacion;
                        //document.getElementById("precio").value = this.reservaciones.precio;
                        document.getElementById("numPersonas").value = this.reservaciones.numPersonas;
                        document.getElementById("cliente").value = this.reservaciones.idCliente;
                        var fLlegada = new Date(this.reservaciones.fechaLlegada).toDateInputValue();
                        var fSalida = new Date(this.reservaciones.fechaSalida).toDateInputValue();
                        document.getElementById("fechaLlegada").value = fLlegada;
                        document.getElementById("fechaSalida").value = fSalida;
                        document.getElementById("tipoHabitacion").value = this.reservaciones.tipoHabitacion;
                        obtenerPrecio();
                        datosInicialesActualizar();
                    }).catch((error) =>{
                        console.log(error);
                    })
            }
        }
    });
}

// Agregar reservacion
function reservar(){
    var reservacion = {
        idCliente: $('#cliente').val(),
        tipoHabitacion: $('#tipoHabitacion').val(),
        fechaLlegada: $('#fechaLlegada').val(),
        fechaSalida: $('#fechaSalida').val(),
        numPersonas: parseInt($('#numPersonas').val(), 10),
        precio: parseInt($('#precio').val(), 10),
        status: 'vigente',
    }
    console.log(JSON.stringify(reservacion));
    axios.post(URL_SERVICE + 'reservacion', reservacion
    ).then((response) => {
        window.location = "reservaciones.html";
    }).catch((error) => {
        console.log(error);
        $('#errorModal').modal('show');
    });
}

// Actualizar reservacion
function actualizarReservacion(){
    var reservacion = {
        idCliente: 1,
        tipoHabitacion: $('#tipoHabitacion').val(),
        fechaLlegada: $('#fechaLlegada').val(),
        fechaSalida: $('#fechaSalida').val(),
        numPersonas: parseInt($('#numPersonas').val(), 10),
        precio: parseInt($('#precio').val(), 10),
        status: 'vigente',
    }
    console.log(JSON.stringify(reservacion));
    axios.put(URL_SERVICE + 'reservacion/' + id, reservacion
    ).then((response) => {
        var data = response.data;
        window.location = "reservaciones.html";

    }).catch((error) => {
        console.log(error);
        $('#errorModal').modal('show');
    });
}

// Eliminar reservacion
function eliminarReservacion(id){
    axios.delete(URL_SERVICE + 'reservacion/'+id).then((response) => {
        // Refresh de la tabla
        location.reload();
    }).catch((error) => {
        console.log(error);
        $('#errorModal').modal('show');
    });
}

// Cambiar Pantalla a Editar Reservacion
function editarReservacion(id){
    window.location = "editarReservacion.html?reservacion="+id;
}

// Datos iniciales para una nueva reservacion
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});

function datosInicialesNuevoRegistro(){
    document.getElementById("precio").value = 900;
    document.getElementById("fechaLlegada").value = new Date().toDateInputValue();
    document.getElementById("fechaLlegada").setAttribute("min", new Date().toDateInputValue());
    document.getElementById("fechaSalida").value = new Date((new Date()).valueOf() + 1000 * 3600 * 24).toDateInputValue();
    document.getElementById("fechaSalida").setAttribute("min", new Date((new Date()).valueOf() + 1000 * 3600 * 24).toDateInputValue());
    comboCliente();
}

function datosInicialesActualizar(){
    document.getElementById("fechaLlegada").setAttribute("min", new Date().toDateInputValue() );
    document.getElementById("fechaSalida").setAttribute("min", new Date().toDateInputValue());
}

//
function actualizarNumPersonas(tipo){
    document.getElementById("numPersonas").selectedIndex = "1"; 
    switch (tipo){
        case "Sencilla":
            for(var i = 1; i <= 8; i++){
                console.log(i);
                if (i > 2){
                    document.getElementById("numPersonas").options[i].disabled = false;
                } else {
                    document.getElementById("numPersonas").options[i].disabled = true;
                }
            }
        break;
        case "Doble":
            for(var i = 1; i <= 8; i++){
                console.log(i);
                if (i < 5){
                    document.getElementById("numPersonas").options[i].disabled = false;
                } else {
                    document.getElementById("numPersonas").options[i].disabled = true;
                }
            }
        break;
        case "Junior":
            for(var i = 1; i <= 8; i++){
                console.log(i);
                if (i < 7){
                    document.getElementById("numPersonas").options[i].disabled = false;
                } else {
                    document.getElementById("numPersonas").options[i].disabled = true;
                }
            }
        break;
        case "Suite":
            for(var i = 1; i <= 8; i++){
                console.log(i);
                    document.getElementById("numPersonas").options[i].disabled = false;
            }
        break;
    }
}

// Obtener precio de la reservacion

function obtenerPrecio(){

    var tipo = document.getElementById("tipoHabitacion").value;
    var llegada = document.getElementById("fechaLlegada").value;
    var salida = document.getElementById("fechaSalida").value;

    llegada = new Date(llegada);
    salida = new Date(salida);

    console.log("salida = " + salida);
    var diferenciaTiempo = Math.abs(salida.getTime() - llegada.getTime());
    let milisegundosEnDia = (1000 * 3600 * 24);

    let diferenciaDias = Math.ceil(diferenciaTiempo / milisegundosEnDia);

    let precio = 0;
    console.log(tipoHabitacion);
    console.log("diferencia = " + diferenciaDias);

    switch(tipo){
        case "Sencilla":
            precio = 0;
            if (diferenciaDias == 0 || diferenciaDias == 1){
                document.getElementById("precio").value = 900;
            } else {
                precio = 900 * diferenciaDias;
                document.getElementById("precio").value = precio;
            }
            break;
        case "Doble":
            precio = 0;
            if (diferenciaDias == 0 || diferenciaDias == 1){
                document.getElementById("precio").value = 1400;
            } else {
                precio = 1400 * diferenciaDias;
                document.getElementById("precio").value = precio;
            }
            break;
        case "Junior":
            precio = 0;
            if (diferenciaDias == 0 || diferenciaDias == 1){
                document.getElementById("precio").value = 1900;
            } else {
                precio = 1900 * diferenciaDias;
                document.getElementById("precio").value = precio;
            }
            break;
        case "Suite":
            precio = 0;
            if (diferenciaDias == 0 || diferenciaDias == 1){
                document.getElementById("precio").value = 2400;
            } else {
                precio = 2400 * diferenciaDias;
                document.getElementById("precio").value = precio;
            }
            break;
    }
    actualizarNumPersonas(tipo);
}

// Dar formato a la fecha
function actualizarFormatoFecha(fechaRecibida){
    var fecha = new Date(fechaRecibida);
    mnth = ("0" + (fecha.getMonth() + 1)).slice(-2),
    day = ("0" + fecha.getDate()).slice(-2);
    return [fecha.getFullYear(), mnth, day].join("-");
}