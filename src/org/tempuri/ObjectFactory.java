package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the org.tempuri package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _String_QNAME = new QName("http://tempuri.org/",
			"string");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: org.tempuri
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link ABESubmitResponse }
	 * 
	 */
	public ABESubmitResponse createABESubmitResponse() {
		return new ABESubmitResponse();
	}

	/**
	 * Create an instance of {@link ABESubmit }
	 * 
	 */
	public ABESubmit createABESubmit() {
		return new ABESubmit();
	}

	/**
	 * Create an instance of {@link ABESendCommand12Response }
	 * 
	 */
	public ABESendCommand12Response createABESendCommand12Response() {
		return new ABESendCommand12Response();
	}

	/**
	 * Create an instance of {@link CreateSession }
	 * 
	 */
	public CreateSession createCreateSession() {
		return new CreateSession();
	}

	/**
	 * Create an instance of {@link CreateSessionResponse }
	 * 
	 */
	public CreateSessionResponse createCreateSessionResponse() {
		return new CreateSessionResponse();
	}

	/**
	 * Create an instance of {@link ClearSessionResponse }
	 * 
	 */
	public ClearSessionResponse createClearSessionResponse() {
		return new ClearSessionResponse();
	}

	/**
	 * Create an instance of {@link ABESendCommand12 }
	 * 
	 */
	public ABESendCommand12 createABESendCommand12() {
		return new ABESendCommand12();
	}

	/**
	 * Create an instance of {@link ClearSession }
	 * 
	 */
	public ClearSession createClearSession() {
		return new ClearSession();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "string")
	public JAXBElement<String> createString(String value) {
		return new JAXBElement<String>(_String_QNAME, String.class, null, value);
	}

}
