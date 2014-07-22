package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "identity", "request", "filter" })
@XmlRootElement(name = "ABESubmit")
public class ABESubmit {

	protected String identity;
	protected String request;
	protected String filter;

	/**
	 * Gets the value of the identity property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * Sets the value of the identity property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdentity(String value) {
		this.identity = value;
	}

	/**
	 * Gets the value of the request property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * Sets the value of the request property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRequest(String value) {
		this.request = value;
	}

	/**
	 * Gets the value of the filter property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * Sets the value of the filter property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFilter(String value) {
		this.filter = value;
	}

}
