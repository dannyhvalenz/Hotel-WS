require('./config/config');
const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors');
const app = express();
var dbConn  = require('../lib/db');

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

app.use(cors());
// parse application/json
app.use(bodyParser.json())

app.get('/', function(req, res) {
    res.json('API REST de un hotel')
});

/* ----------------- HABITACIONES ----------------- */
// Listar todas las habitaciones
app.get('/habitaciones', function(req, res) {
    dbConn.query('SELECT * FROM habitaciones',function(err,rows)     {
        if(err) {
            console.log(err.message);
            res.json({
                mensaje: "No se encontraron habitaciones"
            })
        } else {
            res.json({
                habitaciones: rows
            })
        }
    });
});

// Consultar habitacion
app.get('/habitaciones/:numHabitacion', function(req, res) {

    let numHabitacion = req.params.numHabitacion;
    dbConn.query('SELECT * FROM habitaciones WHERE numHabitacion = ' + numHabitacion,function(err,rows)     {
 
        if(err) {
            res.json({
                mensaje: "No se encontró la habitación"
            })
        } else {
            res.json({
                habitacion: rows[0]
            })
        }
    });

});

// Obtener cuantas habitaciones hay por tipo de habitacion 
app.get('/tipos/habitaciones/', function(req, res) {

    dbConn.query("SELECT tipoHabitacion FROM habitaciones WHERE status='Disponible'",function(err,rows)     {
 
        if(err) {
            console.log(err.message);
            res.json({
                titulo: "Error",
                mensaje: "No se encontraron habitaciones"
            })
        } else {
            let sencilla  = rows.filter((habitacion) => {
                if (habitacion.tipoHabitacion == "Sencilla") {
                    return habitacion;
                }
            })
            let doble  = rows.filter((habitacion) => {
                if (habitacion.tipoHabitacion == "Doble") {
                    return habitacion;
                }
            })
            let junior  = rows.filter((habitacion) => {
                if (habitacion.tipoHabitacion == "Junior") {
                    return habitacion;
                }
            })
            let suite  = rows.filter((habitacion) => {
                if (habitacion.tipoHabitacion == "Suite") {
                    return habitacion;
                }
            })
            
            res.json({
                Sencilla: sencilla.length, 
                Doble: doble.length,
                Junior:junior.length,
                Suite: suite.length
            })
        }
    });
    
});

// Agregar habitacion
app.post('/habitacion', function(req, res) {

    let numHabitacion = req.body.numHabitacion;
    let piso = req.body.piso;
    let cupoPersonas = req.body.cupoPersonas;
    let tipoHabitacion = req.body.tipoHabitacion;
    let numCamas = req.body.numCamas;
    let status = req.body.status;
    var form_data = {
        numHabitacion: numHabitacion,
        piso: piso, 
        numCamas: numCamas, 
        status: status,
        tipoHabitacion: tipoHabitacion,
        cupoPersonas: cupoPersonas
    }
    if (numHabitacion === '' || piso == ''  || cupoPersonas == ''
        || tipoHabitacion == '' || numCamas == '' || status == ''
        || numHabitacion === undefined || piso == undefined  || cupoPersonas == undefined
        || tipoHabitacion == undefined || numCamas == undefined || status == undefined) {

        res.status(400).json({
            ok: false,
            titulo: "Campos Vacíos",
            mensaje: 'Ingresa el número de habitación, piso, cupo de persona, tipo de habitación, numero de camas y status de la habitación'
        })
    } else {
        dbConn.query('SELECT * FROM habitaciones WHERE numHabitacion = ' + numHabitacion,function(err,rows)     {
            
            if(err) {
                res.json({
                    titulo: "Error de conexión",
                    mensaje: "No se pudo registrar la habitación en la base de datos"
                })
            } else if (rows && rows.length ) {
                
                res.json({
                    titulo: "Error al registrar",
                    mensaje: "Habitación duplicada"
                })
            } else {
                
                dbConn.query('INSERT INTO habitaciones SET ?', form_data,function(err,rows)     {
 
                    if(err) {
                        res.json({
                            mensaje: "No se pudo registrar la habitación en la base de datos"
                        })
                    } else {
                        res.json({
                            mensaje: "Habitacion agregada"
                        })
                    }
                });
            }
        });
        
    }

});

