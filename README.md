# Hotel
## Descripción
Sistema web de un hotel

[Link del Servidor](http://54.162.225.248:8080/hotel.wsdl)

## Funcionalidades
- [x] Hacer reservacion
- [x] Editar reservacion
- [x] Cancelar reservacion
- [ ] Registrar check-in
- [ ] Aplazar estancia
- [ ] Realizar check-out
- [x] Registrar cliente
- [x] Actualizar cliente
- [x] Eliminar cliente `¿En un hotel se eliminan a los clientes o solo se modifican?`
- [x] Agregar habitacion
- [x] Modificar habitacion
- [x] Elimnar habitacion

## Diagrama de clases

### Reservacion

| Atributo       | Tipo   |Formato|
| -------------- | ------ |-------|
| idReservacion  | Int    |
| fechaLlegada   | Date   |`2019-11-05`|
| fechaSalida    | Date   |`2019-11-05`|
| numAdultos     | Int    |
| numNinos       | Int    |
| precio         | Double |
| numCamas       | Int    |
| tipoHabitacion | String |
| idCliente      | Int    |

### Estancia

| Atributo      | Tipo   | Formato|
| ------------- | ------ | -------|
| idEstancia    | Int    |
| numHabitacion | Int    |
| numAdultos    | Int    |
| numNinos      | Int    |
| precio        | Double |
| fechaCheckIn  | Date   |`2019-11-05`|
| fechaCheckOut | Date   |`2019-11-05`|
| idCliente     | Int    |

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
- Hacer reservacion 

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









qK4rRuF6^B



 CREATE USER 'hotel'@'localhost' IDENTIFIED BY 'qK4rRuF6^B';

