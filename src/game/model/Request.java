package game.model;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = -4622734590525123953L;
	private RequestType requestType;
	private Object[] params;
	
	public Request(RequestType requestType, Object[] params) {
		this.requestType = requestType;
		this.params = params;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public Object getParams(int index) {
		return params[index];
	}

	public enum RequestType {
		
	}
}
