package com.proyecto.hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/*--------------------------RESERVACIONES-------------------------------*/
import com.proyectosw.hotel.HacerReservacionRequest;
import com.proyectosw.hotel.HacerReservacionResponse;

import com.proyectosw.hotel.EditarReservacionRequest;
import com.proyectosw.hotel.EditarReservacionResponse;

import com.proyectosw.hotel.CancelarReservacionRequest;
import com.proyectosw.hotel.CancelarReservacionResponse;

import com.proyectosw.hotel.ConsultarClienteRequest;
import com.proyectosw.hotel.ConsultarClienteResponse;

import com.proyectosw.hotel.ConsultarEstanciaRequest;
import com.proyectosw.hotel.ConsultarEstanciaResponse;

import com.proyectosw.hotel.ConsultarHabitacionRequest;
import com.proyectosw.hotel.ConsultarHabitacionResponse;

import com.proyectosw.hotel.ConsultarReservacionRequest;
import com.proyectosw.hotel.ConsultarReservacionResponse;

import model.Reservacion;
/*-----------------------------CLIENTE----------------------------------*/
import com.proyectosw.hotel.RegistrarClienteRequest;
import com.proyectosw.hotel.RegistrarClienteResponse;

import controller.ClienteDAO;
import controller.EstanciaDAO;
import controller.HabitacionDAO;
import controller.ReservacionDAO;

import com.proyectosw.hotel.EditarClienteRequest;
import com.proyectosw.hotel.EditarClienteResponse;

import com.proyectosw.hotel.EliminarClienteRequest;
import com.proyectosw.hotel.EliminarClienteResponse;

import model.Cliente;

/*-----------------------------ESTANCIA---------------------------------*/
import com.proyectosw.hotel.ModificarEstanciaRequest;
import com.proyectosw.hotel.ModificarEstanciaResponse;
import com.proyectosw.hotel.ObtenerClientesRequest;
import com.proyectosw.hotel.ObtenerClientesResponse;
import com.proyectosw.hotel.ObtenerListaClientesRequest;
import com.proyectosw.hotel.ObtenerListaClientesResponse;
import com.proyectosw.hotel.RealizarCheckInRequest;
import com.proyectosw.hotel.RealizarCheckInResponse;

import com.proyectosw.hotel.RealizarCheckOutRequest;
import com.proyectosw.hotel.RealizarCheckOutResponse;

import model.Estancia;

/*---------------------------HABITACIONES-------------------------------*/

import com.proyectosw.hotel.AgregarHabitacionRequest;
import com.proyectosw.hotel.AgregarHabitacionResponse;

import com.proyectosw.hotel.EditarHabitacionRequest;
import com.proyectosw.hotel.EditarHabitacionResponse;

import com.proyectosw.hotel.EliminarHabitacionRequest;
import com.proyectosw.hotel.EliminarHabitacionResponse;

import model.Habitacion;


@Endpoint
public class EndPoint {
	
/*--RESERVACIONES--------------------------------------------------------------------------------------*/
	
