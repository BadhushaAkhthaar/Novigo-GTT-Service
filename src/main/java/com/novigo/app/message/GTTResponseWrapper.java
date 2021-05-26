package com.novigo.app.message;

import java.util.List;

public class GTTResponseWrapper {

	private static final long serialVersionUID = 1L;
	
	private GTTResponse message = new GTTResponse("",100,"");
	private List<GTTResponse> messages ;
	
	private static final GTTResponseWrapper INSTANCE = new GTTResponseWrapper();
	
	public GTTResponseWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static GTTResponseWrapper getInstance() {
		return INSTANCE;
	}

	public GTTResponseWrapper(List<GTTResponse> messages) {
		super();
		messages.add(message);
		this.messages = messages;
	}

	public List<GTTResponse> getMessages() {
		return messages;
	}

	public void setMessages(List<GTTResponse> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "GTTResponseWrapper [messages=" + messages + "]";
	}
	
	
}