// Actualizar habitacion
app.put('/habitacion/:numHabitacion', function(req, res) {
    let numHabitacion = req.params.numHabitacion;
    let piso = req.body.piso;
    let cupoPersonas = req.body.cupoPersonas;
    let tipoHabitacion = req.body.tipoHabitacion;
    let numCamas = req.body.numCamas;
    let status = req.body.status;
    var form_data = {
        numHabitacion: numHabitacion,
        piso: piso, 
        numCamas: numCamas, 
        status: status,
        tipoHabitacion: tipoHabitacion,
        cupoPersonas: cupoPersonas
    }
    if (numHabitacion === '' || piso == ''  || cupoPersonas == ''
        || tipoHabitacion == '' || numCamas == '' || status == ''
        || numHabitacion === undefined || piso == undefined  || cupoPersonas == undefined
        || tipoHabitacion == undefined || numCamas == undefined || status == undefined) {

        res.status(400).json({
            ok: false,
            titulo: "Campos Vacios",
            mensaje: 'Ingresa el numero de habitación, piso, cupo de persona, tipo de habitación, numero de camas y status de la habitación'
        })
    } else {
        dbConn.query('SELECT * FROM habitaciones WHERE numHabitacion = ' + numHabitacion,function(err,rows)     {
            
            if(err) {
                res.json({
                    titulo: "Error de conexion",
                    mensaje: "No se pudo registrar la habitación en la base de datos"
                })
            } else if (rows && rows.length > 1 ) {
                
                res.json({
                    titulo: "Habitación duplicada",
                    mensaje: "Ya existe una habitación con el número de habitación " + numHabitacion
                })
            } else {
                
                dbConn.query('UPDATE habitaciones SET ? WHERE numHabitacion = '+ numHabitacion, form_data,function(err,rows)     {
 
                    if(err) {
                        res.json({
                            mensaje: "No se pudo actualizar la habitación en la base de datos"
                        })
                    } else {
                        res.json({
                            mensaje: "Habitacion actualizada"
                        })
                    }
                });
            }
        });
        
    }
});

// Eliminar habitacion
app.delete('/habitacion/:numHabitacion', function(req, res) {
    let numHabitacion = req.params.numHabitacion;
    dbConn.query('DELETE FROM habitaciones WHERE numHabitacion = '+ numHabitacion, function(err,rows)     {

        if(err) {
            res.json({
                mensaje: "No se pudo eliminar la habitación en la base de datos"
            })
        } else {
            res.json({
                mensaje: "Habitación eliminada"
            })
        }
    });
});


/* ----------------- RESERVACIONES ----------------- */
// Listar todas las reservaciones
app.get('/reservaciones', function(req, res) {
    dbConn.query('SELECT * FROM reservaciones',function(err,rows)     {
        if(err) {
            console.log(err.message);
            res.json({
                mensaje: "No se encontraron reservaciones"
            })
        } else {
            var reservacionjson = [];
            rows.forEach(element => {
                    var fechaLlegada = formatDate(element.fechaLlegada);
                    var fechaSalida = formatDate(element.fechaSalida);
                    
                    var reservacion = {
                        idReservacion: element.idReservacion,
                        fechaLlegada: fechaLlegada,
                        fechaSalida: fechaSalida,
                        numPersonas: element.numPersonas,
                        tipoHabitacion: element.tipoHabitacion,
                        precio: element.precio,
                        idCliente: element.idCliente,
                        status: element.status
                    }
                    reservacionjson.push(reservacion);
                    
            });
            res.json({
                reservaciones: reservacionjson
            })
        }
    });
});

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [day, month, year].join('-');
}

// Consultar reservacion
app.get('/reservaciones/:idReservacion', function(req, res) {

    let idReservacion = req.params.idReservacion;
    dbConn.query('SELECT * FROM reservaciones WHERE idReservacion = ' + idReservacion,function(err,rows)     {
 
        if(err) {
            res.json({
                mensaje: "No se encontró la reservación"
            })
        } else {
            res.json({
                reservacion: rows[0]
            })
        }
    });

});


// Agregar reservacion
app.post('/reservacion', function(req, res) {

    let idCliente = req.body.idCliente;
    let tipoHabitacion  = req.body.tipoHabitacion;
    let fechaLlegada = req.body.fechaLlegada;
    let fechaSalida = req.body.fechaSalida;
    let numPersonas = req.body.numPersonas;
    let precio = req.body.precio;
    let status = req.body.status;


    var form_data = {
        idCliente: idCliente,
        tipoHabitacion: tipoHabitacion, 
        fechaLlegada: fechaLlegada, 
        fechaSalida: fechaSalida,
        numPersonas: numPersonas,
        precio: precio,
        status: status
    }

    if (idCliente === '' || tipoHabitacion == ''  || fechaLlegada == '' 
        || fechaSalida == '' || numPersonas == '' || precio ==  ''  || status == ''
        || idCliente === undefined || tipoHabitacion == undefined  || fechaLlegada == undefined 
        || fechaSalida == undefined || numPersonas == undefined || precio ==  undefined  || status == undefined) {

        res.status(400).json({
            ok: false,
            titulo: "Campos Vacíos",
            mensaje: 'Ingresa el cliente, tipo de habitación, fecha de llegada, fecha de salida y número de personas'
        })
    } else {
        dbConn.query('INSERT INTO reservaciones SET ?', form_data,function(err,rows)     {
 
            if(err) {
                console.log(err.message);
                res.json({
                    mensaje: "No se pudo registrar la reservación en la base de datos"
                })
            } else {
                res.json({
                    mensaje: "Reservación agregada"
                })
            }
        });
    }

});

