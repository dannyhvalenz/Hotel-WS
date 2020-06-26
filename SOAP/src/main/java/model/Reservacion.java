package model;

import java.sql.Date;

public class Reservacion {
	private int idReservacion;
	private Date fechaLlegada;
	private Date fechaSalida;
	private int numPersonas;
	private String tipoHabitacion;
	private double precio;
	private int idCliente;
	private String status;
	
	public Reservacion() {}
	/**
	 * @param idReservacion
	 * @param fechaLlegada
	 * @param fechaSalida
	 * @param numPersonas
	 * @param tipoHabitacion
	 * @param precio
	 * @param idCliente
	 */
	public Reservacion(int idReservacion, Date fechaLlegada, Date fechaSalida, int numPersonas,
			String tipoHabitacion, double precio, int idCliente, String status) {
		this.idReservacion = idReservacion;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.precio = precio;
		this.idCliente = idCliente;
		this.status = status;
	}
	
	/**
	 * @param fechaLlegada
	 * @param fechaSalida
	 * @param numPersonas
	 * @param tipoHabitacion
	 * @param precio
	 * @param idCliente
	 */
	public Reservacion(Date fechaLlegada, Date fechaSalida, int numPersonas,
			 String tipoHabitacion, double precio, int idCliente) {
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.precio = precio;
		this.idCliente = idCliente;
	}
	
	/**
	 * @param idReservacion
	 */
	public Reservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}

	/**
	 * @return the idReservacion
	 */
	public int getIdReservacion() {
		return idReservacion;
	}

	/**
	 * @param idReservacion the idReservacion to set
	 */
	public void setIdReservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}

	/**
	 * @return the fechaLlegada
	 */
	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * @param fechaLlegada the fechaLlegada to set
	 */
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the numPersonas
	 */
	public int getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas the numPersonas to set
	 */
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the tipoHabitacion
	 */
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	/**
	 * @param tipoHabitacion the tipoHabitacion to set
	 */
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
