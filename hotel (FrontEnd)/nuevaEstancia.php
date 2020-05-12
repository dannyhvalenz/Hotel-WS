<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva Estancia</title>

    <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous">
    </script>
</head>

<body>
    <!--NAVBAR-->
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="index.html">Hotel</a><button class="btn btn-link btn-sm order-1 order-lg-0"
            id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
        <ul class="navbar-nav ml-auto ml-md-0">
            <li class="nav-item dropdown" style="left: auto !important; right: 0px;">
                <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#">Settings</a><a class="dropdown-item" href="#">Activity Log</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="login.html">Logout</a>
                </div>
            </li>
        </ul>
    </nav>
    <!--BARRA LATERAL-->
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Core</div>
                        <a class="nav-link" href="index.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Dashboard
                        </a>
                        <div class="sb-sidenav-menu-heading">Gestionar</div>
                        <a href="clientes.php" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                            Clientes
                        </a>
                        <a class="nav-link" href="habitaciones.php">
                            <div class="sb-nav-link-icon"><i class="fas fa-bed"></i></div>
                            Habitaciones
                        </a>
                        <a class="nav-link" href="reservaciones.php">
                            <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                            Reservaciones
                        </a>
                        <a class="nav-link" href="estancias.php">
                            <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                            Estancias
                        </a>
                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Iniciaste Sesion como:</div>
                    Start Bootstrap
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <mensaje>
                <!--MODAL MENSAJES DE ERROR-->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Error al registrar</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>

                            </div>
                            <div class="modal-body">
                                <p>
                                    <?php $reasons = array("error" => "No se pudo registrar la estancia en el sistema", 
                                        "duplicado" => "Ya existe una estancia con esos datos"); 
							if ($_GET["errorestancia"]) 	
								echo "<span'>". $reasons[$_GET["reason"]] . "</span>"; 
						        ?>
                                </p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </mensaje>
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Estancias</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="estancias.php">Estancias</a></li>
                        <li class="breadcrumb-item active">Registrar Estancia</li>
                    </ol>
                    <!--BARRA DE BUSQUEDA CLIENTE-->
                    <form class="validate-form needs-validation" novalidate action="functions/registrarEstancia.php"
                        method="POST">
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="fechaCheckIn">Fecha Check-In</label>
                                    <input class="form-control" type="date" value="<?php echo date('yy-m-d'); ?>"
                                        id="fechaCheckIn" name="fechaCheckIn" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="fechaCheckOut">Fecha Check-Out</label>
                                    <input class="form-control" type="date" value="<?php $date = date('Y-m-d', strtotime("+1 day")); echo $date;?>"
                                        id="fechaCheckOut" name="fechaCheckOut" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="numAdultos">Numero de Adultos</label>
                                    <input class="form-control py-4" id="numAdultos" name="numAdultos" type="number"
                                         min="1" max="8" value="1" placeholder="Ingresa numero de adultos"
                                        required /> <!--8 personas si no hay niños-->
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="numNinos">Numero de Niños</label>
                                    <input class="form-control py-4" id="numNinos" name="numNinos" type="number" 
                                         min="0" max="3" value="0" placeholder="Ingresa el numero de niños"
                                        required />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="cliente">Cliente</label>
                                    <select class="custom-select" id="cliente" name="cliente" required>
                                    <?php 
                                        
                                            // Instancua de la clase Soap Client
                                            $client = new SoapClient("http://localhost:8080/hotel.wsdl");
                                            // definicion y paso de parametros
                                            $parametros = array();
                                            // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el localhost
                                            $response = $client->__soapCall('ObtenerListaClientes', array($parametros));
                                            
                                            $array = json_decode(json_encode($response), True);

                                            echo "<pre>".print_r($response, true)."</pre>";

                                            if(isset($response->records)){
                                                foreach ($response->cliente as $c) {
                                                    // clientes
                                                    echo "<option value='".$c->idCliente."' >".$c->nombre." ".$c->apellido."</option>";
                                                            
                                                }
                                            } 
                                          
                                        ?>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="tipoHabitacion">Tipo de Habitacion</label>
                                    <select class="custom-select" id="tipoHabitacion" name="tipoHabitacion" required>
                                        <option value="Individual">Sencilla</option><!--2 persona = 900-->
                                        <option value="Doble">Doble</option> <!--4 persona = 1300-->
                                        <option value="Doble">Junior Doble</option> <!--6 persona = 1700-->
                                        <option value="Familiar">Suite</option> <!--8 personas = 2100-->
                                        <?php 
                                        
                                            
                                           
                                            /*
                                            $dom = new DOMDocument();
                                            $dom->loadHTML($this);
                                            $xpath = new DOMXpath($dom);
                                            $adultos = $xpath->query("//input[@id='$numAdultos']")->item(0)->getAttribute('value');
                                            $ninos = $xpath->query("//input[@id='$numNinos']")->item(0)->getAttribute('value');

                                            $num = $adultos + $ninos;
                                            if ($num <= 2){
                                                echo "<option value='Individual' selected>Sencilla</option>"; // 2 personas
                                                echo "<option value='Doble'>Doble</option>"; // 4 personas
                                                echo "<option value='Junior'>Junior</option>"; // 6 personas
                                                echo "<option value='Suite'>Suite</option>"; // 8 personas
                                            } else if ($num <= 4){
                                                echo "<option value='Individual' disabled>Sencilla</option>"; // 2 personas
                                                echo "<option value='Doble' selected>Doble</option>"; // 4 personas
                                                echo "<option value='Junior'>Junior</option>"; // 6 personas
                                                echo "<option value='Suite'>Suite</option>"; // 8 personas
                                            } else if ($num <= 6){
                                                echo "<option value='Individual' disabled>Sencilla</option>"; // 2 personas
                                                echo "<option value='Doble' disabled>Doble</option>"; // 4 personas
                                                echo "<option value='Junior' selected>Junior</option>"; // 6 personas
                                                echo "<option value='Suite'>Suite</option>"; // 8 personas
                                            } else if ($num <= 8){
                                                echo "<option value='Individual' disabled>Sencilla</option>"; // 2 personas
                                                echo "<option value='Doble' disabled>Doble</option>"; // 4 personas
                                                echo "<option value='Junior' disabled>Junior</option>"; // 6 personas
                                                echo "<option value='Suite' selected>Suite</option>"; // 8 personas
                                            }
                                            */
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="numHabitacion"> Numero de Habitacion</label>
                                    <select class="custom-select" id="numHabitacion" name="numHabitacion" required>
                                        <?php 
                                        /*
                                            // Instancua de la clase Soap Client
                                            $client = new SoapClient("http://localhost:8080/hotel.wsdl");
                                            // definicion y paso de parametros
                                            $parametros = array();
                                            // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el localhost
                                            $response = $client->__soapCall('ObtenerListaHabitaciones', array($parametros));
                                            
                                            $array = json_decode(json_encode($response), True);

                                            //echo "<pre>".print_r($response, true)."</pre>";

                                            if(isset($response->records)){
                                                foreach ($response->cliente as $habitacion) {
                                                    // numHabitacion
                                                    echo "<option value='".$habitacion->numHabitacion."' selected>".$habitacion->numHabitacion."</option>";
                                                            
                                                }
                                            } 
                                          */  
                                        ?>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-row d-flex flex-row-reverse">
                            <div class="">
                                <a href="clientes.php" class="btn btn-danger">Cancelar</a>
                                <button type="submit" class="btn btn-success">Check In</button>
                            </div>
                        </div>
                    </form>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">API Hotel Tecnologias de Integracion de Soluciones</div>

                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
    </script>
    <script src="js/validarcampos.js"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
    <script>
    var url = window.location.href;
    if (url.indexOf('?errorcliente=true&reason=error') != -1 || url.indexOf('?errorcliente=true&reason=duplicado') != -
        1) {
        $('#myModal').modal('show');
    } else {
        $('#myModal').modal('hide');
    }
    </script>
        
    <script>
    var cupo;
    var numAdultos;
    var numNinos;
    document.getElementById('numAdultos').onchange = function() {getAdultos()};
    document.getElementById('numNinos').onchange = function() {getNinos()};
                                          
    function getAdultos() {
        numAdultos = document.getElementById('numAdultos').value;
        cupo = numAdultos + numNinos;
        console.log("Cupo" + cupo);
    }

    function getNinos() {
        numNinos = document.getElementById('numNinos').value;
        cupo = numAdultos + numNinos;
        console.log("Cupo" + cupo);
    }

    
    </script>
</body>

</html>