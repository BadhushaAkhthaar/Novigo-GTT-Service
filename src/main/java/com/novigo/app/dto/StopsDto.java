package com.novigo.app.dto;

import java.io.Serializable;

public class StopsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String lineNo;
	private String locationCategory_code;
	private String locationId;
	private String locationType_code;
	private String ordinalNumber;
	private String stageSequence;
	private String stopId;
	public StopsDto() {
		super();
	}
	public StopsDto(String lineNo, String locationCategory_code, String locationId, String locationType_code,
			String ordinalNumber, String stageSequence, String stopId) {
		super();
		this.lineNo = lineNo;
		this.locationCategory_code = locationCategory_code;
		this.locationId = locationId;
		this.locationType_code = locationType_code;
		this.ordinalNumber = ordinalNumber;
		this.stageSequence = stageSequence;
		this.stopId = stopId;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public String getLocationCategory_code() {
		return locationCategory_code;
	}
	public void setLocationCategory_code(String locationCategory_code) {
		this.locationCategory_code = locationCategory_code;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationType_code() {
		return locationType_code;
	}
	public void setLocationType_code(String locationType_code) {
		this.locationType_code = locationType_code;
	}
	public String getOrdinalNumber() {
		return ordinalNumber;
	}
	public void setOrdinalNumber(String ordinalNumber) {
		this.ordinalNumber = ordinalNumber;
	}
	public String getStageSequence() {
		return stageSequence;
	}
	public void setStageSequence(String stageSequence) {
		this.stageSequence = stageSequence;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}
	@Override
	public String toString() {
		return "StopsDto [lineNo=" + lineNo + ", locationCategory_code=" + locationCategory_code + ", locationId="
				+ locationId + ", locationType_code=" + locationType_code + ", ordinalNumber=" + ordinalNumber
				+ ", stageSequence=" + stageSequence + ", stopId=" + stopId + "]";
	}
	
	
	
}
