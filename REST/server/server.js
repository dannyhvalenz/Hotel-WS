require('./config/config');
const express = require('express')
const bodyParser = require('body-parser')
const app = express();
var dbConn  = require('../lib/db');

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())

app.get('/', function(req, res) {
    res.json('Hello World')
});

/* ----------------- HABITACIONES ----------------- */
// Listar todas las habitaciones
app.get('/habitaciones', function(req, res) {

    dbConn.query('SELECT * FROM habitaciones',function(err,rows)     {
 
        if(err) {
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
                mensaje: "No se encontraró la habitación"
            })
        } else {
            res.json({
                habitacion: rows[0]
            })
        }
    });

});

// Obtener cuantas habitaciones hay por tipo de habitacion 
app.get('/hotelDany', function(req, res) {

    dbConn.query("SELECT tipoHabitacion FROM habitaciones WHERE status='Disponible'",function(err,rows)     {
 
        if(err) {
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

    let numHabitacion = req.query.numHabitacion;
    let piso = req.query.piso;
    let cupoPersonas = req.query.cupoPersonas;
    let tipoHabitacion = req.query.tipoHabitacion;
    let numCamas = req.query.numCamas;
    let status = req.query.status;
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
    let piso = req.query.piso;
    let cupoPersonas = req.query.cupoPersonas;
    let tipoHabitacion = req.query.tipoHabitacion;
    let numCamas = req.query.numCamas;
    let status = req.query.status;
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

app.listen(process.env.PORT, () => {
    console.log('Escuchando en el puerto', process.env.PORT);
})