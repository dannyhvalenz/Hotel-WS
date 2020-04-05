package model;

public class Habitacion {
	public int numHabitacion;
	public int piso;
	public int numCamas;
	public int cupoPersona;
	public String tipoHabitacion; //individual, doble, suite
	public String status; //ocupada y desocupada
	
	public Habitacion(int piso, int numCamas, int cupoPersona, String tipoHabitacion, String status) {
		this.piso = piso;
		this.numCamas = numCamas;
		this.cupoPersona = cupoPersona;
		this.tipoHabitacion = tipoHabitacion;
		this.status = status;
	}
	
	public Habitacion(int numHabitacion, int piso, int numCamas, int cupoPersona, String tipoHabitacion,
			String status) {
		this.numHabitacion = numHabitacion;
		this.piso = piso;
		this.numCamas = numCamas;
		this.cupoPersona = cupoPersona;
		this.tipoHabitacion = tipoHabitacion;
		this.status = status;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public int getCupoPersona() {
		return cupoPersona;
	}

	public void setCupoPersona(int cupoPersona) {
		this.cupoPersona = cupoPersona;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
