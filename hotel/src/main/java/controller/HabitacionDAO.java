package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConexionAWS;
import model.Habitacion;

public class HabitacionDAO {
	private int numHabitacion;
	private int piso;
	private int numCamas;
	private int cupoPersonas;
	private String tipoHabitacion;
	private String status;
	
	private ConexionAWS database;
	
	/**
	 * @param numHabitacion
	 * @param piso
	 * @param numCamas
	 * @param cupoPersonas
	 * @param tipoHabitacion
	 * @param status
	 */
	public HabitacionDAO(int numHabitacion, int piso, int numCamas, int cupoPersonas, String tipoHabitacion,
			String status) {
		this.numHabitacion = numHabitacion;
		this.piso = piso;
		this.numCamas = numCamas;
		this.cupoPersonas = cupoPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.status = status;
	}
	
	/**
	 * @param numHabitacion
	 */
	public HabitacionDAO(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	/**
	 * @return the numHabitacion
	 */
	public int getNumHabitacion() {
		return numHabitacion;
	}
	
	/**
	 * Metodo para agregar habitacion
	 * @return
	 */
	public boolean agregarHabitacion() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"INSERT INTO habitaciones (numHabitacion, piso, numCamas, cupoPersonas, tipoHabitacion, status) VALUES "
					+ "('"+this.numHabitacion+"','"+this.piso+"','"+this.numCamas+"','"+this.cupoPersonas+"','"+this.tipoHabitacion
					+"','"+this.status+"')");
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	
	/**
	 * Metodo para actualizar a una habitacion en la Base de Datos
	 * @return true si se actualizo el cliente de forma exitosa en la BD
	 */
	public boolean actualizarHabitacion() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"UPDATE habitaciones SET "
							+ "piso = "+this.piso
							+ " ,numCamas = "+this.numCamas
							+ " ,cupoPersonas = "+this.cupoPersonas
							+ " ,tipoHabitacion = '"+this.tipoHabitacion+"'"
							+ " ,status = '"+this.status+"'"
							+ " WHERE numHabitacion = "+this.numHabitacion);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * Metodo para eliminar a una habitacion de la Base de Datos
	 * @return true si se elimina el cliente de forma exitosa
	 */
	public boolean eliminarHabitacion() {
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"DELETE FROM habitaciones WHERE numHabitacion = "+this.numHabitacion);
			resultado = true;				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Habitacion consultarHabitacion(int id) {
		Habitacion habitacion = null;
		this.database = new ConexionAWS();
		try {
			ResultSet rs = this.database.connect().createStatement().executeQuery("SELECT * FROM habitaciones WHERE numHabitacion="+id);
			while(rs.next()) {
				habitacion = new Habitacion(rs.getInt("numHabitacion"), rs.getInt("piso"), 
						rs.getInt("numCamas"), rs.getInt("cupoPersonas"), rs.getString("tipoHabitacion"),
						rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return habitacion;
	}
	
}
