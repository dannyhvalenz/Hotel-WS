package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;

import database.ConexionAWS;
import model.Cliente;
import model.Estancia;
import model.Reservacion;
import com.proyectosw.hotel.ObtenerListaEstanciasResponse;

public class EstanciaDAO {
	private int idEstancia;
	private int numHabitacion;
	private int numAdultos;
	private int numNinos;
	private double precio;
	private Date fechaCheckIn;
	private Date fechaCheckOut;
	private String tipoHabitacion;
	private String status;
	private int idCliente;
	
	private ConexionAWS database;

	
	public EstanciaDAO() {}
	/**
	 * @param idEstancia
	 * @param numHabitacion
	 * @param numAdultos
	 * @param numNinos
	 * @param fechaCheckIn
	 * @param fechaCheckOut
	 * @param idCliente
	 * @param database
	 */
	public EstanciaDAO(int idEstancia, int numHabitacion, int numAdultos, int numNinos, 
			String fechaCheckIn, String fechaCheckOut, String tipoHabitacion,  
			int idCliente) {
		this.idEstancia = idEstancia;
		this.numHabitacion = numHabitacion;
		this.numAdultos = numAdultos;
		this.numNinos = numNinos;
		this.fechaCheckIn = Date.valueOf(fechaCheckIn);
		this.fechaCheckOut = Date.valueOf(fechaCheckOut);
		this.tipoHabitacion = tipoHabitacion;
		this.idCliente = idCliente;
		this.status = "check-in";
	}
	
	/**
	 * 
	 * @param numHabitacion
	 * @param numAdultos
	 * @param numNinos
	 * @param fechaCheckIn
	 * @param fechaCheckOut
	 * @param idCliente
	 */
	public EstanciaDAO(int numHabitacion, int numAdultos, int numNinos, String fechaCheckIn, 
			String fechaCheckOut, String tipoHabitacion, int idCliente) {
		this.numHabitacion = numHabitacion;
		this.numAdultos = numAdultos;
		this.numNinos = numNinos;
		this.fechaCheckIn = Date.valueOf(fechaCheckIn);
		this.fechaCheckOut = Date.valueOf(fechaCheckOut);
		this.tipoHabitacion = tipoHabitacion;
		this.idCliente = idCliente;
	}
	
