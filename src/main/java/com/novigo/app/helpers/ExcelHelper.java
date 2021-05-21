package com.novigo.app.helpers;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import com.novigo.app.dto.*;
import com.novigo.app.exceptions.ExcelEmptyCellException;

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

	public static List<ApplicationsDto> excelToJson(InputStream is) {
		applications.clear();
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
					extractTrackId(workBook);
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
					extractPlannedEvents(workBook);
					break;
				}
			}
//			jsonToXML(applications);
			return applications;
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}

	}

	public static void extractApplicationData(Workbook workBook) {
		Sheet applicationSheet = workBook.getSheet(APPLICATION);
		Iterator<Row> rows = applicationSheet.iterator();
		int rowCount = 0;
		if (rows.hasNext())
			rows.next();
		while (rows.hasNext()) {
			Row currentRow = rows.next(); // Getting instance of current row
			ApplicationsDto application = new ApplicationsDto();

			Iterator<Cell> cells = currentRow.iterator(); // Getting inners cells of the current row
			int cellIndex = 0;
			while (cells.hasNext()) { // Iterating through the cells

				Cell currentCell = cells.next();

				switch (cellIndex) {
				case 0: // Application System
					try {
						if(currentCell.getStringCellValue() == "") {
							throw new ExcelEmptyCellException("Cell is empty");
						}
						application.setAPPSYS(currentCell.getStringCellValue());
					} catch (ExcelEmptyCellException e) {
						// TODO Auto-generated catch block
						application = null;
						e.printStackTrace();
					}
					break;
				case 1: // Application Object Type
					try {
						if(currentCell.getStringCellValue() == "") {
							throw new ExcelEmptyCellException("Cell is empty");
						}
						application.setAPPOBJTYPE(currentCell.getStringCellValue());
					} catch (ExcelEmptyCellException e) {
						// TODO Auto-generated catch block
						application = null;
						e.printStackTrace();
					}
					break;
				case 2: // Application Object ID
					try {
						if(currentCell.getStringCellValue() == "") {
							throw new ExcelEmptyCellException("Cell is empty");
						}
						application.setAPPOBJID(currentCell.getStringCellValue());
					} catch (ExcelEmptyCellException e) {
						// TODO Auto-generated catch block
						application = null;
						e.printStackTrace();
					}
					break;
				}
				cellIndex = cellIndex + 1;
			}
			if(application != null) {
				applications.add(application);
			}
		}
	}

	public static void extractParams(Workbook workBook) {
		Sheet applicationSheet = workBook.getSheet(PARAMS);
		Iterator<Row> rows = applicationSheet.iterator();
		int rowCount = 0;
		if (rows.hasNext())
			rows.next();

		while (rows.hasNext()) {
			Row currentRow = rows.next(); // Getting instance of current row
			ParametersDto parameters = new ParametersDto();
			List<ParametersDto> tempParamsList = new ArrayList<>();
			List<ParametersDto> existingParamsList = new ArrayList<>();
			Iterator<Cell> cells = currentRow.iterator(); // Getting inners cells of the current row
			int cellIndex = 0;

			ApplicationsDto updatedApplication = new ApplicationsDto();
			ApplicationsDto tempApplication = new ApplicationsDto();
			while (cells.hasNext()) { // Iterating through the cells

				Cell currentCell = cells.next();

				switch (cellIndex) {
				case 0: // Application Object ID
					updatedApplication = findIsPresent(currentCell.getStringCellValue());
					if (updatedApplication == null)
						break;
					tempApplication = updatedApplication;
					break;
				case 1: // Parameter Name
					parameters.setPARAMNAME(currentCell.getStringCellValue());
					break;
				case 2: // Parameter Index
					parameters.setPARAMINDEX(currentCell.getStringCellValue());
					break;
				case 3: // Parameter Value
					parameters.setVALUE(currentCell.getStringCellValue());
					break;
				}
				cellIndex = cellIndex + 1;
			}
			// Update the global Application object with updated one....
			if (updatedApplication == null)
				break;
			existingParamsList = updatedApplication.getPARAMS();
			if (existingParamsList == null) {
				tempParamsList.add(parameters);
				updatedApplication.setPARAMS(tempParamsList);
			} else {
				existingParamsList.add(parameters);
			}
			String check = tempF();
		}
	}

	public static void extractTrackId(Workbook workBook) {

		Sheet applicationSheet = workBook.getSheet(TRACKINGID);
		Iterator<Row> rows = applicationSheet.iterator();
		int rowCount = 0;
		if (rows.hasNext())
			rows.next();

		while (rows.hasNext()) {
			Row currentRow = rows.next(); // Getting instance of current row
			TrackingIdDto trackingIds = new TrackingIdDto();
			List<TrackingIdDto> tempTrackIdList = new ArrayList<>();
			List<TrackingIdDto> existingTrackIdList = new ArrayList<>();
			Iterator<Cell> cells = currentRow.iterator(); // Getting inners cells of the current row
			int cellIndex = 0;

			ApplicationsDto updatedApplication = new ApplicationsDto();
			ApplicationsDto tempApplication = new ApplicationsDto();
			while (cells.hasNext()) { // Iterating through the cells

				Cell currentCell = cells.next();

				switch (cellIndex) {
				case 0: // Application Object ID
					updatedApplication = findIsPresent(currentCell.getStringCellValue());
					if (updatedApplication == null)
						break;
					tempApplication = updatedApplication;
					break;
				case 1: // Trx code
					trackingIds.setTRXCOD(currentCell.getStringCellValue());
					break;
				case 2: // Trx Id
					trackingIds.setTRXID(currentCell.getStringCellValue());
					break;
				case 3: // Start Date
					trackingIds.setSTART_DATE(currentCell.getStringCellValue());
					break;
				case 4: // End Date
					trackingIds.setEND_DATE(currentCell.getStringCellValue());
					break;
				case 5: // Time Zone
					trackingIds.setTIMZON(currentCell.getStringCellValue());
					break;
				}
				cellIndex = cellIndex + 1;
			}
			// Update the global Application object with updated one....
			if (updatedApplication == null)
				break;
			existingTrackIdList = updatedApplication.getTRACKINGID();
			if (existingTrackIdList == null) {
				tempTrackIdList.add(trackingIds);
				updatedApplication.setTRACKINGID(tempTrackIdList);
			} else {
				existingTrackIdList.add(trackingIds);
			}
			String check = tempF();
		}

	}

	public static void extractPlannedEvents(Workbook workBook) {

		Sheet applicationSheet = workBook.getSheet(PLANNEDEVENTS);
		Iterator<Row> rows = applicationSheet.iterator();
		int rowCount = 0;
		if (rows.hasNext())
			rows.next();

		while (rows.hasNext()) {
			rowCount++;
			Row currentRow = rows.next(); // Getting instance of current row
			PlannedEventsDto planEvents = new PlannedEventsDto();
			List<PlannedEventsDto> tempPEventsList = new ArrayList<>();
			List<PlannedEventsDto> existingPEventsList = new ArrayList<>();
			Iterator<Cell> cells = currentRow.iterator(); // Getting inners cells of the current row
			int cellIndex = 0;

			ApplicationsDto updatedApplication = new ApplicationsDto();
			ApplicationsDto tempApplication = new ApplicationsDto();
			while (cells.hasNext()) { // Iterating through the cells

				Cell currentCell = cells.next();

				switch (cellIndex) {
				case 0: // Application Object ID
					updatedApplication = findIsPresent(currentCell.getStringCellValue());
					if (updatedApplication == null)
						break;
					tempApplication = updatedApplication;
					break;
				case 1: // MileStone Number
					planEvents.setMILESTONENUM(currentCell.getStringCellValue());
					break;
				case 2: // MileStone
					planEvents.setMILESTONE(currentCell.getStringCellValue());
					break;
				case 3: // Location Type
					planEvents.setLOCTYPE(currentCell.getStringCellValue());
					break;
				case 4: // LocationID1
					planEvents.setLOCID1(currentCell.getStringCellValue());
					break;
				case 5: // LocationID2
					planEvents.setLOCID2(currentCell.getStringCellValue());
					break;
				case 6: // Message Exp Date Time
					planEvents.setMSG_EXP_DATETIME(currentCell.getStringCellValue());
					break;
				case 7: // Message Erp Date Time
					planEvents.setMSG_ER_EXP_DTIME(currentCell.getStringCellValue());
					break;
				case 8: // Message Lt Date Time
					planEvents.setMSG_LT_EXP_DTIME(currentCell.getStringCellValue());
					break;
				case 9: // Event Exp Date Time
					planEvents.setEVT_EXP_DATETIME(currentCell.getStringCellValue());
					break;
				case 10: // Event Erp Date Time
					planEvents.setEVT_ER_EXP_DTIME(currentCell.getStringCellValue());
					break;
				case 11: // Event Lt Date Time
					planEvents.setEVT_LT_EXP_DTIME(currentCell.getStringCellValue());
					break;
				case 12: // Event Exp Time Zone
					planEvents.setEVT_EXP_TZONE(currentCell.getStringCellValue());
					break;

				}
				cellIndex = cellIndex + 1;
			}
			// Update the global Application object with updated one....
			if (updatedApplication == null)
				break;
			existingPEventsList = updatedApplication.getPLANNEDEVENTS();
			if (existingPEventsList == null) {
				tempPEventsList.add(planEvents);
				updatedApplication.setPLANNEDEVENTS(tempPEventsList);
			} else {
				existingPEventsList.add(planEvents);
			}
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

	public static void updateApplications(ApplicationsDto originalObj, ApplicationsDto replacedObj) {
		int index = applications.indexOf(originalObj);
		try {
			if (index > -1)
				applications.set(index, replacedObj);
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public static ByteArrayOutputStream jsonToXML(ApplicationsDto applicationJson) throws SOAPException {

		HashMap<String, String> edi_dc40Elems = new HashMap<String, String>();
		edi_dc40Elems = Constants.getDC40ElemCnst();

		List<String> appObjList = new ArrayList<String>();
		appObjList = Constants.getAppObjCnst();

//		List<String> paramList = new ArrayList<String>();
		final List<String> paramList = Constants.getParamsCnst();

//		List<String> planEveList = new ArrayList<String>();
		final List<String> planEveList = Constants.getPlanEveCnst();

//		List<String> trackIdList = new ArrayList<String>();
		final List<String> trackIdList = Constants.getTrackIdCnst();

		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactory.createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPBody soapBody = envelope.getBody();

			SOAPElement gttMsgHeader = soapBody.addChildElement("GTTMSG01");
			gttMsgHeader.addAttribute(new QName("xmlns"), "urn:sap-com:document:sap:idoc:soap:messages");

			SOAPElement idocEl = gttMsgHeader.addChildElement("IDOC");
			idocEl.addAttribute(new QName("BEGIN"), "1");

			SOAPElement edi_dc40 = idocEl.addChildElement("EDI_DC40");
			edi_dc40.addAttribute(new QName("SEGMENT"), "1");

			edi_dc40Elems.forEach((key, value) -> {
				try {
					SOAPElement newNode = edi_dc40.addChildElement(key);
					newNode.addTextNode(value);
				} catch (SOAPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			SOAPElement e1ehpaoEl = idocEl.addChildElement("E1EHPAO");
			e1ehpaoEl.addAttribute(new QName("SEGMENT"), "1");

			appObjList.forEach((appObj) -> {
				SOAPElement newNode = insertChild(e1ehpaoEl, appObj);
				switch (appObj) {
				case "APPSYS":
					insertText(newNode, applicationJson.getAPPSYS());
					break;
				case "APPOBJTYPE":
					insertText(newNode, applicationJson.getAPPOBJTYPE());
					break;
				case "APPOBJID":
					insertText(newNode, applicationJson.getAPPOBJID());
					break;
				}
			});

			List<ParametersDto> allParams = new ArrayList<ParametersDto>();
			allParams = applicationJson.getPARAMS();

			allParams.forEach((param) -> {
				SOAPElement e1ehpcpEl;
				e1ehpcpEl = insertChild(e1ehpaoEl, "E1EHPCP");
				insertAttribute(e1ehpcpEl, "SEGMENT","1");
				paramList.forEach((paramCnst) -> {
					SOAPElement newNode = insertChild(e1ehpcpEl, paramCnst);
					switch (paramCnst) {
					case "PARAMNAME":
						insertText(newNode, param.getPARAMNAME());
						break;
					case "PARAMINDEX":
						insertText(newNode, param.getPARAMINDEX());
						break;
					case "VALUE":
						insertText(newNode, param.getVALUE());
						break;
					}
				});
			});
			
			List<PlannedEventsDto> allPlanEve = new ArrayList<PlannedEventsDto>();
			allPlanEve = applicationJson.getPLANNEDEVENTS();
			
			allPlanEve.forEach((pEvents) -> {
				SOAPElement e1ehpeeEl;
				e1ehpeeEl = insertChild(e1ehpaoEl, "E1EHPEE");
				insertAttribute(e1ehpeeEl, "SEGMENT","1");
				planEveList.forEach((pEveCnst) -> {
					SOAPElement newNode = insertChild(e1ehpeeEl, pEveCnst);
					switch (pEveCnst) {
					case "MILESTONENUM":
						insertText(newNode, formatNull(pEvents.getMILESTONENUM()));
						break;
					case "MILESTONE":
						insertText(newNode, formatNull(pEvents.getMILESTONE()));
						break;
					case "LOCTYPE":
						insertText(newNode, formatNull(pEvents.getLOCTYPE()));
						break;
					case "LOCID1":
						insertText(newNode, formatNull(pEvents.getLOCID1()));
						break;
					case "LOCID2":
						insertText(newNode, formatNull(pEvents.getLOCID2()));
						break;
					case "MSG_EXP_DATETIME":
						insertText(newNode, formatNull(pEvents.getMSG_EXP_DATETIME()));
						break;
					case "MSG_ER_EXP_DTIME":
						insertText(newNode, formatNull(pEvents.getMSG_ER_EXP_DTIME()));
						break;
					case "MSG_LT_EXP_DTIME":
						insertText(newNode, formatNull(pEvents.getMSG_LT_EXP_DTIME()));
						break;
					case "EVT_EXP_DATETIME":
						insertText(newNode, formatNull(pEvents.getEVT_EXP_DATETIME()));
						break;
					case "EVT_ER_EXP_DTIME":
						insertText(newNode, formatNull(pEvents.getEVT_ER_EXP_DTIME()));
						break;
					case "EVT_LT_EXP_DTIME":
						insertText(newNode, formatNull(pEvents.getEVT_LT_EXP_DTIME()));
						break;
					case "EVT_EXP_TZONE":
						insertText(newNode, formatNull(pEvents.getEVT_EXP_TZONE()));
						break;
					}
				});
			});
			
			
			List<TrackingIdDto> allTrackId = new ArrayList<TrackingIdDto>();
			allTrackId = applicationJson.getTRACKINGID();
			
			allTrackId.forEach((trackId) -> {
				SOAPElement e1ehptidEl;
				e1ehptidEl = insertChild(e1ehpaoEl, "E1EHPTID");
				insertAttribute(e1ehptidEl, "SEGMENT","1");
				trackIdList.forEach((trackIdCnst) -> {
					SOAPElement newNode = insertChild(e1ehptidEl, trackIdCnst);
					switch (trackIdCnst) {
					case "TRXCOD":
						insertText(newNode, formatNull(trackId.getTRXCOD()));
						break;
					case "TRXID":
						insertText(newNode, formatNull(trackId.getTRXID()));
						break;
					case "START_DATE":
						insertText(newNode, formatNull(trackId.getSTART_DATE()));
						break;
					case "END_DATE":
						insertText(newNode, formatNull(trackId.getEND_DATE()));
						break;
					case "TIMZON":
						insertText(newNode, formatNull(trackId.getTIMZON()));
						break;
					}
				});
			});

			soapMessage.saveChanges();
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			soapMessage.writeTo(stream);
//			FileOutputStream file = new FileOutputStream(applicationJson.getAPPOBJID() + ".xml");
//			soapMessage.writeTo(file);
//			file.close();
			System.out.println();
			return stream;
		} catch (Exception e) {
			throw new RuntimeException("Message Factory Error: " + e.getMessage());
		}
	}

	public static SOAPElement insertChild(SOAPElement elm, String name) {
		try {
			return elm.addChildElement(name);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elm;
	}

	public static void insertText(SOAPElement elm, String name) {
		try {
			elm.addTextNode(name);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertAttribute(SOAPElement elm, String key,String value) {
		try {
			elm.addAttribute(new QName(key),value);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String formatNull(String text) {
		return text == null ? "" : text ;
	}
}
