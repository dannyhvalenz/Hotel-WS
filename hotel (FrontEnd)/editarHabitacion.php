<?php
     ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("numHabitacion" => $_GET['habitacion']);
    // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
    $response = $client->__soapCall('ConsultarHabitacion', array($parametros));
    //var_dump($response);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Habitacion</title>
    <!--ICONO-->
    <link rel="icon" type="image/png" href="img/favicon.png" />
    <<link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous">
    </script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="css/stylesDany.css">
</head>

<body>
    <!--NAVBAR-->
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <button class="btn btn-link btn-sm order-1 order-lg-0"
            id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
        <a class="navbar-brand" href="dashboard.php"><img src="img/hotel-logo3.svg" alt="Logo hotel"></a>
        
        <!--DROPDOWN USER-->
        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a><a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="login.html">Logout</a>
                    </div>
                </li>
            </ul>
        </form>

    </nav>
    <!--BARRA LATERAL-->
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Core</div>
                        <a class="nav-link" href="dashboard.php">
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
                            <div class="sb-nav-link-icon"><i class="fas fa-concierge-bell"></i></div>
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
                                    <?php $reasons = array("error" => "No se pudo actualizar la habitacion en el sistema"); 
							if ($_GET["errorhabitacion"]) 	
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
                    <h1 class="mt-4">Habitaciones</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="habitaciones.php">Habitaciones</a></li>
                        <li class="breadcrumb-item active">Registrar Habitación</li>
                    </ol>
                    <!--BARRA DE BUSQUEDA CLIENTE-->
                    <form class="validate-form needs-validation" novalidate action="functions/actualizarHabitacion.php"
                        method="POST">
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="numHabitacion">Número de Habitación</label>
                                    <input class="form-control py-4" id="numHabitacion" name="numHabitacion" type="number"
                                        placeholder="Ingresa el número de habitación" value="<?php echo $_GET['habitacion']?>" readonly="readonly" required />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="piso">Piso</label>
                                    <input class="form-control py-4" id="piso" name="piso" type="number"
                                        placeholder="Ingresa el piso en el que se encuentra" value="<?php echo $response->{'piso'};?>"  required />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="status">Status</label>
                                    <select class="selectpicker form-control" id="status" name="status" value="<?php echo $response->{'status'};?>"  required>
                                        <option value="Disponible" selected>Disponible</option>
                                        <option value="Ocupada">Ocupada</option>
                                        <?php 
                                            $tipos = array("Individual", "Doble", "JuniorDoble", "Suite");
                                            
                                            foreach ($status as $s){
                                                if ($s == $response->{'status'}){
                                                    switch ($s) {
                                                        case 'Disponible':
                                                            echo "<option value='".$s."' selected>Disponible</option>";
                                                            break;
                                                        case 'Ocupada':
                                                            echo "<option value='".$s."' selected>Ocupada</option>";
                                                            break;
                                                    }
                                                } else {
                                                    switch ($s) {
                                                        case 'Disponible':
                                                            echo "<option value='".$s."'>Disponible</option>";
                                                            break;
                                                        case 'Ocupada':
                                                            echo "<option value='".$s."'>Ocupada</option>";
                                                            break;
                                                    }
                                                }
                                            }
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                <label class="small mb-1" for="tipoHabitacion">Tipo de Habitacion</label>
                                    <select class="selectpicker form-control" id="tipoHabitacion" name="tipoHabitacion" required>
                                        <?php 
                                            $tipos = array("Individual", "Doble", "JuniorDoble", "Suite");
                                            
                                            foreach ($tipos as $tipo){
                                                if ($tipo == $response->{'tipoHabitacion'}){
                                                    switch ($tipo) {
                                                        case 'Individual':
                                                            echo "<option value='".$tipo."' selected>Sencilla</option>";
                                                            break;
                                                        case 'Doble':
                                                            echo "<option value='".$tipo."' selected>Doble</option>";
                                                            break;
                                                        case 'JuniorDoble':
                                                            echo "<option value='".$tipo."' selected>Junior Doble</option>";
                                                            break;
                                                        case 'Suite':
                                                            echo "<option value='".$tipo."' selected>Suite</option>";
                                                            break;
                                                    }
                                                } else {
                                                    switch ($tipo) {
                                                        case 'Individual':
                                                            echo "<option value='".$tipo."'>Sencilla</option>";
                                                            break;
                                                        case 'Doble':
                                                            echo "<option value='".$tipo."'>Doble</option>";
                                                            break;
                                                        case 'JuniorDoble':
                                                            echo "<option value='".$tipo."'>Junior Doble</option>";
                                                            break;
                                                        case 'Suite':
                                                            echo "<option value='".$tipo."'>Suite</option>";
                                                            break;
                                                    }
                                                }
                                            }
                                        ?>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="numCamas">Número de camas</label>
                                    <input class="form-control py-4" id="numCamas" name="numCamas" type="number"
                                        placeholder="Ingresa el número de camas" value="<?php echo $response->{'numCamas'}?>" readonly="readonly" required/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="cupoPersonas">Cupo máximo de personas</label>
                                    <input class="form-control py-4" id="cupoPersonas" name="cupoPersonas" type="number"
                                        placeholder="Ingresa cupo de personas en la habitacion" value="<?php echo $response->{'cupoPersonas'}?>" readonly="readonly" required />
                                </div>
                            </div>

                            
                        </div>
                        <div class="form-row d-flex flex-row-reverse">
                            <div class="">
                                <a href="habitaciones.php" class="btn btn-danger">Cancelar</a>
                                <button type="submit" class="btn btn-success">Actualizar Habitación</button>
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
    <script src="js/bootstrap-select.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
    <script>
        var url = window.location.href;
		if(url.indexOf('?errorhabitacion=true&reason=error') != -1 || url.indexOf('?errorhabitacion=true&reason=duplicado') != -1) {
            $('#myModal').modal('show');
		} else {
			$('#myModal').modal('hide');
        }
    </script>
     <script>
    var camas = 0;
    
    document.getElementById('tipoHabitacion').onchange = function() {setNumCamas()};
                                          
    function setNumCamas() {
        
        switch (document.getElementById('tipoHabitacion').value) {
            case "Individual":
                document.getElementById('numCamas').value = "1";
                document.getElementById('cupoPersonas').value = "2";
                break;
        
            case "Doble":
                document.getElementById('numCamas').value = "2";
                document.getElementById('cupoPersonas').value = "4";
                break;
            case "JuniorDoble":
                document.getElementById('numCamas').value = "3";
                document.getElementById('cupoPersonas').value = "6";
                break;
    
            case "Suite":
                document.getElementById('numCamas').value = "4";
                document.getElementById('cupoPersonas').value = "8";
            break;

        }
        
    }
    
    </script>
</body>

</html>