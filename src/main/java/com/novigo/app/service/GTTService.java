package com.novigo.app.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
//import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.xml.soap.SOAPMessage;

import org.springframework.stereotype.Service;

import com.novigo.app.helpers.GTTResponseHelper;
import com.novigo.app.message.GTTResponse;
import com.novigo.app.message.GTTResponseWrapper;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import com.sap.cloud.sdk.cloudplatform.security.BasicCredentials;

import io.vavr.control.Option;
import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GTTService {
	public static final MediaType XML = MediaType.get("text/xml; charset=utf-8");

	public static String SUCCESS = "Successfully created : ";
	public static String FAILED = "Failed to create : ";

	public static void PostSOAP(String xmlMessage, String appObjId) throws IOException {

		String gtt_destination_name = System.getenv("GTT_DESTINATION");
		Destination destObj = DestinationAccessor.getDestination(gtt_destination_name);
		HttpDestination destHttp = destObj.asHttp();
		URI destBaseUrl = destHttp.getUri();
		Option<BasicCredentials> basicCred = destHttp.getBasicCredentials();
		String credString = basicCred.get().getUsername() + ":" + basicCred.get().getPassword();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(destBaseUrl.toString());
		StringEntity strEntity = new StringEntity(xmlMessage);
		httpPost.setEntity(strEntity);
		httpPost.setHeader("Content-type", "text/xml; charset=utf-8");
		httpPost.setHeader("Authorization", "Basic " + Base64.encodeBase64String(credString.getBytes()));

		CloseableHttpResponse response = client.execute(httpPost);

		GTTResponseHelper messageHelper = new GTTResponseHelper();
		messageHelper.createMessage(response, appObjId);
		client.close();

	}

	public static String Check() {
		return "Hello";
	}
}
