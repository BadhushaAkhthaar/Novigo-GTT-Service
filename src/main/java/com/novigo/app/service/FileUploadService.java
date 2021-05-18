package com.novigo.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.helpers.ExcelHelper;

@Service
public class FileUploadService {
	public String upload(MultipartFile file) {
		try {
			return ExcelHelper.excelToJson(file.getInputStream());
		} catch (Exception e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
