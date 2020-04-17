package model;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String formaPago;
	
	/**
	 * Constructor vacio
	 */
	public Cliente() {}
	
	/**
	 * 
	 * @param idCliente
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param correo
	 * @param formaPago
	 */
	public Cliente(int idCliente, String nombre, String apellido, String telefono, String correo, String formaPago) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.formaPago = formaPago;
	}
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param correo
	 * @param formaPago
	 */
	public Cliente(String nombre, String apellido, String telefono, String correo, String formaPago) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.formaPago = formaPago;
	}

	/**
	 * 
	 * @return idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * 
	 * @param idCliente
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * 
	 * @return formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * 
	 * @param formaPago
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
}