<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>

    <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body>
    <!--NAVBAR-->
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="index.html">Hotel</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button
        >
        <ul class="navbar-nav ml-auto ml-md-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
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
                        <a class="nav-link" href="index.html"
                            ><div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Dashboard</a
                        >
                        <div class="sb-sidenav-menu-heading">Gestionar</div>
                        <a href="clientes.php" class="nav-link" 
                            ><div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                            Clientes
                        </a>
                        <a class="nav-link" href="habitaciones.php"
                            ><div class="sb-nav-link-icon"><i class="fas fa-bed"></i></div>
                            Habitaciones
                        </a>
                        <a class="nav-link" href="reservaciones.php"
                            ><div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                            Reservaciones
                        </a>
                        <a class="nav-link" href="estancias.php"
                            ><div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
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
                    <h1 class="mt-4">Reservaciones</h1>
                    <!--BARRA DE BUSQUEDA CLIENTE-->
                    
                    <div class="input-group mb-3">
                            <a href="nuevaReservacion.php" class="btn btn-success">
                                <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                Nueva reservación
                            </a>
                            <input type="text" class="form-control" placeholder="Buscar reservacion" aria-label="Buscar reservacion" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <span class="input-group-text" id="basic-addon2"><i class="fas fa-search"></i></span>
                            </div>
                    </div>

                        
                
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Num Reservacion</th>
                                    <th>Fecha de Llegada</th>
                                    <th>Fecha de Salida</th>
                                    <th># de Adultos</th>
                                    <th># de Niños</th>
                                    <th>Tipo Habitacion</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Num Reservacion</th>
                                    <th>Fecha de Llegada</th>
                                    <th>Fecha de Salida</th>
                                    <th># de Adultos</th>
                                    <th># de Niños</th>
                                    <th>Tipo Habitacion</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <?php
                                    // Instancua de la clase Soap Client
                                    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
                                    // definicion y paso de parametros
                                    $parametros = array("idReservacion" => 2);
                                    $response = $client->__soapCall('ConsultarReservacion', array($parametros));
                                    print "<td>".$response->{'idReservacion'}."</td>";
                                    print "<td>".$response->{'fechaLlegada'}."</td>";
                                    print "<td>".$response->{'fechaSalida'}."</td>";
                                    print "<td>".$response->{'numAdultos'}."</td>";
                                    print "<td>".$response->{'numNinos'}."</td>";
                                    print "<td>".$response->{'tipoHabitacion'}."</td>";
                                ?>
                                
                            </tbody>
                        </table>
                    </div>
                        
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
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>

</body>
</html>