package ca.toronto.commoncomponents.response;

import java.io.Serializable;

public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5998776765997851714L;

	private String status;

	private String message;

	private T json;

	public Response() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getJson() {
		return json;
	}

	public void setJson(T json) {
		this.json = json;
	}

}
