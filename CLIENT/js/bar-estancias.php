// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

<?php 
ini_set("soap.wsdl_cache_enabled", "0");
// Instancua de la clase Soap Client
$client = new SoapClient("http://54.162.225.248:8080/hotel.wsdl");
// con la ruta de mi servicio en la nube manda el mismo error que aparece si yo dejo de ejecutar el 54.162.225.248
$response = $client->__soapCall('ObtenerListaEstancias', array());

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

foreach ($response->{'estancia'} as $r) {
    $mes = date("m",strtotime($r->{'fechaCheckIn'}));
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
$max = 0;
$arregloMeses = array($enero,$febrero,$marzo,$abril,$mayo,$junio,$julio,$agosto,$septiembre,$octubre,$noviembre,$diciembre);
foreach ($arregloMeses as $m){
  if ($m > $max){
    $max = $m;
  }
}
$max += 1;

?>

// Bar Chart Example
var ctx = document.getElementById("EstanciasBar");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
    datasets: [{
      label: "Estancias",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [<?php echo $enero?>,<?php echo $febrero?>, <?php echo $marzo?>, <?php echo $abril?>, <?php echo $mayo?>, <?php echo $junio?>, <?php echo $julio?>, <?php echo $agosto?>, <?php echo $septiembre?>, <?php echo $octubre?>, <?php echo $noviembre?>, <?php echo $diciembre?>],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 12
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: <?php echo $max?>,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
