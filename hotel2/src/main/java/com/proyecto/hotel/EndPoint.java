package com.proyecto.hotel;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/*--------------------------RESERVACIONES-------------------------------*/
import com.proyectosw.hotel.HacerReservacionRequest;
import com.proyectosw.hotel.HacerReservacionResponse;

import com.proyectosw.hotel.EditarReservacionRequest;
import com.proyectosw.hotel.EditarReservacionResponse;
import com.proyectosw.hotel.EliminarClienteRequest;
import com.proyectosw.hotel.EliminarClienteResponse;
import com.proyectosw.hotel.CancelarReservacionRequest;
import com.proyectosw.hotel.CancelarReservacionResponse;

/*-----------------------------CLIENTE----------------------------------*/
import com.proyectosw.hotel.RegistrarClienteRequest;
import com.proyectosw.hotel.RegistrarClienteResponse;

import controller.ClienteDAO;

import com.proyectosw.hotel.EditarClienteRequest;
import com.proyectosw.hotel.EditarClienteResponse;

/*-----------------------------ESTANCIA---------------------------------*/
import com.proyectosw.hotel.AplazarEstanciaRequest;
import com.proyectosw.hotel.AplazarEstanciaResponse;

import com.proyectosw.hotel.RegistrarCheckInRequest;
import com.proyectosw.hotel.RegistrarCheckInResponse;

import com.proyectosw.hotel.RegistrarCheckOutRequest;
import com.proyectosw.hotel.RegistrarCheckOutResponse;

/*---------------------------HABITACIONES-------------------------------*/

import com.proyectosw.hotel.AgregarHabitacionRequest;
import com.proyectosw.hotel.AgregarHabitacionResponse;

import com.proyectosw.hotel.EditarHabitacionRequest;
import com.proyectosw.hotel.EditarHabitacionResponse;

import com.proyectosw.hotel.EliminarHabitacionRequest;
import com.proyectosw.hotel.EliminarHabitacionResponse;


@Endpoint
public class EndPoint {
	
	/*--RESERVACIONES--------------------------------------------------------------------------------------*/
	
	
	// Hacer Reservacion
	@PayloadRoot(localPart = "HacerReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public HacerReservacionResponse getHacerReservacion (@RequestPayload HacerReservacionRequest peticion) {
		HacerReservacionResponse respuesta = new HacerReservacionResponse();
		respuesta.setRespuesta("Se ha registrado la reservacion en el sistema");
		return respuesta;
	}
	
	// Editar Reservacion
	@PayloadRoot(localPart = "EditarReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarReservacionResponse getEditarReservacion (@RequestPayload EditarReservacionRequest peticion) {
		EditarReservacionResponse respuesta = new EditarReservacionResponse();
		respuesta.setRespuesta("Se ha editado la reservacion con folio: "+ peticion.getIdReservacion() +"en el sistema");
		return respuesta;
	}
	
	// Cancelar Reservacion
	@PayloadRoot(localPart = "CancelarReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public CancelarReservacionResponse getCancelarReservacion (@RequestPayload CancelarReservacionRequest peticion) {
		CancelarReservacionResponse respuesta = new CancelarReservacionResponse();
		respuesta.setRespuesta("Se ha editado la reservacion con folio: "+ peticion.getIdReservacion() +"en el sistema");
		return respuesta;
	}
	
	/*--CLIENTES-------------------------------------------------------------------------------------------*/
	
	
	// Registrar Cliente
	@PayloadRoot(localPart = "RegistrarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public RegistrarClienteResponse getRegistrarCliente (@RequestPayload RegistrarClienteRequest peticion) {
		RegistrarClienteResponse respuesta = new RegistrarClienteResponse();
		
		ClienteDAO cliente = new ClienteDAO(peticion.getNombre(), peticion.getApellido(), 
				peticion.getTelefono(), peticion.getCorreo(), peticion.getFormaPago());
		
		if (cliente.registrarCliente()) {
			respuesta.setRespuesta("Se ha registrado al cliente "+cliente.getNombre()+" "+cliente.getApellido()+"en el sistema");
		} else {
			respuesta.setRespuesta("No se ha podido registrar al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en la base de datos");
		}
		
		return respuesta;
	}
	
