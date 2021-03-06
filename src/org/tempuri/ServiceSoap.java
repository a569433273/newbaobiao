package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "ServiceSoap", targetNamespace = "http://tempuri.org/")
public interface ServiceSoap {

	/**
	 * 
	 * @param identity
	 * @param request
	 * @param filter
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "ABESubmit", action = "http://tempuri.org/ABESubmit")
	@WebResult(name = "ABESubmitResult", targetNamespace = "http://tempuri.org/")
	@RequestWrapper(localName = "ABESubmit", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ABESubmit")
	@ResponseWrapper(localName = "ABESubmitResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ABESubmitResponse")
	public String abeSubmit(
			@WebParam(name = "identity", targetNamespace = "http://tempuri.org/") String identity,
			@WebParam(name = "request", targetNamespace = "http://tempuri.org/") String request,
			@WebParam(name = "filter", targetNamespace = "http://tempuri.org/") String filter);

	/**
	 * 
	 * @param abeConnectionString
	 * @param userName
	 * @param password
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "CreateSession", action = "http://tempuri.org/CreateSession")
	@WebResult(name = "CreateSessionResult", targetNamespace = "http://tempuri.org/")
	@RequestWrapper(localName = "CreateSession", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateSession")
	@ResponseWrapper(localName = "CreateSessionResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateSessionResponse")
	public String createSession(
			@WebParam(name = "ABEConnectionString", targetNamespace = "http://tempuri.org/") String abeConnectionString,
			@WebParam(name = "UserName", targetNamespace = "http://tempuri.org/") String userName,
			@WebParam(name = "Password", targetNamespace = "http://tempuri.org/") String password);

	/**
	 * 
	 * @param passportID
	 * @param userName
	 * @param password
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "ClearSession", action = "http://tempuri.org/ClearSession")
	@WebResult(name = "ClearSessionResult", targetNamespace = "http://tempuri.org/")
	@RequestWrapper(localName = "ClearSession", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ClearSession")
	@ResponseWrapper(localName = "ClearSessionResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ClearSessionResponse")
	public String clearSession(
			@WebParam(name = "PassportID", targetNamespace = "http://tempuri.org/") String passportID,
			@WebParam(name = "UserName", targetNamespace = "http://tempuri.org/") String userName,
			@WebParam(name = "Password", targetNamespace = "http://tempuri.org/") String password);

	/**
	 * 
	 * @param identity
	 * @param request
	 * @param filter
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "ABE_SendCommand_1_2", action = "http://tempuri.org/ABE_SendCommand_1_2")
	@WebResult(name = "ABE_SendCommand_1_2Result", targetNamespace = "http://tempuri.org/")
	@RequestWrapper(localName = "ABE_SendCommand_1_2", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ABESendCommand12")
	@ResponseWrapper(localName = "ABE_SendCommand_1_2Response", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ABESendCommand12Response")
	public String abeSendCommand12(
			@WebParam(name = "identity", targetNamespace = "http://tempuri.org/") String identity,
			@WebParam(name = "request", targetNamespace = "http://tempuri.org/") String request,
			@WebParam(name = "filter", targetNamespace = "http://tempuri.org/") String filter);

}
