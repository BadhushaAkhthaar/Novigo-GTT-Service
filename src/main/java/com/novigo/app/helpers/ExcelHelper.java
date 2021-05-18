package com.novigo.app.helpers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.novigo.app.dto.*;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//	  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
//	  static String SHEET = "Tutorials";
	public static final String APPLICATION = "APPLICATION";
	public static final String TRACKINGID = "TRACKINGID";
	public static final String PARAMS = "PARAMS";
	public static final String STOPS = "STOPS";
	public static final String PLANNEDEVENTS = "PLANNEDEVENTS";

	public static List<ApplicationsDto> applications = new ArrayList<>();

	public static boolean isExcel(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static String excelToJson(InputStream is) {
		int numberOfSheets;
		int rowCount;
		String message = "";
		List<String> excelHeaders = new ArrayList<String>();
		List<ShipmentsDto> shipments = new ArrayList<ShipmentsDto>();
		try {
			Workbook workBook = new XSSFWorkbook(is);
			numberOfSheets = workBook.getNumberOfSheets();

			for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {
				String currentSheetName = workBook.getSheetName(sheetIndex);
				switch (currentSheetName) {
				case APPLICATION:
					message = "APP";
					extractApplicationData(workBook);
					break;
				case TRACKINGID:
					message = "TRA";
					break;
				case PARAMS:
					message = "PAR";
					extractParams(workBook);
					break;
				case STOPS:
					message = "MES";
					break;
				case PLANNEDEVENTS:
					message = "PLA";
					break;
				}
			}
			return message;
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}

	}

	public static void extractApplicationData(Workbook workBook) {
		Sheet applicationSheet = workBook.getSheet(APPLICATION);
		Iterator<Row> rows = applicationSheet.iterator();
		int rowCount = 0;
		if(rows.hasNext()) rows.next();
		while (rows.hasNext()) {
			Row currentRow = rows.next(); // Getting instance of current row
			ApplicationsDto application = new ApplicationsDto();

			Iterator<Cell> cells = currentRow.iterator(); // Getting inners cells of the current row
			int cellIndex = 0;
			while (cells.hasNext()) { // Iterating through the cells

				Cell currentCell = cells.next();

				switch (cellIndex) {
				case 0: // Application System
					application.setAPPSYS(currentCell.getStringCellValue());
					break;
				case 1: // Application Object Type
					application.setAPPOBJTYPE(currentCell.getStringCellValue());
					break;
				case 2: // Application Object ID
					application.setAPPOBJID(currentCell.getStringCellValue());
					break;
				}
				cellIndex = cellIndex + 1;
			}
			applications.add(application);
		}
	}

	public static void extractParams(Workbook workBook) {
		Sheet applicationSheet = workBook.getSheet(PARAMS);
		Iterator<Row> rows = applicationSheet.iterator();
		int rowCount = 0;
		if(rows.hasNext()) rows.next();
		
		while (rows.hasNext()) {
			Row currentRow = rows.next(); // Getting instance of current row
			ParametersDto parameters = new ParametersDto();
			List<ParametersDto> tempParamsList = new ArrayList<>();
			Iterator<Cell> cells = currentRow.iterator(); // Getting inners cells of the current row
			int cellIndex = 0;

			ApplicationsDto updatedApplication = new ApplicationsDto();
			ApplicationsDto tempApplication = new ApplicationsDto();
			while (cells.hasNext()) { // Iterating through the cells

				Cell currentCell = cells.next();

				switch (cellIndex) {
				case 0: // Application Object ID
					updatedApplication = findIsPresent(currentCell.getStringCellValue());
					tempApplication = updatedApplication;
					break;
				case 1: // Parameter Name
					parameters.setPARAMNAME(currentCell.getStringCellValue());
					break;
				case 2: // Parameter Index
					parameters.setPARAMINDEX(currentCell.getStringCellValue());
					break;
				case 3: //Parameter Value
					parameters.setVALUE(currentCell.getStringCellValue());
					break;
				}
				cellIndex = cellIndex + 1;
			}
			// Update the global Application object with updated one....
			tempParamsList.add(parameters);
			updatedApplication.setPARAMS(tempParamsList);
			String check = tempF();
		}
	}

	public static ApplicationsDto findIsPresent(String applicationObjId) {
		ApplicationsDto application = new ApplicationsDto();

		application = applications.stream().filter(app -> applicationObjId.equals(app.getAPPOBJID())).findAny()
				.orElse(null);
		return application;
	}
	
	public static String tempF() {
		return "hello";
	}
	
	public static void updateApplications(ApplicationsDto originalObj,ApplicationsDto replacedObj) {
		int index = applications.indexOf(originalObj);
		try {
			if( index > -1) applications.set(index, replacedObj);
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
		
		
	}
}
