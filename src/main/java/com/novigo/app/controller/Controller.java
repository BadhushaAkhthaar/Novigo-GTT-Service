package com.novigo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.helpers.ExcelHelper;
import com.novigo.app.message.ResponseMessage;
import com.novigo.app.service.FileUploadService;
@RestController
public class Controller {
	
	@Autowired
	FileUploadService service;
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
//				service.upload(multipartFile);
				service.upload(multipartFile);
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ResponseMessage(e.getMessage()));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Upload only Excel"));
	}
}
