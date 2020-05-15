//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.15 at 01:10:01 AM CDT 
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
 *                   &lt;element name="numAdultos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="numNinos" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="numAdultos" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="numNinos" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "numAdultos",
        "numNinos",
        "tipoHabitacion",
        "fechaLlegada",
        "fechaSalida",
        "precio",
        "idCliente",
        "idReservacion",
        "status"
    })
    public static class Reservacion {

        protected int numAdultos;
        protected int numNinos;
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
        
        public Reservacion(int numAdultos, int numNinos, String tipoHabitacion, String fechaLlegada, String fechaSalida,
				double precio, int idCliente, int idReservacion, String status) {
			super();
			this.numAdultos = numAdultos;
			this.numNinos = numNinos;
			this.tipoHabitacion = tipoHabitacion;
			this.fechaLlegada = fechaLlegada;
			this.fechaSalida = fechaSalida;
			this.precio = precio;
			this.idCliente = idCliente;
			this.idReservacion = idReservacion;
			this.status = status;
		}

		/**
         * Gets the value of the numAdultos property.
         * 
         */
        public int getNumAdultos() {
            return numAdultos;
        }

        /**
         * Sets the value of the numAdultos property.
         * 
         */
        public void setNumAdultos(int value) {
            this.numAdultos = value;
        }

        /**
         * Gets the value of the numNinos property.
         * 
         */
        public int getNumNinos() {
            return numNinos;
        }

        /**
         * Sets the value of the numNinos property.
         * 
         */
        public void setNumNinos(int value) {
            this.numNinos = value;
        }

        /**
         * Gets the value of the tipoHabitacion property.
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
         * Sets the value of the tipoHabitacion property.
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
         * Gets the value of the fechaLlegada property.
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
         * Sets the value of the fechaLlegada property.
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
         * Gets the value of the fechaSalida property.
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
         * Sets the value of the fechaSalida property.
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
         * Gets the value of the precio property.
         * 
         */
        public double getPrecio() {
            return precio;
        }

        /**
         * Sets the value of the precio property.
         * 
         */
        public void setPrecio(double value) {
            this.precio = value;
        }

        /**
         * Gets the value of the idCliente property.
         * 
         */
        public int getIdCliente() {
            return idCliente;
        }

        /**
         * Sets the value of the idCliente property.
         * 
         */
        public void setIdCliente(int value) {
            this.idCliente = value;
        }

        /**
         * Gets the value of the idReservacion property.
         * 
         */
        public int getIdReservacion() {
            return idReservacion;
        }

        /**
         * Sets the value of the idReservacion property.
         * 
         */
        public void setIdReservacion(int value) {
            this.idReservacion = value;
        }

        /**
         * Gets the value of the status property.
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
         * Sets the value of the status property.
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
