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
 *         &lt;element name="reservacion" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="numPersonas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fechaLlegada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="idReservacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "reservacion"
})
@XmlRootElement(name = "ObtenerListaReservacionesResponse")
public class ObtenerListaReservacionesResponse {

    @XmlElement(required = true)
    protected List<ObtenerListaReservacionesResponse.Reservacion> reservacion;

    /**
     * Gets the value of the reservacion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservacion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservacion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObtenerListaReservacionesResponse.Reservacion }
     * 
     * 
     */
    public List<ObtenerListaReservacionesResponse.Reservacion> getReservacion() {
        if (reservacion == null) {
            reservacion = new ArrayList<ObtenerListaReservacionesResponse.Reservacion>();
        }
        return this.reservacion;
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
     *         &lt;element name="numPersonas" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fechaLlegada" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="idReservacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "numPersonas",
        "tipoHabitacion",
        "fechaLlegada",
        "fechaSalida",
        "precio",
        "idCliente",
        "idReservacion",
        "status"
    })
    public static class Reservacion {

        protected int numPersonas;
        @XmlElement(required = true)
        protected String tipoHabitacion;
        @XmlElement(required = true)
        protected String fechaLlegada;
        @XmlElement(required = true)
        protected String fechaSalida;
        protected double precio;
        protected int idCliente;
        protected int idReservacion;
        @XmlElement(required = true)
        protected String status;
        
        public Reservacion() {}
        
        

        /**
		 * @param numPersonas
		 * @param tipoHabitacion
		 * @param fechaLlegada
		 * @param fechaSalida
		 * @param precio
		 * @param idCliente
		 * @param idReservacion
		 * @param status
		 */
		public Reservacion(int numPersonas, String tipoHabitacion, String fechaLlegada, String fechaSalida,
				double precio, int idCliente, int idReservacion, String status) {
			this.numPersonas = numPersonas;
			this.tipoHabitacion = tipoHabitacion;
			this.fechaLlegada = fechaLlegada;
			this.fechaSalida = fechaSalida;
			this.precio = precio;
			this.idCliente = idCliente;
			this.idReservacion = idReservacion;
			this.status = status;
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
         * Obtiene el valor de la propiedad fechaLlegada.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaLlegada() {
            return fechaLlegada;
        }

        /**
         * Define el valor de la propiedad fechaLlegada.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaLlegada(String value) {
            this.fechaLlegada = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaSalida.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaSalida() {
            return fechaSalida;
        }

        /**
         * Define el valor de la propiedad fechaSalida.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaSalida(String value) {
            this.fechaSalida = value;
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
         * Obtiene el valor de la propiedad idReservacion.
         * 
         */
        public int getIdReservacion() {
            return idReservacion;
        }

        /**
         * Define el valor de la propiedad idReservacion.
         * 
         */
        public void setIdReservacion(int value) {
            this.idReservacion = value;
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

    }

}
