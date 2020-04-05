

# Segunda Evaluacion

## Funcionalidades implementadas

### Agregar Cliente

![Screen Shot 2020-04-04 at 22.32.22](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.32.22.png)

![Screen Shot 2020-04-04 at 22.32.39](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.32.39.png)

### Editar Cliente

![Screen Shot 2020-04-04 at 22.34.47](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.34.47.png)

![Screen Shot 2020-04-04 at 22.34.39](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.34.39.png)

### Eliminar Cliente

![Screen Shot 2020-04-04 at 22.36.21](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.36.21.png)

![Screen Shot 2020-04-04 at 22.36.33](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.36.33.png)

### Agregar Habitacion

![Screen Shot 2020-04-04 at 22.52.36](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.52.36.png)![Screen Shot 2020-04-04 at 22.52.45](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 22.52.45.png)

### Editar Habitacion

![Screen Shot 2020-04-04 at 23.11.29](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 23.11.29.png)

![Screen Shot 2020-04-04 at 23.11.37](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 23.11.37.png)

### Eliminar Habitacion

![Screen Shot 2020-04-04 at 23.13.15](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 23.13.15.png)

![Screen Shot 2020-04-04 at 23.13.22](/Users/dany/Library/Application Support/typora-user-images/Screen Shot 2020-04-04 at 23.13.22.png)

<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <HacerReservacionRequest xmlns="http://proyectoSW.com/Hotel">
            <fechaLlegada>2019/11/05</fechaLlegada>
            <fechaSalida>2019/11/11</fechaSalida>
            <numAdultos>1</numAdultos>
            <numNinos>0</numNinos>
            <precio>800</precio>
            <numCamas>1</numCamas>
            <tipoHabitacion>Individual</tipoHabitacion>
            <idCliente>1</idCliente>
        </HacerReservacionRequest>
    </Body>
</Envelope>