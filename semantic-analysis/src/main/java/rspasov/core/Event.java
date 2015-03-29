package rspasov.core;

import org.apache.camel.impl.DefaultMessage;

public class Event extends DefaultMessage {
	
	protected static final String HEADER_TYPE = "type"; 
	
	public String getType() {
		return getHeader(HEADER_TYPE, String.class);
	}
	
	public void setType(String type) {
		setHeader(HEADER_TYPE, type);
	}
	
	public String getBodyString() {
		return getBody(String.class);
	}

}
