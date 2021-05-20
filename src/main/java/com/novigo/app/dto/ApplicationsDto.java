package com.novigo.app.dto;

import java.util.List;

public class ApplicationsDto {
	private static final long serialVersionUID = 1L;
	
	private String APPSYS;
	private String APPOBJTYPE;
	private String APPOBJID;
	private List<ParametersDto> PARAMS;
	private List<PlannedEventsDto> PLANNEDEVENTS;
	private List<TrackingIdDto> TRACKINGID;
	private List<StopsDto> STOPS;
	public ApplicationsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicationsDto(String aPPSYS, String aPPOBJTYPE, String aPPOBJID, List<ParametersDto> pARAMS,
			List<PlannedEventsDto> pLANNEDEVENTS, List<TrackingIdDto> tRACKINGID,List<StopsDto> sTOPS) {
		super();
		APPSYS = aPPSYS;
		APPOBJTYPE = aPPOBJTYPE;
		APPOBJID = aPPOBJID;
		PARAMS = pARAMS;
		PLANNEDEVENTS = pLANNEDEVENTS;
		TRACKINGID = tRACKINGID;
		STOPS = sTOPS;
	}
	public String getAPPSYS() {
		return APPSYS;
	}
	public void setAPPSYS(String aPPSYS) {
		APPSYS = aPPSYS;
	}
	public String getAPPOBJTYPE() {
		return APPOBJTYPE;
	}
	public void setAPPOBJTYPE(String aPPOBJTYPE) {
		APPOBJTYPE = aPPOBJTYPE;
	}
	public String getAPPOBJID() {
		return APPOBJID;
	}
	public void setAPPOBJID(String aPPOBJID) {
		APPOBJID = aPPOBJID;
	}
	public List<ParametersDto> getPARAMS() {
		return PARAMS;
	}
	public void setPARAMS(List<ParametersDto> pARAMS) {
		PARAMS = pARAMS;
	}
	public List<PlannedEventsDto> getPLANNEDEVENTS() {
		return PLANNEDEVENTS;
	}
	public void setPLANNEDEVENTS(List<PlannedEventsDto> pLANNEDEVENTS) {
		PLANNEDEVENTS = pLANNEDEVENTS;
	}
	public List<TrackingIdDto> getTRACKINGID() {
		return TRACKINGID;
	}
	public void setTRACKINGID(List<TrackingIdDto> tRACKINGID) {
		TRACKINGID = tRACKINGID;
	}
	
	
	public List<StopsDto> getSTOPS() {
		return STOPS;
	}
	public void setSTOPS(List<StopsDto> sTOPS) {
		STOPS = sTOPS;
	}
	@Override
	public String toString() {
		return "ApplicationsDto [APPSYS=" + APPSYS + ", APPOBJTYPE=" + APPOBJTYPE + ", APPOBJID=" + APPOBJID
				+ ", PARAMS=" + PARAMS + ", PLANNEDEVENTS=" + PLANNEDEVENTS + ", TRACKINGID=" + TRACKINGID + "]";
	}
	
	
	
	
}
