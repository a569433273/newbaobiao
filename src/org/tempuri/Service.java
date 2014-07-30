package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * Service service = new Service();
 * ServiceSoap portType = service.getServiceSoap();
 * portType.abeSubmit(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "Service", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://119.161.188.35:570/WebABE.asmx?wsdl")
public class Service extends javax.xml.ws.Service {

	private final static URL SERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(org.tempuri.Service.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = org.tempuri.Service.class.getResource(".");
			url = new URL(baseUrl, "http://119.161.188.35:570/WebABE.asmx?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://119.161.188.35:570/WebABE.asmx?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		SERVICE_WSDL_LOCATION = url;
	}

	public Service(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public Service() {
		super(SERVICE_WSDL_LOCATION,
				new QName("http://tempuri.org/", "Service"));
	}

	/**
	 * 
	 * @return returns ServiceSoap
	 */
	@WebEndpoint(name = "ServiceSoap")
	public ServiceSoap getServiceSoap() {
		return super.getPort(new QName("http://tempuri.org/", "ServiceSoap"),
				ServiceSoap.class);
	}

	/**
	 * 
	 * @return returns ServiceSoap
	 */
	@WebEndpoint(name = "ServiceSoap12")
	public ServiceSoap getServiceSoap12() {
		return super.getPort(new QName("http://tempuri.org/", "ServiceSoap12"),
				ServiceSoap.class);
	}

	/**
	 * 
	 * @return returns ServiceHttpGet
	 */
	@WebEndpoint(name = "ServiceHttpGet")
	public ServiceHttpGet getServiceHttpGet() {
		return super.getPort(
				new QName("http://tempuri.org/", "ServiceHttpGet"),
				ServiceHttpGet.class);
	}

	/**
	 * 
	 * @return returns ServiceHttpPost
	 */
	@WebEndpoint(name = "ServiceHttpPost")
	public ServiceHttpPost getServiceHttpPost() {
		return super.getPort(
				new QName("http://tempuri.org/", "ServiceHttpPost"),
				ServiceHttpPost.class);
	}

}