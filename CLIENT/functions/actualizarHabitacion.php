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
    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("numHabitacion" => $numHabitacion, "piso" => $piso, "numCamas" => $numCamas
            , "cupoPersonas" => $cupoPersonas, "tipoHabitacion" => $tipoHabitacion, "status" => $status);
    $response = $client->__soapCall('EditarHabitacion', array($parametros));

    $exito = "Se ha actualizado la habitacion ".$numHabitacion." en el sistema";
    $error = "No se ha podido actualizar la habitacion al sistema";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../habitaciones.php");
    } elseif ($response->{'respuesta'} == $error){
        die(header("Location:../editarHabitacion.php?errorcliente=true&reason=error"));
    }
    
?>