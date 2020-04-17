# DHotel
## Descripción
Sistema web de un hotel

[Link del Servidor](http://54.162.225.248:8080/hotel.wsdl)

## Funcionalidades

- [x] Hacer reservacion
  Ejemplo

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
| idCliente     | Int    ||

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
Se ingresan los datos de la reservacion y si la reservacion se realiza con exito entonces el sistema mostrara el mensaje "Se ha registrado la reservacion en el sistema"

- Editar reservacion

Se modifican los datos de la reservacion y se muestra mensaje "Se ha actualizado la informacion de la reservacion"

- Cancelar reservacion

Se muestra mensaje "se ha cancelado la reservacion

- Buscar reservacion

No estoy mu segura de cual es el mensaje o si se considera mensaje todas las reservaciones que regresen como resultsdo de la busqueda

- Registrar check-in

se muestra mensaje " se ha registrado check in del cliente X en la habitacion X"

- Aplazar estancia

se muestra mensaje "se ha aplazado la fecha de check out de la estancia del cliente X"

- Registrar check-in

se muestra el costo de la estancia

- Registrar cliente

se muestra mensaje "se ha registrado al cliente correctamente"

- Actualizar cliente 

se muestra mensaje "se han actualizado correctamente los datos del cliente"

- Eliminar cliente `¿Se eliminan los clientes registrados en un hotel?`

Se muestra mensaje "Se ha eliminado el cliente"

- Agregar habitación

se muestra mensaje "se ha registrado una nueva habitacion"

- Modificar habitación

se muestra mensaje " se han actualizado los datos de la habitacion x"

- Eliminar habitación

se muestra mensaje "se ha eliminado la habitación número x"

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



