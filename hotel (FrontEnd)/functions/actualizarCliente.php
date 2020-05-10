<?php
    // Recuperar datos del form
    $idCliente = $_GET['cliente'];
    $nombre = $_POST['nombre'];
    $apellido = $_POST['apellido'];
    $telefono = $_POST['telefono'];
    $correo = $_POST['correo'];
    $formaPago = $_POST['formaPago'];
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://localhost:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("idCliente" => $idCliente,"nombre" => $nombre, "apellido" => $apellido, "telefono" => $telefono
            , "correo" => $correo, "formaPago" => $formaPago);
    $response = $client->__soapCall('EditarCliente', array($parametros));
    print "<h1>".$response->{'respuesta'}."</h1>";

    $exito = "Se ha actualizado al cliente " .$nombre. " " .$apellido. " en el sistema";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../clientes.php");
    } else {
        die(header("Location:../editarCliente.php?errorcliente=true&reason=fallido"));
    }
    
?>