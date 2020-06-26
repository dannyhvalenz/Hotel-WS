<?php
    ini_set("soap.wsdl_cache_enabled", "0");
    // Instancua de la clase Soap Client
    $client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
    // definicion y paso de parametros
    $parametros = array("idCliente" => $_GET['cliente']);
    // con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
    $response = $client->__soapCall('ConsultarCliente', array($parametros));
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <!--ICONO-->
    <link rel="icon" type="image/png" href="img/favicon.png" />
    <link href="css/styles.css" rel="stylesheet" />
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
        <a class="navbar-brand" href="reservaciones.html"><img src="img/hotel-logo3.svg" alt="Logo hotel"></a>
        
        <!--DROPDOWN USER-->
        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a><a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Logout</a>
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
                        <a class="nav-link" href="reservaciones.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Dashboard
                        </a>
                        <div class="sb-sidenav-menu-heading">Gestionar</div>
                        <a href="clientes.html" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                            Clientes
                        </a>
                        <a class="nav-link" href="habitaciones.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-bed"></i></div>
                            Habitaciones
                        </a>
                        <a class="nav-link" href="reservaciones.html">
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
                    <h1 class="mt-4">Clientes</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="clientes.html">Clientes</a></li>
                        <li class="breadcrumb-item active">Registrar Cliente</li>
                    </ol>
                    <!--BARRA DE BUSQUEDA CLIENTE-->
                    <form class="validate-form needs-validation" novalidate action="functions/actualizarCliente.php?cliente=<?php echo $_GET['cliente'] ?>"
                        method="POST">
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="nombre">Nombre</label>
                                    <input class="form-control py-4" id="nombre" name="nombre" type="text"
                                        placeholder="Ingresa el nombre" value="<?php echo $response->{'nombre'}?>" required/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="apellido">Apellido</label>
                                    <input class="form-control py-4" id="apellido" name="apellido" type="text"
                                        placeholder="Ingresa el apellido" value="<?php echo $response->{'apellido'}?>" required />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="correo">Correo</label>
                                    <input class="form-control py-4" id="correo" name="correo" type="email"
                                        aria-describedby="emailHelp" placeholder="Ingresa el correo electronico"
                                        value="<?php echo $response->{'correo'}?>" required />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="telefono">Teléfono</label>
                                    <input class="form-control py-4" id="telefono" name="telefono" type="number"
                                        placeholder="Ingresa el telefono" min="1000000000" max="9999999999" 
                                        value="<?php echo $response->{'telefono'}?>" required />
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1" for="formaPago">Forma de Pago</label>
                                    <select class="selectpicker form-control" id="formaPago" name="formaPago" required>
                                        <?php 
                                            $formasPago = array("Credito", "Debito", "Efectivo");
                                            
                                            foreach ($formasPago as $forma){
                                                if ($forma == $response->{'formaPago'}){
                                                    switch ($forma) {
                                                        case 'Credito':
                                                            echo "<option value='".$forma."' selected>Tarjeta de Crédito</option>";
                                                            break;
                                                        case 'Debito':
                                                            echo "<option value='".$forma."' selected>Tarjeta de Débito</option>";
                                                            break;
                                                        case 'Efectivo':
                                                            echo "<option value='".$forma."' selected>Efectivo</option>";
                                                            break;
                                                    }
                                                } else {
                                                    switch ($forma) {
                                                        case 'Credito':
                                                            echo "<option value='".$forma."'>Tarjeta de Crédito</option>";
                                                            break;
                                                        case 'Debito':
                                                            echo "<option value='".$forma."'>Tarjeta de Débito</option>";
                                                            break;
                                                        case 'Efectivo':
                                                            echo "<option value='".$forma."'>Efectivo</option>";
                                                            break;
                                                    }
                                                }
                                            }
                                        ?>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-row d-flex flex-row-reverse">
                            <div class="">
                                <a href="clientes.html" class="btn btn-danger">Cancelar</a>
                                <button type="submit" class="btn btn-success">Actualizar Cliente</button>
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
</body>

</html>