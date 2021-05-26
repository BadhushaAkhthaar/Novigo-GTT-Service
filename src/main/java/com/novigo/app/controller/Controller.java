package com.novigo.app.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPMessage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.dto.ApplicationsDto;
import com.novigo.app.helpers.ExcelHelper;
import com.novigo.app.message.GTTResponse;
import com.novigo.app.message.ResponseMessage;
import com.novigo.app.service.FileUploadService;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import com.sap.cloud.sdk.cloudplatform.security.BasicCredentials;
import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;

import io.vavr.control.Option;
@RestController
public class Controller {
	
	@Autowired
	FileUploadService service;
	
	@Autowired
	XsuaaServiceConfiguration xsuaaConfig;
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	@PostMapping("/upload")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile multipartFile){
		String message = "";
		if(ExcelHelper.isExcel(multipartFile)) {
			try {
				message = multipartFile.getOriginalFilename();
				List<GTTResponse> applications = service.upload(multipartFile);
				return ResponseEntity.status(HttpStatus.OK).body(applications);
				
			}catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Upload only Excel"));
	}
}
