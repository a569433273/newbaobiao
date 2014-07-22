package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="ABE_SendCommand_1_2Result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "abeSendCommand12Result" })
@XmlRootElement(name = "ABE_SendCommand_1_2Response")
public class ABESendCommand12Response {

	@XmlElement(name = "ABE_SendCommand_1_2Result")
	protected String abeSendCommand12Result;

	/**
	 * Gets the value of the abeSendCommand12Result property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getABESendCommand12Result() {
		return abeSendCommand12Result;
	}

	/**
	 * Sets the value of the abeSendCommand12Result property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setABESendCommand12Result(String value) {
		this.abeSendCommand12Result = value;
	}

}
