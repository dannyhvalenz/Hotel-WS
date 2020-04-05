package controller;

import java.sql.SQLException;

import database.ConexionAWS;

public class ClienteDAO {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String formaPago;
	
	private ConexionAWS database;
	
	/**
	 * Constructor de cliente para registrar al cliente
	 * @param nombre, apellido, telefono, correo, formaPago
	 */
	public ClienteDAO(String nombre,String apellido, String telefono, String correo, String formaPago) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.formaPago = formaPago;
	}
	
	/**
	 * Constructor de cliente para actualizar al cliente
	 * @param idCliente, nombre, apellido, telefono, correo, formaPago
	 */
	public ClienteDAO(int idCliente, String nombre,String apellido, String telefono, String correo, String formaPago) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.formaPago = formaPago;
	}
	
	/**
	 * Metodo para registrar un cliente en la Base de Datos
	 * @return true si se registro el cliente de forma exitosa en la BD
	 */
	public boolean registrarCliente() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"INSERT INTO cliente (nombre,apellido,telefono,correo,formaPago) VALUES "
					+ "('"+this.nombre+"','"+this.apellido+"','"+this.telefono+"','"+this.correo
					+"','"+this.formaPago+"')");
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	
	/**
	 * Metodo para actualizar a un cliente en la Base de Datos
	 * @return true si se actualizo el cliente de forma exitosa en la BD
	 */
	public boolean actualizarCliente() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"UPDATE cliente SET "
					+ "nombre = '"+this.nombre+"'"
					+ "apellido = '"+this.apellido+"'"
					+ "telefono = '"+this.telefono+"'"
					+ "correo = '"+this.correo+"'"
					+ "formaPago = '"+this.formaPago+"'"
					+ "WHERE idCliente = "+this.idCliente);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * Metodo para eliminar a un cliente de la Base de Datos
	 * @return true si se elimina el cliente de forma exitosa
	 */
	public boolean eliminarCliente() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"DELETE FROM cliente WHERE idCliente = "+this.idCliente);
							
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
}
