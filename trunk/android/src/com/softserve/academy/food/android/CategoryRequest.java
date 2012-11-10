package com.softserve.academy.food.android;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class CategoryRequest
{
	private static final String SOAP_ACTION = null;
	private String URL = "http://127.0.0.1:8777/au/echo";
	private String NAMESPACE;
	private String METHOD_NAME;
	public CategoryRequest()
	{
	    try {
	        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	        request.addProperty("prop1", "myprop");
	 
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.setOutputSoapObject(request);
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(SOAP_ACTION, envelope);
	 
//	        Object result = envelope.getResponse();
//	        handle result here	 
//	        myExampleHandler.getResults();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }    
	}
}
