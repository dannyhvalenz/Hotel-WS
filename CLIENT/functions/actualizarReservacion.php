<?php
    // Recuperar datos del form
    $fechaLlegada = $_POST['fechaLlegada'];
    $fechaSalida = $_POST['fechaSalida'];
    $idCliente = $_POST['cliente'];
    $tipoHabitacion = $_POST['tipoHabitacion'];
    $numAdultos = $_POST['numAdultos'];
    $numNinos = $_POST['numNinos'];
    $idReservacion = $_GET['reservacion'];
    // Limpiar cache
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://localhost:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("idReservacion" => $idReservacion,"fechaLlegada" => $fechaLlegada, "fechaSalida" => $fechaSalida, "idCliente" => $idCliente
            , "numNinos" => $numNinos, "numAdultos" => $numAdultos, "tipoHabitacion" => $tipoHabitacion);
    $response = $client->__soapCall('EditarReservacion', array($parametros));

    $exito = "Se ha actualizado la reservacion numero '".$idReservacion."' en el sistema";
    $error = "No se ha podido actualizar la reservacion numero '".$idReservacion."' en la base de datos";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../reservaciones.php");//falta mostrar el precio
    } elseif ($response->{'respuesta'} == $error){
        die(header("Location:../editarReservacion.php?errorreservacion=true&reason=error"));
    }
    
?>