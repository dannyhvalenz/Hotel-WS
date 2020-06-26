//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.05.27 a las 10:35:09 PM CDT 
//


package com.proyectosw.hotel;

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
 *         &lt;element name="numHabitacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="piso" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCamas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cupoPersonas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "numHabitacion",
    "piso",
    "numCamas",
    "cupoPersonas",
    "tipoHabitacion",
    "status"
})
@XmlRootElement(name = "AgregarHabitacionRequest")
public class AgregarHabitacionRequest {

    protected int numHabitacion;
    protected int piso;
    protected int numCamas;
    protected int cupoPersonas;
    @XmlElement(required = true)
    protected String tipoHabitacion;
    @XmlElement(required = true)
    protected String status;

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
     * Obtiene el valor de la propiedad piso.
     * 
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Define el valor de la propiedad piso.
     * 
     */
    public void setPiso(int value) {
        this.piso = value;
    }

    /**
     * Obtiene el valor de la propiedad numCamas.
     * 
     */
    public int getNumCamas() {
        return numCamas;
    }

    /**
     * Define el valor de la propiedad numCamas.
     * 
     */
    public void setNumCamas(int value) {
        this.numCamas = value;
    }

    /**
     * Obtiene el valor de la propiedad cupoPersonas.
     * 
     */
    public int getCupoPersonas() {
        return cupoPersonas;
    }

    /**
     * Define el valor de la propiedad cupoPersonas.
     * 
     */
    public void setCupoPersonas(int value) {
        this.cupoPersonas = value;
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
