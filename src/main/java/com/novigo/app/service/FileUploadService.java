package com.novigo.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.dto.ApplicationsDto;
import com.novigo.app.helpers.ExcelHelper;

@Service
public class FileUploadService {
	public List<ApplicationsDto> upload(MultipartFile file) {
		try {
			return ExcelHelper.excelToJson(file.getInputStream());
		} catch (Exception e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
