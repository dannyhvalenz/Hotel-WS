<?php 
    include('nusoap/lib/nusoap.php');
    $soapClient = new nusoap_client('http://54.162.225.248:8080/hotel.wsdl','wsdl'); 
    $data = json_decode(file_get_contents('php://input'), true);
    
    ini_set("soap.wsdl_cache_enabled", "0");
    error_reporting(E_ALL);
    ini_set('error_reporting', E_ALL);
 

    
    switch ($data['metodo']){
        // CLIENTES
        case 0:
            getClientes();
        break;
        case 1:
            consultarCliente($data['idCliente']);
        break;
        case 2:
            registrarCliente($data['json']);
        break;
        case 3:
            actualizarCliente($data['json']);
        break;
        case 4:
            eliminarCliente($data['idCliente']);
        break;
    }

    // CLIENTES
    // lista de clientes
    function getClientes(){
        global $soapClient;
        $response = $soapClient->call("ObtenerListaClientes", array());
        $res =  $response['cliente'];
        //echo "<script>console.log(".$res.")</script>";
        //echo "<script>console.log(".$response.")</script>";
        //$dataResponse = array ('clientes' => $res);
        if ($res != 'error'){
            $dataResponse = array ('respuesta' => 'exito', 'clientes' => $res);
        } else if ($res == 'error'){
            $dataResponse = array ('respuesta' => 'error');
        }
		header('Content-type: application/json; charset=utf-8');
		echo json_encode($dataResponse);
    }
    // consultar cliente
    function consultarCliente($id){
        global $soapClient;
        $parametros = array("idCliente" => $id);
        $response = $soapClient->call('ConsultarCliente', array($parametros));
        if ($response != null){
            $cliente = array("idCliente" => $id, "nombre" => $response['nombre'], "apellido" => $response['apellido'], "telefono" => $response['telefono'], "correo" => $response['correo'], "formaPago" => $response['formaPago']);
            $dataResponse = array ('respuesta' => 'exito', 'cliente' => $cliente);
        } else {
            $dataResponse = array ('respuesta' => 'error');
        }
        header('Content-type: application/json; charset=utf-8');
		echo json_encode($dataResponse);
    }
    // registrar Cliente
    function registrarCliente($data){
        global $soapClient;
        $parametros = array('nombre' => $data['nombre'] ,'apellido' => $data['apellido'], 'correo' => $data['correo'], 'telefono' =>  $data['telefono'], 'formaPago' =>  $data['formaPago']);
        $response = $soapClient->call("RegistrarCliente", array($parametros));
        $res =  $response['respuesta'];
         
        
        if ($res == "Exito"){
            $dataResponse = array ('mensaje' => 'exito');
        } else if ($res == "Error"){
            $dataResponse = array ('mensaje' => 'error');
        }else if ($res == "Duplicado"){
            $dataResponse = array ('mensaje' => 'duplicado');
        }
       
        header('Content-type: application/json; charset=utf-8');
        echo json_encode($dataResponse);
        
    }
    // actualizar cliente
    function actualizarCliente($data){
        global $soapClient;
        $json = json_decode($data);
        $parametros = array('idCliente' => $data['idCliente'],'nombre' => $data['nombre'] ,'apellido' => $data['apellido'], 'correo' => $data['correo'], 'telefono' =>  $data['telefono'], 'formaPago' =>  $data['formaPago']);
        $response = $soapClient->call("EditarCliente", array($parametros));
        $res =  $response['respuesta'];
        
        //echo "<script>console.log(".$data.")</script>";
        if ($res == "Exito"){
            $dataResponse = array ('mensaje' => 'exito');
        } else if ($res == "Error"){
            $dataResponse = array ('mensaje' => 'error');
        }
        
		header('Content-type: application/json; charset=utf-8');
		echo json_encode($dataResponse);
    }
    // eliminar cliente
    function eliminarCliente($id){
        global $soapClient;
        $parametros = array("idCliente" => $id);
        $response = $soapClient->call('EliminarCliente', array($parametros));
        $res =  $response['respuesta'];
        //echo "<script>console.log(".$res.")</script>";
        if ($res == "Exito"){
            $dataResponse = array ('mensaje' => 'exito');
        } else if ($res == "Error"){
            $dataResponse = array ('mensaje' => 'error');
        }
        header('Content-type: application/json; charset=utf-8');
		echo json_encode($dataResponse);
    }
?>