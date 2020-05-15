<?php
    // Recuperar datos del form
    $numHabitacion = $_GET['habitacion'];
    // Limpiar cache
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("numHabitacion" => $numHabitacion);
    $response = $client->__soapCall('EliminarHabitacion', array($parametros));
    //print "<h1>".$response->{'respuesta'}."</h1>";

    $exito = "Se ha eliminado la habitacion del sistema";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../habitaciones.php");
    } else {
        die(header("Location:../habitaciones.php?errorhabitacion=true&reason=fallido"));
    }
    
?>