	// Editar Cliente
	@PayloadRoot(localPart = "EditarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarClienteResponse getEditarCliente (@RequestPayload EditarClienteRequest peticion) {
		EditarClienteResponse respuesta = new EditarClienteResponse();
		respuesta.setRespuesta("Se ha editado la infomacion del cliente "+ 
				peticion.getNombre() + " " + peticion.getApellido() +"en el sistema");
		return respuesta;
	}
	
	// Eliminar Cliente
	@PayloadRoot(localPart = "EliminarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EliminarClienteResponse getEliminarCliente (@RequestPayload EliminarClienteRequest peticion) {
		EliminarClienteResponse respuesta = new EliminarClienteResponse();
		respuesta.setRespuesta("Se ha eliminado el cliente del sistema");
		return respuesta;
	}
		
	
	/*--ESTANCIA-------------------------------------------------------------------------------------------*/
	
	// Registrar Check-In
	@PayloadRoot(localPart = "RegistrarCheckInRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public RegistrarCheckInResponse getRegistrarCheckIn (@RequestPayload RegistrarCheckInRequest peticion) {
		RegistrarCheckInResponse respuesta = new RegistrarCheckInResponse();
		respuesta.setRespuesta("Se ha registrado el check-in en la habitacion: " + peticion.getNumHabitacion());
		return respuesta;
	}
	
	// Aplazar Estancia
	@PayloadRoot(localPart = "AplazarEstanciaRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public AplazarEstanciaResponse getAplazarEstancia (@RequestPayload AplazarEstanciaRequest peticion) {
		AplazarEstanciaResponse respuesta = new AplazarEstanciaResponse();
		respuesta.setRespuesta("Se ha aplazado la salida de la estancia con folio: "+ peticion.getIdEstancia());
		return respuesta;
	}
	
	// Registrar Check-Out
	@PayloadRoot(localPart = "RegistrarCheckOutRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public RegistrarCheckOutResponse getRegistrarCheckOut (@RequestPayload RegistrarCheckOutRequest peticion) {
		RegistrarCheckOutResponse respuesta = new RegistrarCheckOutResponse();
		respuesta.setRespuesta("Se ha registrado el check-out de la estancia con folio: "+ peticion.getIdEstancia());
		return respuesta;
	}
	
	/*--HABITACIONES----------------------------------------------------------------------------------------*/
	
	// Agregar Habitacion
	@PayloadRoot(localPart = "AgregarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public AgregarHabitacionResponse getAgregarHabitacion (@RequestPayload AgregarHabitacionRequest peticion) {
		AgregarHabitacionResponse respuesta = new AgregarHabitacionResponse();
		respuesta.setRespuesta("Se ha agregado la habitacion " + peticion.getNumHabitacion() + "al sistema");
		return respuesta;
	}
	
	// Editar Habitacion
	@PayloadRoot(localPart = "EditarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarHabitacionResponse getEditarHabitacion (@RequestPayload EditarHabitacionRequest peticion) {
		EditarHabitacionResponse respuesta = new EditarHabitacionResponse();
		respuesta.setRespuesta("Se ha editado la habitacion " + peticion.getNumHabitacion());
		return respuesta;
	}
	
	// Eliminar Habitacion
	@PayloadRoot(localPart = "EliminarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EliminarHabitacionResponse getEliminarHabitacion (@RequestPayload EliminarHabitacionRequest peticion) {
		EliminarHabitacionResponse respuesta = new EliminarHabitacionResponse();
		respuesta.setRespuesta("Se ha eliminado la habitacion " + peticion.getNumHabitacion());
		return respuesta;
	}
			
	
}
