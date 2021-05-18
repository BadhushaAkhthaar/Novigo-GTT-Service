package com.novigo.app.dto;

public class TrackingIdDto {
	private static final long serialVersionUID = 1L;
	
	private String TRXCOD;
	private String TRXID;
	private String START_DATE;
	private String END_DATE;
	private String TIMZON;
	public TrackingIdDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrackingIdDto(String tRXCOD, String tRXID, String sTART_DATE, String eND_DATE, String tIMZON) {
		super();
		TRXCOD = tRXCOD;
		TRXID = tRXID;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		TIMZON = tIMZON;
	}
	public String getTRXCOD() {
		return TRXCOD;
	}
	public void setTRXCOD(String tRXCOD) {
		TRXCOD = tRXCOD;
	}
	public String getTRXID() {
		return TRXID;
	}
	public void setTRXID(String tRXID) {
		TRXID = tRXID;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getTIMZON() {
		return TIMZON;
	}
	public void setTIMZON(String tIMZON) {
		TIMZON = tIMZON;
	}
	@Override
	public String toString() {
		return "TrackingIdDto [TRXCOD=" + TRXCOD + ", TRXID=" + TRXID + ", START_DATE=" + START_DATE + ", END_DATE="
				+ END_DATE + ", TIMZON=" + TIMZON + "]";
	}
	
	
}
