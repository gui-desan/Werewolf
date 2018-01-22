package game.model;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = -4622734590525123953L;
	private RequestType requestType;
	private Object args;
	
	public Request(RequestType requestType, Object... args) {
		
	}

	public enum RequestType {
		
	}
}
