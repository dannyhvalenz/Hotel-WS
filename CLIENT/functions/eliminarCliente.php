<?php
    // Recuperar datos del form
    $idCliente = $_GET['cliente'];
    // Limpiar cache
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("idCliente" => $idCliente);
    $response = $client->__soapCall('EliminarCliente', array($parametros));
    //print "<h1>".$response->{'respuesta'}."</h1>";

    $exito = "Se ha eliminado al cliente del sistema";
    if ($response->{'respuesta'} == $exito){
        header("Location: ../clientes.html");
    } else {
        die(header("Location:../editarCliente.php?errorcliente=true&reason=fallido"));
    }
    
?>