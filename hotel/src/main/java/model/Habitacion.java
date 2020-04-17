package model;

public class Habitacion {
	public int numHabitacion;
	public int piso;
	public int numCamas;
	public int cupoPersonas;
	public String tipoHabitacion; //individual, doble, suite
	public String status; //ocupada y desocupada
	
	/**
	 * 
	 * @param piso
	 * @param numCamas
	 * @param cupoPersonas
	 * @param tipoHabitacion
	 * @param status
	 */
	public Habitacion(int piso, int numCamas, int cupoPersonas, String tipoHabitacion, String status) {
		this.piso = piso;
		this.numCamas = numCamas;
		this.cupoPersonas = cupoPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.status = status;
	}
	
	/**
	 * 
	 * @param numHabitacion
	 * @param piso
	 * @param numCamas
	 * @param cupoPersonas
	 * @param tipoHabitacion
	 * @param status
	 */
	public Habitacion(int numHabitacion, int piso, int numCamas, int cupoPersonas, String tipoHabitacion,
			String status) {
		this.numHabitacion = numHabitacion;
		this.piso = piso;
		this.numCamas = numCamas;
		this.cupoPersonas = cupoPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.status = status;
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
	 * @return the piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * @param piso the piso to set
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}

	/**
	 * @return the numCamas
	 */
	public int getNumCamas() {
		return numCamas;
	}

	/**
	 * @param numCamas the numCamas to set
	 */
	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	/**
	 * @return the cupoPersonas
	 */
	public int getCupoPersonas() {
		return cupoPersonas;
	}

	/**
	 * @param cupoPersonas the cupoPersonas to set
	 */
	public void setCupoPersonas(int cupoPersonas) {
		this.cupoPersonas = cupoPersonas;
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
