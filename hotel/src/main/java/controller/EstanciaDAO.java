package controller;

import java.sql.SQLException;
import java.util.Date;

import database.ConexionAWS;

public class EstanciaDAO {
	private int idEstancia;
	private int numHabitacion;
	private int numAdultos;
	private int numNinos;
	private double precio;
	private Date fechaCheckIn;
	private Date fechaCheckOut;
	private int idCliente;
	
	private ConexionAWS database;

	/**
	 * @param idEstancia
	 * @param numHabitacion
	 * @param numAdultos
	 * @param numNinos
	 * @param precio
	 * @param fechaCheckIn
	 * @param fechaCheckOut
	 * @param idCliente
	 * @param database
	 */
	public EstanciaDAO(int idEstancia, int numHabitacion, int numAdultos, int numNinos, double precio,
			Date fechaCheckIn, Date fechaCheckOut, int idCliente) {
		this.idEstancia = idEstancia;
		this.numHabitacion = numHabitacion;
		this.numAdultos = numAdultos;
		this.numNinos = numNinos;
		this.precio = precio;
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.idCliente = idCliente;
	}
	
	 /**
	 * @param idEstancia
	 * @param fechaCheckOut
	 */
	public EstanciaDAO(int idEstancia, Date fechaCheckOut) {
		this.idEstancia = idEstancia;
		this.fechaCheckOut = fechaCheckOut;
	}
	
	/** 
	 * @param idEstancia
	 */
	public EstanciaDAO(int idEstancia) {
		this.idEstancia = idEstancia;
	}
	
	/**
	 * @return the idEstancia
	 */
	public int getIdEstancia() {
		return idEstancia;
	}
	
	/**
	 * Metodo para agregar una estancia
	 * @return
	 */
	public boolean registrarCheckIn() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"INSERT INTO estancias (numHabitacion, numAdultos, numNinos, precio, fechaCheckIn, fechaCheckOut, idCliente) VALUES "
					+ "('"+this.numHabitacion+"','"+this.numAdultos+"','"+this.numNinos+"','"+this.precio+"','"+this.fechaCheckIn
					+"','"+this.fechaCheckOut+"','"+this.idCliente+"')");
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	
	/**
	 * Metodo para aplazar a una estancia en la Base de Datos
	 * @return true si se actualizo la estancia de forma exitosa en la BD
	 */
	public boolean aplazarEstancia() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"UPDATE estancias SET "
							+ "numHabitacion = "+this.numHabitacion
							+ " ,numAdultos = "+this.numAdultos
							+ " ,numNinos = "+this.numNinos
							+ " ,precio = "+this.precio
							+ " ,fechaCheckIn = '"+this.fechaCheckIn+"'"
							+ " ,fechaCheckOut = '"+this.fechaCheckOut+"'"
							+ " ,idCliente = "+this.idCliente
							+ " WHERE idEstancia = "+this.idEstancia);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * @return true si se elimina la estancia de forma exitosa
	 */
	public boolean registrarCheckOut() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"DELETE FROM estancias WHERE idEstancia = "+this.idEstancia);
			resultado = true;				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
}
