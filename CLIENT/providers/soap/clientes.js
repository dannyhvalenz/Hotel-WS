const queryStringCliente = window.location.search;
const urlParamsCliente = new URLSearchParams(queryStringCliente);
let idCliente = urlParamsCliente.get('cliente');

function listarClientes(){
    new Vue({
        el: '#tablaClientes',
        created: function() {
            this.recuperarPost();
        },
        data: {
            clientes: []
        },
        methods: {
            recuperarPost: function() {
                console.log("Listar clientes");
                this.$http.post('providers/soap-clientes.php', { metodo: 0}).then(function(respuesta) {
                    if (respuesta.data.respuesta == "exito"){
                        this.clientes = respuesta.data.clientes;
                        // mostrar mensaje no se pudieron cargar los clientes
                    } else if (respuesta.data.respuesta == "error"){

                    }
                }).catch(error => {
                    console.log(error.message);
                });
            }
        }
    });
}

function consultarCliente(){

    new Vue({
        el: '#cliente',
        created: function() {
            this.recuperarPost();
        },
        data: {
            cliente: []
        },
        methods: {
            recuperarPost: function() {
                console.log("Consultar cliente");
                this.$http.post('providers/soap-clientes.php', { metodo: 1, idCliente: idCliente}).then(function(respuesta) {
                    
                    if (respuesta.data.respuesta == "exito"){
                        this.cliente = respuesta.data.cliente;
                        $('#nombre').val(this.cliente.nombre);
                        $('#apellido').val(this.cliente.apellido);
                        var telefono = this.cliente.telefono;
                        telefono = telefono.split("-").join('');
                        $('#telefono').val(telefono);
                        $('#correo').val(this.cliente.correo);
                        
                        if (this.cliente.formaPago == "Credito"){
                            $('select[name=formaPago]').val("Credito");
                            $('.selectpicker').selectpicker('refresh')
                        } else if (this.cliente.formaPago == "Debito"){
                            $('select[name=formaPago]').val("Debito");
                            $('.selectpicker').selectpicker('refresh')
                        } else if (this.cliente.formaPago == "Efectivo"){
                            $('select[name=formaPago]').val("Efectivo");
                            $('.selectpicker').selectpicker('refresh')
                        }  
                    } else if (respuesta.data.respuesta == "error"){

                    }
                    
                    
                }).catch(error => {
                    console.log(error.message);
                });
            }
        }
    });
}

function agregarCliente(){
    
    new Vue({
        el: '#cliente',
        created: function() {
            this.recuperarPost();
        },
        data: {
            cliente: []
        },
        methods: {
            recuperarPost: function() {
                console.log("Agregar cliente");
                var nombre = $('#nombre').val();
                var apellido = $('#apellido').val();
                var correo = $('#correo').val();
                var telefono = $('#telefono').val();
                var formaPago = $('#formaPago').val();
                //let json = JSON.stringify({ nombre, apellido, correo, telefono, formaPago});

                let json = {
                    nombre: nombre,
                    apellido: apellido,
                    correo: correo,
                    telefono: telefono,
                    formaPago: formaPago,
                }

                console.log(json);
                this.$http.post('providers/soap-clientes.php', { metodo: 2, json: json}).then(function(respuesta) {
                    console.log(respuesta);
                    if (respuesta.data.mensaje == "exito"){
                        window.location = "clientes.html";
                    } else if (respuesta.data.mensaje == "error"){
                        $('#clienteDuplicadoModal').modal('hide');
                        $('#errorModal').modal('show');
                    } else if (respuesta.data.mensaje == "duplicado"){
                        $('#errorModal').modal('hide');
                        $('#clienteDuplicadoModal').modal('show');
                    }
                }).catch(error => {
                    console.log(error.message);
                    $('#errorModal').modal('show');
                });
            }
        }
    });
}

function actualizarCliente(){
    new Vue({
        el: '#cliente',
        created: function() {
            this.recuperarPost();
        },
        data: {
            cliente: []
        },
        methods: {
            recuperarPost: function() {
                console.log("Actualizar cliente");
                var nombre = $('#nombre').val();
                var apellido = $('#apellido').val();
                var correo = $('#correo').val();
                var telefono = $('#telefono').val();
                var formaPago = $('#formaPago').val();

                let json = {
                    idCliente: idCliente,
                    nombre: nombre,
                    apellido: apellido,
                    correo: correo,
                    telefono: telefono,
                    formaPago: formaPago,
                }

                this.$http.post('providers/soap-clientes.php', { metodo: 3, json: json}).then(function(respuesta) {
                    console.log(respuesta);
                    if (respuesta.data.mensaje == "exito"){
                        window.location = "clientes.html";
                    } else if (respuesta.data.mensaje == "error"){
                        $('#nombre').val(nombre);
                        $('#apellido').val(apellido);
                        $('#correo').val(correo);
                        $('#telefono').val(telefono);
                        $('#formaPago').val(apellido);

                        $('#errorModal').modal('show');
                    }
                }).catch(error => {
                    console.log(error.message);
                });
            }
        }
    });
}

function eliminarCliente(){
    new Vue({
        el: '#cliente',
        created: function() {
            this.recuperarPost();
        },
        data: {
            cliente: []
        },
        methods: {
            recuperarPost: function() {
                console.log("Eliminar cliente");
                this.$http.post('providers/soap-clientes.php', { metodo: 4, idCliente: idCliente}).then(function(respuesta) {
                    console.log(respuesta);
                    if (respuesta.data.mensaje == "exito"){
                        window.location = "clientes.html";
                    } else if (respuesta.data.mensaje == "error"){
                        $('#clienteDuplicadoModal').modal('hide');
                        $('#errorModal').modal('show');
                    } 
                }).catch(error => {
                    console.log(error.message);

                });
            }
        }
    });
    /*this.$http.post('providers/soap/soap-clientes.php', { metodo: 4, id: cliente })
    .then(function(respuesta) {
       console.log(respuesta.data);
    });*/
}

function comboCliente(){
    new Vue({
        el:"#comboCliente",
        created: function(){
            this.recuperarReservacion();
        },
        data:{
            clientes : []
        },
        methods:{
            recuperarReservacion:function(){
                this.$http.get(URL_SERVICE + 'clientes' )
                    .then(function(respuesta){
                        this.clientes = respuesta.data.clientes;
                        console.log(this.clientes);
                    }).catch((error) =>{
                        console.log(error);
                    })
            }
        }
    });
}

function editarCliente(cliente){
    window.location = "editarCliente.html?cliente="+cliente;
}

function clickEliminar(id){
    idCliente = id;
    console.log("idCliente click = " + idCliente);
    $('#confirm-delete').modal('show');
}