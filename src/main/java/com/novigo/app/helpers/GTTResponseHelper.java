package com.novigo.app.helpers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.novigo.app.message.GTTResponse;
import com.novigo.app.message.GTTResponseWrapper;

public class GTTResponseHelper {
	public static String SUCCESS = "Successfully created : ";
	public static String FAILED = "Failed to create : ";

	public static void createMessage(CloseableHttpResponse response, String appObjId)
			throws UnsupportedOperationException, IOException {
		GTTResponseWrapper messageObj = GTTResponseWrapper.getInstance();

		List<GTTResponse> allMessages = messageObj.getMessages();

		if (allMessages == null) {
			allMessages = new ArrayList<GTTResponse>();

			GTTResponse gttMessage = new GTTResponse();
			gttMessage.setMessage(
					response.getStatusLine().getStatusCode() == 200 ? SUCCESS + appObjId : FAILED + appObjId);
			HttpEntity bodyEntity = response.getEntity();
			gttMessage.setResponseBody(bodyEntity == null ? "Empty" : EntityUtils.toString(bodyEntity));
			gttMessage.setResponseCode(response.getStatusLine().getStatusCode());

			allMessages.add(gttMessage);
			messageObj.setMessages(allMessages);
		} else {
			GTTResponse gttMessage = new GTTResponse();
			gttMessage.setMessage(
					response.getStatusLine().getStatusCode() == 200 ? SUCCESS + appObjId : FAILED + appObjId);
			HttpEntity bodyEntity = response.getEntity();
			gttMessage.setResponseBody(bodyEntity == null ? "Empty" : EntityUtils.toString(bodyEntity));
			gttMessage.setResponseCode(response.getStatusLine().getStatusCode());

			allMessages.add(gttMessage);
			messageObj.setMessages(allMessages);
		}
	}

	public static void createMessage(String messageReason,String field) {
		GTTResponseWrapper messageObj = GTTResponseWrapper.getInstance();

		List<GTTResponse> allMessages = messageObj.getMessages();
		if (allMessages == null) {
			allMessages = new ArrayList<GTTResponse>();

			GTTResponse gttMessage = new GTTResponse();
			gttMessage.setMessage(FAILED);
			gttMessage.setResponseBody("Unsupported Excel Format");
			gttMessage.setResponseCode(500);

			allMessages.add(gttMessage);
			messageObj.setMessages(allMessages);
		} else {
			GTTResponse gttMessage = new GTTResponse();
			gttMessage.setMessage(FAILED);
			gttMessage.setResponseBody("Unsupported Excel Format");
			gttMessage.setResponseCode(500);
			allMessages.add(gttMessage);
			messageObj.setMessages(allMessages);
		}
	}

	public static List<GTTResponse> getMessages() {
		GTTResponseWrapper messageObj = GTTResponseWrapper.getInstance();
		return messageObj.getMessages();
	}
	
	public static void clearMessages() {
		GTTResponseWrapper messageObj = GTTResponseWrapper.getInstance();
		messageObj.getMessages().clear();
	}
}
