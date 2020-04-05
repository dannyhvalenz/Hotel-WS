package model;

import java.util.Date;

public class Estancia {
	private int idEstancia;
	private int numHabitacion;
	private int numAdultos;
	private int numNinos;
	private double precio;
	private Date fechaCheckIn;
	private Date fechaCheckOut;
	private int idCliente;
	
	/**
	 * @param idEstancia
	 * @param numHabitacion
	 * @param numAdultos
	 * @param numNinos
	 * @param precio
	 * @param fechaCheckIn
	 * @param fechaCheckOut
	 * @param idCliente
	 */
	public Estancia(int idEstancia, int numHabitacion, int numAdultos, int numNinos, double precio, Date fechaCheckIn,
			Date fechaCheckOut, int idCliente) {
		this.idEstancia = idEstancia;
		this.numHabitacion = numHabitacion;
		this.numAdultos = numAdultos;
		this.numNinos = numNinos;
		this.precio = precio;
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.idCliente = idCliente;
	}
	
	public Estancia(int idEstancia) {
		this.idEstancia = idEstancia;
	}
	
	public Estancia(int idEstancia, Date fechaCheckOut) {
		this.idEstancia = idEstancia;
		this.fechaCheckOut = fechaCheckOut;
	}

	/**
	 * @return the idEstancia
	 */
	public int getIdEstancia() {
		return idEstancia;
	}

	/**
	 * @param idEstancia the idEstancia to set
	 */
	public void setIdEstancia(int idEstancia) {
		this.idEstancia = idEstancia;
	}

	/**
	 * @return the numHabitacion
	 */
	public int getNumHabitacion() {
		return numHabitacion;
	}

	/**
	 * @param numHabitacion the numHabitacion to set
	 */
	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	/**
	 * @return the numAdultos
	 */
	public int getNumAdultos() {
		return numAdultos;
	}

	/**
	 * @param numAdultos the numAdultos to set
	 */
	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}

	/**
	 * @return the numNinos
	 */
	public int getNumNinos() {
		return numNinos;
	}

	/**
	 * @param numNinos the numNinos to set
	 */
	public void setNumNinos(int numNinos) {
		this.numNinos = numNinos;
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
	 * @return the fechaCheckIn
	 */
	public Date getFechaCheckIn() {
		return fechaCheckIn;
	}

	/**
	 * @param fechaCheckIn the fechaCheckIn to set
	 */
	public void setFechaCheckIn(Date fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}

	/**
	 * @return the fechaCheckOut
	 */
	public Date getFechaCheckOut() {
		return fechaCheckOut;
	}

	/**
	 * @param fechaCheckOut the fechaCheckOut to set
	 */
	public void setFechaCheckOut(Date fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
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
	
	
	
}
