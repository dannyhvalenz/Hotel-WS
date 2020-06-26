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
 *         &lt;element name="cliente" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="formaPago" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cliente"
})
@XmlRootElement(name = "ObtenerListaClientesResponse")
public class ObtenerListaClientesResponse {

    @XmlElement(required = true)
    protected List<ObtenerListaClientesResponse.Cliente> cliente;

    /**
     * Gets the value of the cliente property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cliente property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCliente().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObtenerListaClientesResponse.Cliente }
     * 
     * 
     */
    public List<ObtenerListaClientesResponse.Cliente> getCliente() {
        if (cliente == null) {
            cliente = new ArrayList<ObtenerListaClientesResponse.Cliente>();
        }
        return this.cliente;
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
     *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="formaPago" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "idCliente",
        "nombre",
        "apellido",
        "telefono",
        "correo",
        "formaPago"
    })
    public static class Cliente {

        protected int idCliente;
        @XmlElement(required = true)
        protected String nombre;
        @XmlElement(required = true)
        protected String apellido;
        @XmlElement(required = true)
        protected String telefono;
        @XmlElement(required = true)
        protected String correo;
        @XmlElement(required = true)
        protected String formaPago;

        public Cliente() {}
        
        /**
		 * @param idCliente
		 * @param nombre
		 * @param apellido
		 * @param telefono
		 * @param correo
		 * @param formaPago
		 */
		public Cliente(int idCliente, String nombre, String apellido, String telefono, String correo,
				String formaPago) {
			this.idCliente = idCliente;
			this.nombre = nombre;
			this.apellido = apellido;
			this.telefono = telefono;
			this.correo = correo;
			this.formaPago = formaPago;
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
         * Obtiene el valor de la propiedad nombre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad apellido.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApellido() {
            return apellido;
        }

        /**
         * Define el valor de la propiedad apellido.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApellido(String value) {
            this.apellido = value;
        }

        /**
         * Obtiene el valor de la propiedad telefono.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelefono() {
            return telefono;
        }

        /**
         * Define el valor de la propiedad telefono.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelefono(String value) {
            this.telefono = value;
        }

        /**
         * Obtiene el valor de la propiedad correo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorreo() {
            return correo;
        }

        /**
         * Define el valor de la propiedad correo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorreo(String value) {
            this.correo = value;
        }

        /**
         * Obtiene el valor de la propiedad formaPago.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormaPago() {
            return formaPago;
        }

        /**
         * Define el valor de la propiedad formaPago.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormaPago(String value) {
            this.formaPago = value;
        }

    }

}
