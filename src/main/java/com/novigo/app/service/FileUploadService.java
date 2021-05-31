package com.novigo.app.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.dto.ApplicationsDto;
import com.novigo.app.helpers.ExcelHelper;
import com.novigo.app.helpers.GTTResponseHelper;
import com.novigo.app.message.GTTResponse;

@Service
public class FileUploadService {
	public List<GTTResponse> upload(MultipartFile file) {
		List<ApplicationsDto> allApplicationObjects = new ArrayList<>();
		List<GTTResponse> responseMessages = new ArrayList<GTTResponse>();
		try {
			allApplicationObjects = ExcelHelper.excelToJson(file.getInputStream());
			
			if(allApplicationObjects != null) {
				
				allApplicationObjects.forEach((applicationObject)->{
					try {
						ByteArrayOutputStream soapXmlByteArray = ExcelHelper.jsonToXML(applicationObject);
						String soapXmlString;
						try {
							soapXmlString = new String(soapXmlByteArray.toByteArray(), "utf-8");
							GTTResponse responseMessage = GTTService.PostSOAP(soapXmlString,applicationObject.getAPPOBJID());
							responseMessages.add(responseMessage);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SOAPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
			else {
				GTTResponse responseMessage = new GTTResponse();
				responseMessage.setResponseCode(500);
				responseMessage.setMessage("No data found in excel !");
				responseMessages.add(responseMessage);
			}
			
			return responseMessages;
		} catch (Exception e) {
			throw new RuntimeException("Error occurred : Reason" + e.getMessage());
		}
	}
}
