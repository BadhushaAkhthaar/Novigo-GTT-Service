package com.novigo.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.dto.ApplicationsDto;
import com.novigo.app.helpers.ExcelHelper;

@Service
public class FileUploadService {
	public List<ApplicationsDto> upload(MultipartFile file) {
		List<ApplicationsDto> allApplicationObjects = new ArrayList<>();
		try {
			allApplicationObjects = ExcelHelper.excelToJson(file.getInputStream());
			
			if(allApplicationObjects != null) {
				
				allApplicationObjects.forEach((applicationObject)->{
					try {
						ExcelHelper.jsonToXML(applicationObject);
					} catch (SOAPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
			
			
			//Temp Return Statement
			List<ApplicationsDto> temp = new ArrayList<>();
			return temp;
			//Need to be removed
		} catch (Exception e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
