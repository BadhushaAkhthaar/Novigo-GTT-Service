package com.novigo.app.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import javax.xml.soap.SOAPMessage;

import org.springframework.stereotype.Service;

import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class GTTService {
	public static final MediaType XML = MediaType.get("text/xml; charset=utf-8");
	public static void PostSOAP(String xmlMessage) throws IOException {
//		OkHttpClient client = new OkHttpClient();
//		RequestBody requestBody = RequestBody.create(XML, xmlMessage);
//		Request request = new Request.Builder()
//		        .url("https://novigolbn.gtt-flp-lbnplatform.cfapps.eu10.hana.ondemand.com/api/idoc/em/v1/TrackedProcessAndEvent")
//		        .addHeader("Authorization", Credentials.basic("novigo123.gtt@gmail.com","Novigo123!"))
//		        .post(requestBody)
//		        .build();
//		Call call = client.newCall(request);
//	    try {
//			Response response = call.execute();
//			String hello = Check();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			URL baseUrl = new URL("https://novigolbn.gtt-flp-lbnplatform.cfapps.eu10.hana.ondemand.com/api/idoc/em/v1/TrackedProcessAndEvent");
//			HttpURLConnection conn = (HttpURLConnection) baseUrl.openConnection();
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
//			conn.setRequestProperty("Authorization","bm92aWdvMTIzLmd0dEBnbWFpbC5jb206Tm92aWdvMTIzIQ==");
//			conn.setDoOutput(true);
//			DataOutputStream dOutput = new DataOutputStream(conn.getOutputStream());
//			dOutput.writeBytes(xmlMessage);
//			dOutput.flush();
//			dOutput.close();
//			
//			int responseStatus = conn.getResponseCode();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(
			       URI.create("https://novigolbn.gtt-flp-lbnplatform.cfapps.eu10.hana.ondemand.com/api/idoc/em/v1/TrackedProcessAndEvent"))
			   .header("Content-Type", "text/xml; charset=utf-8")
			   .header("Authorization","Basic bm92aWdvMTIzLmd0dEBnbWFpbC5jb206Tm92aWdvMTIzIQ==")
			   .POST(HttpRequest.BodyPublishers.ofString(xmlMessage))
			   .build();
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String hello = Check();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String Check() {
		return "Hello";
	}
}
