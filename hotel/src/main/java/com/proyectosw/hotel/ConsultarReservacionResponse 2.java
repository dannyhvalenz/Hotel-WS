//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.16 at 10:18:58 PM CDT 
//


package com.proyectosw.hotel;

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
 *         &lt;element name="fechaLlegada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numAdultos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numNinos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCamas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "fechaLlegada",
    "fechaSalida",
    "numAdultos",
    "numNinos",
    "numCamas",
    "tipoHabitacion",
    "idCliente",
    "precio"
})
@XmlRootElement(name = "ConsultarReservacionResponse")
public class ConsultarReservacionResponse {

    @XmlElement(required = true)
    protected String fechaLlegada;
    @XmlElement(required = true)
    protected String fechaSalida;
    protected int numAdultos;
    protected int numNinos;
    protected int numCamas;
    @XmlElement(required = true)
    protected String tipoHabitacion;
    protected int idCliente;
    protected double precio;

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
     * Gets the value of the numCamas property.
     * 
     */
    public int getNumCamas() {
        return numCamas;
    }

    /**
     * Sets the value of the numCamas property.
     * 
     */
    public void setNumCamas(int value) {
        this.numCamas = value;
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

}