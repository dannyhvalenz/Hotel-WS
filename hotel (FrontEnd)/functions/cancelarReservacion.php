<?php
    // Recuperar datos del form
    $reservacion = $_GET['reservacion'];
    // Limpiar cache
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://localhost:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("idReservacion" => $reservacion);
    $response = $client->__soapCall('CancelarReservacion', array($parametros));
    print "<h1>".$response->{'respuesta'}."</h1>";

    $exito = "Se ha cancelado la reservacion del sistema";
    $error = "No se ha podido cancelar la reservacion de la base de datos";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../reservaciones.php");
    } else if ($response->{'respuesta'} == $error){
        die(header("Location:../reservaciones.php?errorreservacion=true&reason=fallido"));
    }
    
?>