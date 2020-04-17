# Hotel
## Descripción
Sistema web de un hotel

[Link del Servidor](http://54.162.225.248:8080/hotel.wsdl)

## Funcionalidades

- [x] Hacer reservacion

  ```xml
  <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
          <HacerReservacionRequest xmlns="http://proyectoSW.com/Hotel">
              <fechaLlegada>2020-04-20</fechaLlegada>
              <fechaSalida>2020-04-30</fechaSalida>
              <numAdultos>1</numAdultos>
              <numNinos>0</numNinos>
              <numCamas>1</numCamas>
              <tipoHabitacion>Individual</tipoHabitacion>
              <idCliente>53</idCliente>
          </HacerReservacionRequest>
      </Body>
  </Envelope>
  ```

- [x] Editar reservacion

- [x] Cancelar reservacion

- [x] Consultar reservación

- [x] Realizar check-in

  ```xml
  <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
          <RealizarCheckInRequest xmlns="http://proyectoSW.com/Hotel">
              <numHabitacion>1</numHabitacion>
              <numAdultos>1</numAdultos>
              <numNinos>0</numNinos>
              <tipoHabitacion>Individual</tipoHabitacion>
              <fechaCheckIn>2020-04-04</fechaCheckIn>
              <fechaCheckOut>2020-04-14</fechaCheckOut>
              <idCliente>23</idCliente>
          </RealizarCheckInRequest>
      </Body>
  </Envelope>
  ```

- [x] Modificar estancia (Aplazar o acortar estancia)

- [x] Realizar check-out

- [x] Consultar estancia

- [x] Registrar cliente

  ```xml
  <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
          <RegistrarClienteRequest xmlns="http://proyectoSW.com/Hotel">
              <nombre>Federico</nombre>
              <apellido>Toss</apellido>
              <telefono>2282212265</telefono>
              <correo>federicotoss@live.com.mx</correo>
              <formaPago>Debito</formaPago>
          </RegistrarClienteRequest>
      </Body>
  </Envelope>
  ```

- [x] Actualizar cliente

- [x] Eliminar cliente `¿En un hotel se eliminan a los clientes o solo se modifican?`

- [x] Consultar cliente

- [x] Agregar habitacion

  ```xml
  <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
          <AgregarHabitacionRequest xmlns="http://proyectoSW.com/Hotel">
              <numHabitacion>11</numHabitacion>
              <piso>1</piso>
              <numCamas>2</numCamas>
              <cupoPersonas>4</cupoPersonas>
              <tipoHabitacion>Doble</tipoHabitacion>
              <status>Disponible</status>
          </AgregarHabitacionRequest>
      </Body>
  </Envelope>
  ```

- [x] Modificar habitacion

- [x] Eliminar habitacion

- [X] Consultar habitación

## Clases

### Reservación

| Atributo       | Tipo   |Descripción|
| -------------- | ------ |-------|
| idReservacion  | Int    ||
| fechaLlegada   | Date   |Formato`yyyy-mm-dd`|
| fechaSalida    | Date   |Formato`yyyy-mm-dd`|
| numAdultos     | Int    ||
| numNinos       | Int    ||
| precio         | Double |Calculado a partir de fechaSalida - fechaLlegada|
| numCamas       | Int    ||
| tipoHabitacion | String ||
| idCliente      | Int    ||

### Estancia

| Parámetro | Tipo   | Formato|
| ------------- | ------ | -------|
| idEstancia    | Int    ||
| numHabitacion | Int    ||
| numAdultos    | Int    ||
| numNinos      | Int    ||
| precio        | Double |Calculado a partir de fechaSalida - fechaLlegada|
| fechaCheckIn  | Date   |Formato`yyyy-mm-dd`|
| fechaCheckOut | Date   |Formato`yyyy-mm-dd`|
| Status | String |`Check-In` o `Check-Out`|
| idCliente | Int ||
| tipoHabitacion | String ||

### Habitacion

| Atributo                                | Tipo   |
| --------------------------------------- | ------ |
| numHabitacion                           | Int    |
| Piso                                    | Int    |
| numCamas                                | Int    |
| CupoPersonas                            | Int    |
| tipoHabitacion `suite, sencilla, doble` | String |
| status `ocupada, desocupada`            | String |

### Cliente

| Atributo  | Tipo   |
| --------- | ------ |
| idCliente | Int    |
| Nombre    | String |
| Apellido  | String |
| Correo    | String |
| Telefono  | String |
| formaPago | String |

## Mensajes
| Funcion                                | Parámetros                                                   | Respuestas                                                   |
| -------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Hacer reservación                      | `fechaLlegada, fechaSalida, numAdultos, numNinos, numCamas, tipoHabitacion, idCliente` | Mensaje ("Se ha registrado la reservacion en el sistema") y `precio` |
| Editar reservación                     | `idReservacion, fechaLlegada, fechaSalida, numAdultos, numNinos, numCamas, tipoHabitacion, idCliente` | Mensaje("Se ha actualizado la reservacion numero `idReservacion` en el sistema") y `precio` |
| Cancelar reservación                   | `idReservacion`                                              | Mensaje("Se ha eliminado la reservacion del sistema")        |
| Consultar reservación                  | `idReservacion`                                              | `fechaLlegada, fechaSalida, numAdultos, numNinos, numCamas, tipoHabitacion, precio, idCliente` |
| Realizar Check-In                      | `numHabitacion, numAdultos, numNinos, tipoHabitacion, fechaCheckIn, fechaCheckOut, idCliente` | Mensaje("Se ha realizado el check-in en la habitacion `numHabitacion`"), `status` y `precio` |
| Modificar estancia (aplazar o acortar) | `idEstancia, fechaCheckOut`                                  | Mensaje("Se ha modificado la fecha de salida de la estancia numero `idEstancia`"), `status` y `precio` |
| Realizar Check-Out                     | `idEstancia, fechaCheckOut`                                  | Mensaje("Se ha realizado el check-out de la estancia numero `idEstancia`"), `status` y `precio` |
| Consultar Estancia                     | `idEstancia`                                                 | `numHabitacion, numAdultos, numNinos, tipoHabitacion, fechaCheckIn, fechaCheckOut, idCliente, status, precio` |
| Registrar cliente                      | `nombre, apellido, telefono, correo, formaPago`              | Mensaje("Se ha registrado al cliente `nombre apellido` en el sistema") |
| Actualizar cliente                     | `idCliente, nombre, apellido, telefono, correo, formaPago`   | Mensaje("Se ha actualizado al cliente `nombre apellido` en el sistema") |
| Eliminar cliente                       | `idCliente`                                                  | Mensaje("Se ha eliminado al cliente del sistema")            |
| Consultar cliente                      | `idCliente`                                                  | `nombre, apellido, telefono, correo, formaPago`              |
| Agregar habitacion                     | `numHabitacion, piso, numCamas, cupoPersonas, tipoHabitacion, status ` | Mensaje("Se ha agregado la habitacion `numHabitacion` al sistema") |
| Modificar habitacion                   | `numHabitacion, piso, numCamas, cupoPersonas, tipoHabitacion, status ` | Mensaje("Se ha agregado la habitacion `numHabitacion` al sistema") |
| Eliminar habitacion                    | `numHabitacion`                                              | Mensaje("Se ha eliminado la habitacion `numHabitacion` al sistema") |
| Consultar habitación                   | `numHabitacion`                                              | `piso, numCamas, cupoPersonas, tipoHabitacion, status `      |

## Dependencias

MySQL

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.48</version>
</dependency>
```

WSDL4J

```xml
<dependency>
	<groupId>wsdl4j</groupId>
	<artifactId>wsdl4j</artifactId>
</dependency>
```

SpringBoot dependencies

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web-services</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
	<exclusions>
		<exclusion>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```