// Actualizar reservacion
app.put('/reservacion/:idReservacion', function(req, res) {
    let idReservacion = parseInt(req.params.idReservacion);
    let idCliente = req.body.idCliente;
    let tipoHabitacion = req.body.tipoHabitacion;
    let fechaLlegada = req.body.fechaLlegada;
    let fechaSalida = req.body.fechaSalida;
    let numPersonas = req.body.numPersonas;
    let precio = req.body.precio;
    let status = req.body.status;

    var form_data = {
        idReservacion: idReservacion,
        idCliente: idCliente,
        tipoHabitacion: tipoHabitacion, 
        fechaLlegada: fechaLlegada, 
        fechaSalida: fechaSalida,
        numPersonas: numPersonas,
        precio: precio,
        status: status
    }
    if (idReservacion === '' || idCliente === '' || tipoHabitacion == ''  || fechaLlegada == '' 
        || fechaSalida == '' || numPersonas == '' || precio ==  ''  || status == ''
        || idReservacion === undefined || idCliente === undefined || tipoHabitacion == undefined  || fechaLlegada == undefined 
        || fechaSalida == undefined || numPersonas == undefined || precio ==  undefined  || status == undefined) {

        res.status(400).json({
            ok: false,
            titulo: "Campos Vacios",
            mensaje: 'Ingresa el cliente, tipo de habitación, fecha de llegada, fecha de salida y número de personas'
        })
    } else {
        dbConn.query('UPDATE reservaciones SET ? WHERE idReservacion = '+ idReservacion, form_data,function(err,rows)     {

            if(err) {
                res.json({
                    mensaje: "No se pudo actualizar la reservación en la base de datos"
                })
            } else {
                res.json({
                    mensaje: "Reservación actualizada"
                })
            }
        });
    }
});

// Eliminar habitacion
app.delete('/reservacion/:idReservacion', function(req, res) {
    let idReservacion = req.params.idReservacion;
    dbConn.query('DELETE FROM reservaciones WHERE idReservacion = '+ idReservacion, function(err,rows)     {

        if(err) {
            res.json({
                mensaje: "No se pudo eliminar la reservación en la base de datos"
            })
        } else {
            res.json({
                mensaje: "Reservación eliminada"
            })
        }
    });
});

// Recuperar cliente
app.post('/cliente', function(req, res) {
    let correo = req.body.correo;
    dbConn.query('SELECT idCliente FROM clientes WHERE correo = "' + correo + '"',function(err,rows)     {
 
        if(err) {
            console.log(err.message);
            res.json({
                mensaje: "Error al hacer la consulta"
            })
        } if (rows[0] == undefined){
            res.json({
                cliente: "No existe",
            })
        }else {
            //console.log(rows[0]);
            res.json({
                cliente: rows[0]
            })
        }
    });

});

app.get('/cliente/last', function(req, res) {
    let correo = req.body.correo;
    dbConn.query('SELECT idCliente FROM clientes ORDER BY idCliente DESC LIMIT 1',function(err,rows)     {
 
        if(err) {
            console.log(err.message);
            res.json({
                mensaje: "Error al hacer la consulta"
            })
        } if (rows[0] == undefined){
            res.json({
                cliente: "No existe",
            })
        }else {
            //console.log(rows[0]);
            res.json({
                cliente: rows[0].idCliente
            })
        }
    });

});

app.get('/clientes', function(req, res) {
    let correo = req.body.correo;
    dbConn.query('SELECT idCliente, nombre, apellido FROM clientes',function(err,rows)     {
 
        if(err) {
            console.log(err.message);
            res.json({
                mensaje: "Error al hacer la consulta"
            })
        } if (rows[0] == undefined){
            res.json({
                clientes: "No hay clientes",
            })
        }else {
            //console.log(rows[0]);
            res.json({
                clientes: rows
            })
        }
    });

});

app.listen(process.env.PORT, () => {
    console.log('Escuchando en el puerto', process.env.PORT);
})