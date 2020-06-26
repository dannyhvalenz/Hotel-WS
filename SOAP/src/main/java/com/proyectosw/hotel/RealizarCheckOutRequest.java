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
 *         &lt;element name="idEstancia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaCheckOut" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "idEstancia",
    "fechaCheckOut"
})
@XmlRootElement(name = "RealizarCheckOutRequest")
public class RealizarCheckOutRequest {

    protected int idEstancia;
    @XmlElement(required = true)
    protected String fechaCheckOut;

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

}
