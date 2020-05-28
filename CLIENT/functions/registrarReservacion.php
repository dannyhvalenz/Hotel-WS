<?php
    // Recuperar datos del form
    $fechaLlegada = $_POST['fechaLlegada'];
    $fechaSalida = $_POST['fechaSalida'];
    $idCliente = $_POST['cliente'];
    $tipoHabitacion = $_POST['tipoHabitacion'];
    $numAdultos = $_POST['numAdultos'];
    $numNinos = $_POST['numNinos'];
    // Limpiar cache
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://localhost:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("fechaLlegada" => $fechaLlegada, "fechaSalida" => $fechaSalida, "idCliente" => $idCliente
            , "numNinos" => $numNinos, "numAdultos" => $numAdultos, "tipoHabitacion" => $tipoHabitacion);
    $response = $client->__soapCall('HacerReservacion', array($parametros));

    $exito = "Se ha registrado la reservacion en el sistema";
    $error = "No se ha podido registrar la reservacion en la base de datos";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../reservaciones.php");//falta mostrar el precio
    } elseif ($response->{'respuesta'} == $duplicado) {
        die(header("Location:../nuevaReservacion.php?errorreservacion=true&reason=duplicado"));
    } elseif ($response->{'respuesta'} == $error){
        die(header("Location:../nuevaReservacion.php?errorreservacion=true&reason=error"));
    }
    
?>