	 /**
	 * @param idEstancia
	 * @param fechaCheckOut
	 */
	public EstanciaDAO(int idEstancia, String fechaCheckOut) {
		this.idEstancia = idEstancia;
		this.fechaCheckOut = Date.valueOf(fechaCheckOut);
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

	/**
	 * Metodo para agregar una estancia
	 * @return true si fue exitosa y false si fue fallida
	 */
	public boolean realizarCheckIn() {
		getPrecio(this.fechaCheckIn, this.fechaCheckOut);
		boolean resultado = false;
		this.status = "Check-In";
		this.database = new ConexionAWS();
		try {
			this.database.connect().createStatement().execute(
					"INSERT INTO estancias (numHabitacion, numAdultos, numNinos, precio, fechaCheckIn, fechaCheckOut, status, tipoHabitacion, idCliente) VALUES "
					+ "('"+this.numHabitacion+"','"+this.numAdultos+"','"+this.numNinos+"','"+this.precio+"','"+this.fechaCheckIn
					+"','"+this.fechaCheckOut+"','"+this.status+"','"+"','"+this.tipoHabitacion+"','"+this.idCliente+"')");
			this.database.connect().createStatement().execute(
					"UPDATE habitaciones SET status = 'Ocupada' WHERE numHabitacion='"+this.numHabitacion+"'");
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/**
	 * Metodo para obtener la fecha del check in y el tipo de habitacion
	 * @param id
	 */
	public void getDatosEstancia(int id) {
		this.database = new ConexionAWS();
		try {
			ResultSet rs = this.database.connect().createStatement().executeQuery("SELECT fechaCheckIn, tipoHabitacion FROM estancias WHERE idEstancia="+id);
			while(rs.next()) {
				this.fechaCheckIn = Date.valueOf(rs.getString("fechaCheckIn"));
				this.tipoHabitacion = rs.getString("tipoHabitacion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para aplazar a una estancia en la Base de Datos
	 * @return true si se actualizo la estancia de forma exitosa en la BD
	 */
	public boolean modificarEstancia() {
		System.out.println("Modificar estancia");
		boolean resultado = false;
		this.database = new ConexionAWS();
		try {
			getDatosEstancia(this.idEstancia);
			this.precio = getPrecio(this.fechaCheckIn, this.fechaCheckOut);
			this.database.connect().createStatement().execute(
					"UPDATE estancias SET "
							+ " precio = " + this.precio
							+ " ,fechaCheckOut = '" + this.fechaCheckOut+"'"
							+ " WHERE idEstancia = " + this.idEstancia);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * Metodo para realizar el check out
	 * @return true si se elimina la estancia de forma exitosa
	 */
	public boolean realizarCheckOut() {
		boolean resultado = false;
		
		this.database = new ConexionAWS();
		try {
			getDatosEstancia(this.idEstancia);
			this.precio = getPrecio(this.fechaCheckIn, this.fechaCheckOut);
			this.status = "Check-Out";
			this.database.connect().createStatement().execute(
					"UPDATE estancias SET "
							+ "fechaCheckOut = '"+this.fechaCheckOut+"'"
							+ " ,status = '"+this.status+"'"
							+ " ,precio = '"+this.precio+"'"
							+ " WHERE idEstancia = "+this.idEstancia);
			resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public double obtenerPrecio() {
		return this.precio;
	}
	
	/**
	 * Metodo para obtener el precio aproximado de la estancia
	 * @return precio
	 */
	public double getPrecio(Date fechaLlegada, Date fechaSalida) {
		double costoHabitacion = 0.0;
		
		int dias=(int) ((fechaSalida.getTime()-fechaLlegada.getTime())/86400000);
		
		switch (this.tipoHabitacion) {
			case "Individual":
				costoHabitacion = 900.0;
				this.precio = costoHabitacion * dias;
				break;
			case "Doble":
				costoHabitacion = 1300.0;
				this.precio = costoHabitacion * dias;
				break;
			case "Suite":
				costoHabitacion = 2000.0;
				this.precio = costoHabitacion * dias;
				break;
		}
		
		return this.precio;
	}
	
	/**
	 * Metodos para consultar una estancia 
	 * @param id
	 * @return estancia
	 */
	public Estancia consultarEstancia(int id) {
		Estancia estancia = null;
		this.database = new ConexionAWS();
		try {
			ResultSet rs = this.database.connect().createStatement().executeQuery("SELECT * FROM estancias WHERE idEstancia="+id);
			while(rs.next()) {
				estancia = new Estancia(rs.getInt("numHabitacion"), rs.getInt("numAdultos")
						, rs.getInt("numNinos"), rs.getDouble("precio"), rs.getDate("fechaCheckIn")
						, rs.getDate("fechaCheckOut"), rs.getString("status")
						, rs.getString("tipoHabitacion"), rs.getInt("idCliente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estancia;
	}
	
	
	public ArrayList<ObtenerListaEstanciasResponse.Estancia> getListaEstancias(){
		ArrayList<ObtenerListaEstanciasResponse.Estancia> estancias = new ArrayList<ObtenerListaEstanciasResponse.Estancia>();
		this.database = new ConexionAWS();
		try {
			ResultSet rs = this.database.connect().createStatement().executeQuery("SELECT * FROM estancias");
			while(rs.next()) {
				ObtenerListaEstanciasResponse.Estancia estancia = new ObtenerListaEstanciasResponse.Estancia(rs.getInt("numHabitacion"), rs.getInt("numAdultos")
						, rs.getInt("numNinos"), rs.getString("tipoHabitacion"),  rs.getDate("fechaCheckIn").toString()
						, rs.getDate("fechaCheckOut").toString() , rs.getString("status")
						,  rs.getDouble("precio"), rs.getInt("idCliente"), rs.getInt("idEstancia"));
				estancias.add(estancia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estancias;
	}
	
}