	/**
	 * Metodo para registrar o hacer una reservacion
	 * @param peticion
	 * @return mensaje y precio
	 */
	@PayloadRoot(localPart = "HacerReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public HacerReservacionResponse getHacerReservacion (@RequestPayload HacerReservacionRequest peticion) {
		HacerReservacionResponse respuesta = new HacerReservacionResponse();
		
		ReservacionDAO reservacion = new ReservacionDAO(peticion.getFechaLlegada(), peticion.getFechaSalida(), 
				peticion.getNumAdultos(),peticion.getNumNinos(), peticion.getNumCamas(),peticion.getTipoHabitacion(),peticion.getIdCliente());
		
		double precio = reservacion.getPrecio();
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
	 * @return mensaje y precio
	 */
	@PayloadRoot(localPart = "EditarReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public EditarReservacionResponse getEditarReservacion (@RequestPayload EditarReservacionRequest peticion) {
		EditarReservacionResponse respuesta = new EditarReservacionResponse();
		
		ReservacionDAO reservacion = new ReservacionDAO(peticion.getIdReservacion(),peticion.getFechaLlegada(), peticion.getFechaSalida(), peticion.getNumAdultos(),
				peticion.getNumNinos(), peticion.getNumCamas(),peticion.getTipoHabitacion(),peticion.getIdCliente());
		
		double precio = reservacion.getPrecio();
		if (reservacion.actualizarReservacion()) {
			respuesta.setRespuesta("Se ha actualizado la reservacion numero '"+reservacion.getIdReservacion()+"' en el sistema");
			respuesta.setPrecio(precio);
		} else {
			respuesta.setRespuesta("No se ha podido actualizar la reservacion numero '"+reservacion.getIdReservacion()+"' en la base de datos");
		}

		return respuesta;
	}
	
	/**
	 * Metodo para cancelar (eliminar) una reservacion
	 * @param peticion
	 * @return mensaje
	 */
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
	
	/**
	 * Metodo para consultar la informacion de una reservacion
	 * @param peticion
	 * @return fechaLlegada, fechaSalida, idCliente, numAdultos, numNinos, numCamas, tipoHabitacion, precio
	 */
	@PayloadRoot(localPart = "ConsultarReservacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public ConsultarReservacionResponse getConsultarReservacion (@RequestPayload ConsultarReservacionRequest peticion) {
		ConsultarReservacionResponse respuesta = new ConsultarReservacionResponse();
		
		ReservacionDAO reservacion = new ReservacionDAO(peticion.getIdReservacion());
		
		Reservacion r = reservacion.consultarReservacion(peticion.getIdReservacion());
		
		if (r != null) {
			Date date1 = Calendar.getInstance().getTime();  
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd");  
            String fechaLlegada = dateFormat1.format(r.getFechaLlegada());  
			respuesta.setFechaLlegada(fechaLlegada);
			
			Date date2 = Calendar.getInstance().getTime();  
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-mm-dd");  
            String fechaSalida = dateFormat2.format(r.getFechaSalida());  
			respuesta.setFechaLlegada(fechaSalida);
			
			respuesta.setIdCliente(r.getIdCliente());
			respuesta.setNumAdultos(r.getNumAdultos());
			respuesta.setNumNinos(r.getNumNinos());
			respuesta.setNumCamas(r.getNumCamas());
			respuesta.setTipoHabitacion(r.getTipoHabitacion());
			respuesta.setPrecio(r.getPrecio());
		}
		
		return respuesta;
	}
	
	/*--CLIENTES-------------------------------------------------------------------------------------------*/
	
	/**
	 * Metodo para registrar un cliente en el sistema
	 * @param peticion
	 * @return mensaje, nombre y apellido
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
	 * Metodo para actualizar un cliente de la base de datos
	 * @param peticion
	 * @return mensaje, nombre y apellido
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
	 * Metodo para eliminar a un cliente de la base de datos
	 * @param peticion
	 * @return mensaje
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
		
	/**
	 * Metodo para consultar la informacion de un cliente
	 * @param peticion
	 * @return nombre, apellido, telefono, correo, formaPago
	 */
	@PayloadRoot(localPart = "ConsultarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public ConsultarClienteResponse getConsultarCliente (@RequestPayload ConsultarClienteRequest peticion) {
		ConsultarClienteResponse respuesta = new ConsultarClienteResponse();
		ClienteDAO cliente = new ClienteDAO(peticion.getIdCliente());
		
		Cliente c = cliente.consultarCliente(peticion.getIdCliente());
		
		
		if (c != null) {
			respuesta.setNombre(c.getNombre());
			respuesta.setApellido(c.getApellido());
			respuesta.setCorreo(c.getCorreo());
			respuesta.setTelefono(c.getTelefono());
			respuesta.setFormaPago(c.getFormaPago());
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para obtener una lista con los clientes de la base de datos
	 */
	@PayloadRoot(localPart = "ObtenerListaClientesRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public ObtenerListaClientesResponse getObtenerListaClientes (@RequestPayload ObtenerListaClientesRequest peticion) {
		ObtenerListaClientesResponse respuesta = new ObtenerListaClientesResponse();
		ClienteDAO c = new ClienteDAO();
		ArrayList<Cliente> clientes = c.getListaClientes();
		
		if(clientes.size() != 0) {
			ArrayList<Integer> idCliente = new ArrayList<Integer>();
			ArrayList<String> nombre = new ArrayList<String>();
			ArrayList<String> apellido = new ArrayList<String>();
			ArrayList<String> telefono = new ArrayList<String>();
			ArrayList<String> correo = new ArrayList<String>();
			ArrayList<String> formaPago = new ArrayList<String>();
			
			for (Cliente cliente : clientes) {
				respuesta.getCliente().add(cliente);			
			}
			
			/*
			respuesta.setIdCliente(idCliente);
			respuesta.setNombre(nombre);
			respuesta.setApellido(apellido);
			respuesta.setTelefono(telefono);
			respuesta.setCorreo(correo);
			respuesta.setFormaPago(formaPago);
			*/
		} else {
			ArrayList<Integer> idCliente = new ArrayList<Integer>();
			ArrayList<String> nombre = new ArrayList<String>();
			ArrayList<String> apellido = new ArrayList<String>();
			ArrayList<String> telefono = new ArrayList<String>();
			ArrayList<String> correo = new ArrayList<String>();
			ArrayList<String> formaPago = new ArrayList<String>();
			
			idCliente.add(0);
			nombre.add("");
			apellido.add("");
			telefono.add("");
			correo.add("");
			formaPago.add("");
			/*
			respuesta.setIdCliente(idCliente);
			respuesta.setNombre(nombre);
			respuesta.setApellido(apellido);
			respuesta.setTelefono(telefono);
			respuesta.setCorreo(correo);
			respuesta.setFormaPago(formaPago);
			*/
			
		}
		
		
		return respuesta;
	}
	
	/*--ESTANCIA-------------------------------------------------------------------------------------------*/
	
	/**
	 * Metodo para registrar una estancia (Realizar check in)
	 * @param peticion
	 * @return mensaje con el numero de habitacion
	 */
	@PayloadRoot(localPart = "RealizarCheckInRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public RealizarCheckInResponse getRegistrarCheckIn (@RequestPayload RealizarCheckInRequest peticion) {
		RealizarCheckInResponse respuesta = new RealizarCheckInResponse();
		EstanciaDAO estancia = new EstanciaDAO(peticion.getNumHabitacion(), peticion.getNumAdultos(), 
				peticion.getNumNinos(), peticion.getFechaCheckIn(), peticion.getFechaCheckOut(),
				peticion.getTipoHabitacion(), peticion.getIdCliente());
		
		if (estancia.realizarCheckIn()) {
			respuesta.setRespuesta("Se ha realizado el check-in en la habitacion: " + estancia.getNumHabitacion());
			respuesta.setPrecio(estancia.obtenerPrecio());
			respuesta.setStatus(estancia.getStatus());
		} else {
			respuesta.setRespuesta("No se ha podido registrar el check-in en la base de datos");
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para modificar la estancia (Aplazar o acortar estancia)
	 * @param peticion
	 * @return mensaje con el id de la estancia y precio actualizado
	 */
	@PayloadRoot(localPart = "ModificarEstanciaRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public ModificarEstanciaResponse getModificarEstancia (@RequestPayload ModificarEstanciaRequest peticion) {
		ModificarEstanciaResponse respuesta = new ModificarEstanciaResponse();
		EstanciaDAO estancia = new EstanciaDAO(peticion.getIdEstancia(), peticion.getFechaCheckOut());
		
		if (estancia.modificarEstancia()) {
			respuesta.setRespuesta("Se ha modificado la fecha de salida de la estancia numero: " + peticion.getIdEstancia());
			respuesta.setPrecio(estancia.obtenerPrecio());
		} else {
			respuesta.setRespuesta("No se ha podido modificar la fecha de salida de la estancia numero "+peticion.getIdEstancia()+" en la base de datos");
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para realizar el check-out (Terminar estancia)
	 * @param peticion
	 * @return mensaje, precio y status
	 */
	@PayloadRoot(localPart = "RealizarCheckOutRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public RealizarCheckOutResponse getRealizarCheckOut (@RequestPayload RealizarCheckOutRequest peticion) {
		RealizarCheckOutResponse respuesta = new RealizarCheckOutResponse();
		EstanciaDAO estancia = new EstanciaDAO(peticion.getIdEstancia(), peticion.getFechaCheckOut());
		
		if (estancia.realizarCheckOut()) {
			respuesta.setRespuesta("Se ha realizado el check-out de la estancia numero: " + peticion.getIdEstancia());
			respuesta.setPrecio(estancia.obtenerPrecio());
			respuesta.setStatus(estancia.getStatus());
		} else {
			respuesta.setRespuesta("No se ha podido registrar el check-out en la base de datos");
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para consultar una estancia
	 * @param peticion
	 * @return fechaCheckIn, fechaCheckOut, numHabitacion, idCliente, numAdultos, numNinos, 
	 * 				tipoHabitacion, status y precio
	 */
	@PayloadRoot(localPart = "ConsultarEstanciaRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public ConsultarEstanciaResponse getConsultarEstancia (@RequestPayload ConsultarEstanciaRequest peticion) {
		ConsultarEstanciaResponse respuesta = new ConsultarEstanciaResponse();
		EstanciaDAO estancia = new EstanciaDAO(peticion.getIdEstancia());
		
		Estancia e = estancia.consultarEstancia(peticion.getIdEstancia());
		
		
		if (e != null) {
			
			Date date1 = Calendar.getInstance().getTime();  
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd");  
            String fechaLlegada = dateFormat1.format(e.getFechaCheckIn());  
			respuesta.setFechaCheckIn(fechaLlegada);
			
			Date date2 = Calendar.getInstance().getTime();  
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-mm-dd");  
            String fechaSalida = dateFormat2.format(e.getFechaCheckOut());  
			respuesta.setFechaCheckOut(fechaSalida);
			
			respuesta.setNumHabitacion(e.getNumHabitacion());
			respuesta.setIdCliente(e.getIdCliente());
			respuesta.setNumAdultos(e.getNumAdultos());
			respuesta.setNumNinos(e.getNumNinos());
			respuesta.setTipoHabitacion(e.getTipoHabitacion());
			respuesta.setStatus(e.getStatus());
			respuesta.setPrecio(e.getPrecio());
		}
		
		return respuesta;
	}
	
	/*--HABITACIONES----------------------------------------------------------------------------------------*/
	
	/**
	 * Metodo para agregar una habitacion
	 * @param peticion
	 * @return mensaje con numHabitacion
	 */
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
	
	/**
	 * Metodo para editar la informacion de una habitacion
	 * @param peticion
	 * @return mensaje con numHabitacion
	 */
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
	
	/**
	 * Metodo para eliminar una habitacion
	 * @param peticion
	 * @return mensaje con numHabitacion
	 */
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
	
	/**
	 * Metodo para consultar una habitacion
	 * @param peticion
	 * @return cupoPersonas, numCamas, getPiso, status, tipoHabitacion
	 */
	@PayloadRoot(localPart = "ConsultarHabitacionRequest", namespace = "http://proyectoSW.com/Hotel")
	
	@ResponsePayload
	public ConsultarHabitacionResponse getConsultarCliente (@RequestPayload ConsultarHabitacionRequest peticion) {
		ConsultarHabitacionResponse respuesta = new ConsultarHabitacionResponse();
		HabitacionDAO habitacion = new HabitacionDAO(peticion.getNumHabitacion());
		
		Habitacion h = habitacion.consultarHabitacion(peticion.getNumHabitacion());
		
		if (h != null) {
			respuesta.setCupoPersonas(h.getCupoPersonas());
			respuesta.setNumCamas(h.getNumCamas());
			respuesta.setPiso(h.getPiso());
			respuesta.setStatus(h.getStatus());
			respuesta.setTipoHabitacion(h.getTipoHabitacion());
		}
		
		return respuesta;
	}
			
	
}
