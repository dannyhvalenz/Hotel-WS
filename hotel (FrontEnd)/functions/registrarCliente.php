<?php
    // Recuperar datos del form
    $nombre = $_POST['nombre'];
    $apellido = $_POST['apellido'];
    $telefono = $_POST['telefono'];
    $correo = $_POST['correo'];
    $formaPago = $_POST['formaPago'];
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("nombre" => $nombre, "apellido" => $apellido, "telefono" => $telefono
            , "correo" => $correo, "formaPago" => $formaPago);
    $response = $client->__soapCall('RegistrarCliente', array($parametros));
    print "<h1>".$response->{'respuesta'}."</h1>";

    $exito = "Se ha registrado al cliente " .$nombre. " " .$apellido. " en el sistema";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../clientes.php");
    } else {
        die(header("Location:../nuevoCliente.php?errorcliente=true&reason=fallido"));
    }
    
?>