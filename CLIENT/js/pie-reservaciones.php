// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

<?php 
ini_set("soap.wsdl_cache_enabled", "0");
// Instancua de la clase Soap Client
$client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
// con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
$response = $client->__soapCall('ObtenerListaReservaciones', array());

//$array = json_decode(json_encode($response), True);

$enero = 0;
$febrero = 0;
$marzo = 0;
$abril = 0;
$mayo = 0;
$junio = 0;
$julio = 0;
$agosto = 0;
$septiembre = 0;
$octubre = 0;
$noviembre = 0;
$diciembre = 0;

foreach ($response->{'reservacion'} as $r) {
    $mes = date("m",strtotime($r->{'fechaLlegada'}));
    switch ($mes) {
        case '01':
            $enero += 1;
            break;
        case '02':
            $febrero += 1;
            break;
        case '03':
            $marzo += 1;
            break;
        case '04':
            $abril += 1;
            break;
        case '05':
            $mayo += 1;
            break;
        case '06':
            $junio += 1;
            break;
        case '07':
            $julio += 1;
            break;
        case '08':
            $agosto += 1;
            break;
        case '09':
            $septiembre += 1;
            break;
        case '10':
            $octubre += 1;
            break;
        case '11':
            $noviembre += 1;
            break;
        case '12':
            $diciembre += 1;
            break;
                                
    }
}
?>

// Pie Chart Example
var ctx = document.getElementById("ReservacionesPie");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
    datasets: [{
      data: [<?php echo $enero?>,<?php echo $febrero?>, <?php echo $marzo?>, <?php echo $abril?>, <?php echo $mayo?>, <?php echo $junio?>, <?php echo $julio?>, <?php echo $agosto?>, <?php echo $septiembre?>, <?php echo $octubre?>, <?php echo $noviembre?>, <?php echo $diciembre?>],
      backgroundColor: ['#b71c1c', '#f50057', '#4a148c', '#1565c0', "#00bcd4", "#388e3c", "#ffea00", "#ef6c00", "#dd2c00", "#1a237e", "#1de9b6", "#3e2723"],
    }],
  },
});
