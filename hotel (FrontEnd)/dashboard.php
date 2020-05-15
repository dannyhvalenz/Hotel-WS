<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - Hotel</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous">
    </script>
</head>

<body class="sb-nav-fixed">
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
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Dashboard</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-primary text-white mb-4">
                                <div class="card-body">
                                    <label><b>Clientes registrados</b></label>
                                    <br>
                                    <label>
                                        <?php 
                                                ini_set("soap.wsdl_cache_enabled", "0");
                                                // Instancua de la clase Soap Client
                                                $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
                                                // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
                                                $response = $client->__soapCall('ObtenerListaClientes', array());
                                                
                                                $array = json_decode(json_encode($response), True);
            
                                                $numClientes=0;
                                               
                                                foreach ($response->{'cliente'} as $c) {
                                                    $numClientes += 1;
                                                }

                                                print $numClientes;
                                                
                                            ?>
                                    </label>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link" href="clientes.php">Más detalles</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-warning text-white mb-4">
                                <div class="card-body">
                                    
                                        <?php 
                                                ini_set("soap.wsdl_cache_enabled", "0");
                                                // Instancua de la clase Soap Client
                                                $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
                                                // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
                                                $response = $client->__soapCall('ObtenerListaEstancias', array());
                                                
                                                $array = json_decode(json_encode($response), True);
                                                
                                                setlocale(LC_ALL,"es_ES");
                                                $date_now = date('Y-m-d');
                                                $mes = strftime('%B', strtotime($date_now));
                                                
                                                print "<label><b>Estancias en ".$mes."</b></label>";
                                                print "<br>";
                                                $numEstancia = 0;
                                               
                                                foreach ($response->{'estancia'} as $e) {
                                                    if (date("m",strtotime($e->{'fechaCheckIn'})) == date("m") || date("m",strtotime($e->{'fechaCheckOut'})) == date("m")){
                                                        $numEstancia += 1;
                                                    }
                                                    
                                                }
                                                print "<label>".$numEstancia."</label>";
                                                
                                                
                                            ?>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link" href="estancias.php">Más detalles</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-success text-white mb-4">
                                <div class="card-body">
                                    
                                        <?php 
                                                ini_set("soap.wsdl_cache_enabled", "0");
                                                // Instancua de la clase Soap Client
                                                $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
                                                // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
                                                $response = $client->__soapCall('ObtenerListaReservaciones', array());
                                                
                                                //$array = json_decode(json_encode($response), True);
                                                
                                                setlocale(LC_ALL,"es_ES");
                                                $date_now = date('Y-m-d');
                                                $mes = strftime('%B', strtotime($date_now));
                                                
                                                print "<label><b>Reservaciones de ".$mes."</b></label>";
                                                print "<br>";

                                                $numReservaciones = 0;
                                               
                                                foreach ($response->{'reservacion'} as $r) {
                                                    if (date("m",strtotime($r->{'fechaLlegada'})) == date("m") || date("m",strtotime($r->{'fechaSalida'})) == date("m")){
                                                        $numReservaciones += 1;
                                                    }
                                                    
                                                }

                                                print "<label>".$numReservaciones."</label>";
                                                
                                            ?>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link" href="reservaciones.php">Más detalles</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-danger text-white mb-4">
                                <div class="card-body">
                                    <label><b>Habitaciones ocupadas</b></label>
                                    <br>
                                    <label>
                                        <?php 
                                                ini_set("soap.wsdl_cache_enabled", "0");
                                                // Instancua de la clase Soap Client
                                                $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
                                                // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
                                                $response = $client->__soapCall('ObtenerListaHabitaciones', array());
                                                
                                                //$array = json_decode(json_encode($response), True);
            
                                                //var_dump(response);

                                                $numHabitaciones = 0;
                                               
                                                foreach ($response->{'habitacion'} as $h) {
                                                    if ($h->{'status'} == "Ocupada"){
                                                        $numHabitaciones += 1;
                                                    }
                                                }

                                                print $numHabitaciones;
                                                
                                            ?>
                                    </label>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link" href="habitaciones.php">Más detalles</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header"><i class="fas fa-chart-area mr-1"></i>Estancias</div>
                                <div class="card-body"><canvas id="myAreaChartEstancias" width="100%"
                                        height="40"></canvas></div>
                                <div class="card-footer small text-muted">Actualizado el
                                    <?php 
                                            setlocale(LC_ALL,"es_ES");
                                            $string = date("yy-m-d");
                                            $date = DateTime::createFromFormat("yy-m-d", $string);
                                            echo strftime("%A",$date->getTimestamp());
                                        ?>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header"><i class="fas fa-book-open mr-1"></i>Reservaciones</div>
                                <div class="card-body"><canvas id="myAreaChartReservaciones" width="100%"
                                        height="40"></canvas></div>
                                <div class="card-footer small text-muted">Actualizado el
                                    <?php 
                                            setlocale(LC_ALL,"es_ES");
                                            $string = date("yy-m-d");
                                            $date = DateTime::createFromFormat("yy-m-d", $string);
                                            echo strftime("%A",$date->getTimestamp());
                                        ?>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header"><i class="fas fa-chart-bar mr-1"></i>Bar Chart Estancias</div>
                                <div class="card-body"><canvas id="EstanciasBar" width="100%" height="50"></canvas></div>
                                <div class="card-footer small text-muted">Actualizado el
                                    <?php 
                                            setlocale(LC_ALL,"es_ES");
                                            $string = date("yy-m-d");
                                            $date = DateTime::createFromFormat("yy-m-d", $string);
                                            echo strftime("%A",$date->getTimestamp());
                                        ?>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header"><i class="fas fa-chart-bar mr-1"></i>Bar Chart Reservaciones</div>
                                <div class="card-body"><canvas id="ReservacionesBar" width="100%" height="50"></canvas></div>
                                <div class="card-footer small text-muted">Actualizado el
                                    <?php 
                                            setlocale(LC_ALL,"es_ES");
                                            $string = date("yy-m-d");
                                            $date = DateTime::createFromFormat("yy-m-d", $string);
                                            echo strftime("%A",$date->getTimestamp());
                                        ?>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header"><i class="fas fa-chart-pie mr-1"></i>Estancias</div>
                                <div class="card-body"><canvas id="EstanciasPie" width="100%" height="50"></canvas></div>
                                <div class="card-footer small text-muted">Actualizado el
                                    <?php 
                                            setlocale(LC_ALL,"es_ES");
                                            $string = date("yy-m-d");
                                            $date = DateTime::createFromFormat("yy-m-d", $string);
                                            echo strftime("%A",$date->getTimestamp());
                                        ?>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header"><i class="fas fa-chart-pie mr-1"></i>Reservaciones</div>
                                <div class="card-body"><canvas id="ReservacionesPie" width="100%" height="50"></canvas></div>
                                <div class="card-footer small text-muted">Actualizado el
                                    <?php 
                                            setlocale(LC_ALL,"es_ES");
                                            $string = date("yy-m-d");
                                            $date = DateTime::createFromFormat("yy-m-d", $string);
                                            echo strftime("%A",$date->getTimestamp());
                                        ?>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2019</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
    </script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/datatables-demo.js"></script>
    <script src="js/chart-reservacion.php"></script>
    <script src="js/chart-estancias.php"></script>
    <script src="js/pie-reservaciones.php"></script>
    <script src="js/pie-estancias.php"></script>
    <script src="js/bar-reservaciones.php"></script>
    <script src="js/bar-estancias.php"></script>
</body>

</html>