# Hotel
## Descripción
Sistema web de un hotel

## Funcionalidades
- [ ] Hacer reservacion
- [ ] Editar reservacion
- [ ] Cancelar reservacion
- [ ] Buscar reservacion
- [ ] Registrar check-in
- [ ] Aplazar estancia
- [ ] Realizar check-out
- [ ] Registrar cliente
- [ ] Actualizar cliente
- [ ] Eliminar cliente ¿?
- [ ] Agregar habitacion
- [ ] Modificar habitacion
- [ ] Elimnar habitacion

## Diagrama de clases
- **reservacion**(id, fechaLlagada, fechaSalida, numAdultos, numNinos, precio, camas, tipoHabitacion, status, codigopromocioon, idCliente)
- **estancia**(id, idreservacion, habitacion, num,Adultos, numNinos,precio, fechaCheckIn, fechaCheckOut, tipoEstancia(sin fecha de salida o con fecha de checkout),fechaCheckOut,codigopromocioon)
- **habitacion**(numHabitacion, piso, numCamas, tipoHabitacion,status(ocupada y desocupada))
- **cliente**(idCliente,nombre,apellido,telefono, formaPago, correo)

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

- Registrar cliente

se muestra mensaje "se ha registrado al cliente correctamente"

- Actualizar cliente 

se muestra mensaje "se han actualizado correctamente los datos del cliente"

- Eliminar cliente ¿Se eliminan los clientes registrados en un hotel?

- Agregar habitacion

se muestra mensaje "se ha registrado una nueva habitacion"

- Modificar habitacion

se muestra mensaje " se han actualizado los datos de la habitacion x"

- Elimnar habitacion

se muestra mensaje "se ha eliminado la habitacion numero x"

