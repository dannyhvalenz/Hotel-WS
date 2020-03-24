# Hotel
## Descripción
Sistema web de un hotel

## Funcionalidades
-[ ] Hacer reservacion
-[ ] Editar reservacion
-[ ] Cancelar reservacion
-[ ] Buscar reservacion
-[ ] Registrar check-in
-[ ] Aplazar estancia
-[ ] Realizar check-out

## Diagrama de clases
reservacion(id, fechaLlagada, fechaSalida, numAdultos, numNinos, precio, camas, tipoHabitacion, status)
estancia(id, idreservacion, habitacion, num,Adultos, numNinos,precio, fechaCheckIn, fechaCheckOut, tipoEstancia(sin fecha de salida o con fecha de checkout),fechaCheckOut)
habitacion(numHabitacion, piso, numCamas, tipoHabitacion)
