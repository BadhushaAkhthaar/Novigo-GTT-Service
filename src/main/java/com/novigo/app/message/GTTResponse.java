package com.novigo.app.message;

import java.io.InputStream;

public class GTTResponse {
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	private int responseCode;
	private String responseBody;
	
	public GTTResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GTTResponse(String message, int responseCode, String responseBody) {
		super();
		this.message = message;
		this.responseCode = responseCode;
		this.responseBody = responseBody;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String inputStream) {
		this.responseBody = inputStream;
	}
	
	
}
