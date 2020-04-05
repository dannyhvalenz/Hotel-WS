package com.proyecto.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
import controller.HabitacionDAO;
import controller.ReservacionDAO;

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
	
	
	/**
	 * Metodo para registrar o hacer una reservacion
	 * @param peticion
	 * @return respuesta
	 */
	@PayloadRoot(localPart = "HacerReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public HacerReservacionResponse getHacerReservacion (@RequestPayload HacerReservacionRequest peticion) {
		HacerReservacionResponse respuesta = new HacerReservacionResponse();
		
		// Sacar num de dias para obtener precio por dias
		
		ReservacionDAO reservacion = new ReservacionDAO(peticion.getFechaLlegada(), peticion.getFechaSalida(), 
				peticion.getNumAdultos(),peticion.getNumNinos(), peticion.getNumCamas(),peticion.getTipoHabitacion(),peticion.getIdCliente());
		
		double precio = reservacion.getPrecio();
		System.out.println("precio = " + precio);
		if (reservacion.registrarReservacion()) {
			respuesta.setRespuesta("Se ha registrado la reservacion en el sistema");
			respuesta.setPrecio(precio);
		} else {
			respuesta.setRespuesta("No se ha podido registrar la reservacion en la base de datos");
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para editar una reservacion
	 * @param peticion
	 * @return respuesta
	 */
	@PayloadRoot(localPart = "EditarReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarReservacionResponse getEditarReservacion (@RequestPayload EditarReservacionRequest peticion) {
		EditarReservacionResponse respuesta = new EditarReservacionResponse();
		
		ReservacionDAO reservacion = new ReservacionDAO(peticion.getIdReservacion(),peticion.getFechaLlegada(), peticion.getFechaSalida(), peticion.getNumAdultos(),
				peticion.getNumNinos(), peticion.getNumCamas(),peticion.getTipoHabitacion(),peticion.getIdCliente());
		
		double precio = reservacion.getPrecio();
		System.out.println("precio = " + precio);
		if (reservacion.actualizarReservacion()) {
			respuesta.setRespuesta("Se ha actualizado la reservacion numero '"+reservacion.getIdReservacion()+"' en el sistema");
			respuesta.setPrecio(precio);
		} else {
			respuesta.setRespuesta("No se ha podido actualizar la reservacion numero '"+reservacion.getIdReservacion()+"' en la base de datos");
		}

		return respuesta;
	}
	
	// Cancelar Reservacion
	@PayloadRoot(localPart = "CancelarReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public CancelarReservacionResponse getCancelarReservacion (@RequestPayload CancelarReservacionRequest peticion) {
		CancelarReservacionResponse respuesta = new CancelarReservacionResponse();
		
		ReservacionDAO reservacion = new ReservacionDAO(peticion.getIdReservacion());
		
		if (reservacion.eliminarReservacion()) {
			respuesta.setRespuesta("Se ha eliminado la reservacion del sistema");
		} else {
			respuesta.setRespuesta("No se ha podido eliminar la reservacion de la base de datos");
		}
		
		return respuesta;
	}
	
	/*--CLIENTES-------------------------------------------------------------------------------------------*/
	
	
	/**
	 * Metodo para registrar cliente en el sistema
	 * @param peticion
	 * @return respuesta
	 */
	@PayloadRoot(localPart = "RegistrarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public RegistrarClienteResponse getRegistrarCliente (@RequestPayload RegistrarClienteRequest peticion) {
		RegistrarClienteResponse respuesta = new RegistrarClienteResponse();
		
		ClienteDAO cliente = new ClienteDAO(peticion.getNombre(), peticion.getApellido(), 
				peticion.getTelefono(), peticion.getCorreo(), peticion.getFormaPago());
		
		if (cliente.registrarCliente()) {
			respuesta.setRespuesta("Se ha registrado al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en el sistema");
		} else {
			respuesta.setRespuesta("No se ha podido registrar al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en la base de datos");
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para actualizar al cliente de la base de datos
	 * @param peticion
	 * @return respuesta
	 */
	@PayloadRoot(localPart = "EditarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarClienteResponse getEditarCliente (@RequestPayload EditarClienteRequest peticion) {
		EditarClienteResponse respuesta = new EditarClienteResponse();
		ClienteDAO cliente = new ClienteDAO(peticion.getIdCliente(),peticion.getNombre(), peticion.getApellido(), 
				peticion.getTelefono(), peticion.getCorreo(), peticion.getFormaPago());
		if (cliente.verificarIdCliente()) {
			if (cliente.actualizarCliente()) {
				respuesta.setRespuesta("Se ha actualizado al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en el sistema");
			} else {
				respuesta.setRespuesta("No se ha podido actualizar al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en la base de datos");
			}
		} else {
			respuesta.setRespuesta("El idCliente que ha ingresado no existe");
		}
		
		return respuesta;
	}
	
	
	/**
	 * Metodo para eliminar al cliente de la base de datos
	 * @param peticion
	 * @return respuesta "mensaje"
	 */
	@PayloadRoot(localPart = "EliminarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	@ResponsePayload
	public EliminarClienteResponse getEliminarCliente (@RequestPayload EliminarClienteRequest peticion) {
		EliminarClienteResponse respuesta = new EliminarClienteResponse();
		ClienteDAO cliente = new ClienteDAO(peticion.getIdCliente());
		if (cliente.eliminarCliente()) {
			respuesta.setRespuesta("Se ha eliminado al cliente del sistema");
		} else {
			respuesta.setRespuesta("No se ha podido eliminar al cliente de la base de datos");
		}
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
		respuesta.getPrecio();
		return respuesta;
	}
	
	/*--HABITACIONES----------------------------------------------------------------------------------------*/
	
	// Agregar Habitacion
	@PayloadRoot(localPart = "AgregarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public AgregarHabitacionResponse getAgregarHabitacion (@RequestPayload AgregarHabitacionRequest peticion) {
		AgregarHabitacionResponse respuesta = new AgregarHabitacionResponse();
		HabitacionDAO habitacion = new HabitacionDAO(peticion.getNumHabitacion(), peticion.getPiso(), peticion.getNumCamas(),
				peticion.getCupoPersonas(), peticion.getTipoHabitacion(), peticion.getStatus());
		if (habitacion.agregarHabitacion()) {
			respuesta.setRespuesta("Se ha agregado la habitacion " +habitacion.getNumHabitacion()+" al sistema");
		} else {
			respuesta.setRespuesta("No se ha podido agregar la habitacion al sistema");
		}
		return respuesta;
	}
	
	// Editar Habitacion
	@PayloadRoot(localPart = "EditarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarHabitacionResponse getEditarHabitacion (@RequestPayload EditarHabitacionRequest peticion) {
		EditarHabitacionResponse respuesta = new EditarHabitacionResponse();
		HabitacionDAO habitacion = new HabitacionDAO(peticion.getNumHabitacion(), peticion.getPiso(), peticion.getNumCamas(),
				peticion.getCupoPersonas(), peticion.getTipoHabitacion(), peticion.getStatus());
		if (habitacion.actualizarHabitacion()) {
			respuesta.setRespuesta("Se ha actualizado la habitacion " +habitacion.getNumHabitacion()+" en el sistema");
		} else {
			respuesta.setRespuesta("No se ha podido actualizar la habitacion al sistema");
		}
		return respuesta;
	}
	
	// Eliminar Habitacion
	@PayloadRoot(localPart = "EliminarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EliminarHabitacionResponse getEliminarHabitacion (@RequestPayload EliminarHabitacionRequest peticion) {
		EliminarHabitacionResponse respuesta = new EliminarHabitacionResponse();
		HabitacionDAO habitacion = new HabitacionDAO(peticion.getNumHabitacion());
		if (habitacion.eliminarHabitacion()) {
			respuesta.setRespuesta("Se ha eliminado la habitacion " +peticion.getNumHabitacion()+" en el sistema");
		} else {
			respuesta.setRespuesta("No se ha podido eliminar la habitacion al sistema");
		}
		return respuesta;
	}
			
	
}
