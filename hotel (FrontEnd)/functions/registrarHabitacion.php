<?php
    // Recuperar datos del form
    $numHabitacion = $_POST['numHabitacion'];
    $piso = $_POST['piso'];
    $cupoPersonas = $_POST['cupoPersonas'];
    $status = $_POST['status'];
    $tipoHabitacion = $_POST['tipoHabitacion'];
    $numCamas = $_POST['numCamas'];
    // Limpiar cache
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://localhost:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("numHabitacion" => $numHabitacion, "piso" => $piso, "numCamas" => $numCamas
            , "cupoPersonas" => $cupoPersonas, "tipoHabitacion" => $tipoHabitacion, "status" => $status);
    $response = $client->__soapCall('AgregarHabitacion', array($parametros));

    $exito = "Se ha agregado la habitacion " .$numHabitacion. " al sistema";
    $error = "No se ha podido agregar la habitacion al sistema";
    $duplicado = "Ya existe una habitacion con ese numero de habitacion en el sistema";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../habitaciones.php");
    } elseif ($response->{'respuesta'} == $duplicado) {
        die(header("Location:../nuevaHabitacion.php?errorhabitacion=true&reason=duplicado"));
    } elseif ($response->{'respuesta'} == $error){
        die(header("Location:../nuevaHabitacion.php?errorhabitacion=true&reason=error"));
    }
    
?>