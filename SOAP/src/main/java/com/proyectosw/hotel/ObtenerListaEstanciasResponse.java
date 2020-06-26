//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.05.27 a las 10:35:09 PM CDT 
//


package com.proyectosw.hotel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estancia" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="numHabitacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="numPersonas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fechaCheckIn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fechaCheckOut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="idEstancia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "estancia"
})
@XmlRootElement(name = "ObtenerListaEstanciasResponse")
public class ObtenerListaEstanciasResponse {

    @XmlElement(required = true)
    protected List<ObtenerListaEstanciasResponse.Estancia> estancia;

    /**
     * Gets the value of the estancia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estancia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstancia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObtenerListaEstanciasResponse.Estancia }
     * 
     * 
     */
    public List<ObtenerListaEstanciasResponse.Estancia> getEstancia() {
        if (estancia == null) {
            estancia = new ArrayList<ObtenerListaEstanciasResponse.Estancia>();
        }
        return this.estancia;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="numHabitacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="numPersonas" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fechaCheckIn" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fechaCheckOut" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="idEstancia" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numHabitacion",
        "numPersonas",
        "tipoHabitacion",
        "fechaCheckIn",
        "fechaCheckOut",
        "status",
        "precio",
        "idCliente",
        "idEstancia"
    })
    public static class Estancia {

        protected int numHabitacion;
        protected int numPersonas;
        @XmlElement(required = true)
        protected String tipoHabitacion;
        @XmlElement(required = true)
        protected String fechaCheckIn;
        @XmlElement(required = true)
        protected String fechaCheckOut;
        @XmlElement(required = true)
        protected String status;
        protected double precio;
        protected int idCliente;
        protected int idEstancia;

        public Estancia() {}
        
        
        /**
		 * @param numHabitacion
		 * @param numPersonas
		 * @param tipoHabitacion
		 * @param fechaCheckIn
		 * @param fechaCheckOut
		 * @param status
		 * @param precio
		 * @param idCliente
		 * @param idEstancia
		 */
		public Estancia(int numHabitacion, int numPersonas, String tipoHabitacion, String fechaCheckIn,
				String fechaCheckOut, String status, double precio, int idCliente, int idEstancia) {
			this.numHabitacion = numHabitacion;
			this.numPersonas = numPersonas;
			this.tipoHabitacion = tipoHabitacion;
			this.fechaCheckIn = fechaCheckIn;
			this.fechaCheckOut = fechaCheckOut;
			this.status = status;
			this.precio = precio;
			this.idCliente = idCliente;
			this.idEstancia = idEstancia;
		}


		/**
         * Obtiene el valor de la propiedad numHabitacion.
         * 
         */
        public int getNumHabitacion() {
            return numHabitacion;
        }

        /**
         * Define el valor de la propiedad numHabitacion.
         * 
         */
        public void setNumHabitacion(int value) {
            this.numHabitacion = value;
        }

        /**
         * Obtiene el valor de la propiedad numPersonas.
         * 
         */
        public int getNumPersonas() {
            return numPersonas;
        }

        /**
         * Define el valor de la propiedad numPersonas.
         * 
         */
        public void setNumPersonas(int value) {
            this.numPersonas = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoHabitacion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoHabitacion() {
            return tipoHabitacion;
        }

        /**
         * Define el valor de la propiedad tipoHabitacion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoHabitacion(String value) {
            this.tipoHabitacion = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaCheckIn.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaCheckIn() {
            return fechaCheckIn;
        }

        /**
         * Define el valor de la propiedad fechaCheckIn.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaCheckIn(String value) {
            this.fechaCheckIn = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaCheckOut.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaCheckOut() {
            return fechaCheckOut;
        }

        /**
         * Define el valor de la propiedad fechaCheckOut.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaCheckOut(String value) {
            this.fechaCheckOut = value;
        }

        /**
         * Obtiene el valor de la propiedad status.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Define el valor de la propiedad status.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Obtiene el valor de la propiedad precio.
         * 
         */
        public double getPrecio() {
            return precio;
        }

        /**
         * Define el valor de la propiedad precio.
         * 
         */
        public void setPrecio(double value) {
            this.precio = value;
        }

        /**
         * Obtiene el valor de la propiedad idCliente.
         * 
         */
        public int getIdCliente() {
            return idCliente;
        }

        /**
         * Define el valor de la propiedad idCliente.
         * 
         */
        public void setIdCliente(int value) {
            this.idCliente = value;
        }

        /**
         * Obtiene el valor de la propiedad idEstancia.
         * 
         */
        public int getIdEstancia() {
            return idEstancia;
        }

        /**
         * Define el valor de la propiedad idEstancia.
         * 
         */
        public void setIdEstancia(int value) {
            this.idEstancia = value;
        }

    }

}
