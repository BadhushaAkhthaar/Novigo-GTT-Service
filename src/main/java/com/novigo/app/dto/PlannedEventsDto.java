package com.novigo.app.dto;

public class PlannedEventsDto {
	
	private static final long serialVersionUID = 1L;
	
	
	private String MILESTONENUM;
	private String MILESTONE;
	private String LOCTYPE;
	private String LOCID1;
	private String LOCID2;
	private String MSG_EXP_DATETIME;
	private String MSG_ER_EXP_DTIME;
	private String MSG_LT_EXP_DTIME;
	private String EVT_EXP_DATETIME;
	private String EVT_ER_EXP_DTIME;
	private String EVT_LT_EXP_DTIME;
	private String EVT_EXP_TZONE;
	
	
	
	public PlannedEventsDto() {
		super();
	}



	public PlannedEventsDto(String mILESTONENUM, String mILESTONE, String lOCTYPE, String lOCID1, String lOCID2,
			String mSG_EXP_DATETIME, String mSG_ER_EXP_DTIME, String mSG_LT_EXP_DTIME, String eVT_EXP_DATETIME,
			String eVT_ER_EXP_DTIME, String eVT_LT_EXP_DTIME, String eVT_EXP_TZONE) {
		super();
		MILESTONENUM = mILESTONENUM;
		MILESTONE = mILESTONE;
		LOCTYPE = lOCTYPE;
		LOCID1 = lOCID1;
		LOCID2 = lOCID2;
		MSG_EXP_DATETIME = mSG_EXP_DATETIME;
		MSG_ER_EXP_DTIME = mSG_ER_EXP_DTIME;
		MSG_LT_EXP_DTIME = mSG_LT_EXP_DTIME;
		EVT_EXP_DATETIME = eVT_EXP_DATETIME;
		EVT_ER_EXP_DTIME = eVT_ER_EXP_DTIME;
		EVT_LT_EXP_DTIME = eVT_LT_EXP_DTIME;
		EVT_EXP_TZONE = eVT_EXP_TZONE;
	}



	public String getMILESTONENUM() {
		return MILESTONENUM;
	}



	public void setMILESTONENUM(String mILESTONENUM) {
		MILESTONENUM = mILESTONENUM;
	}



	public String getMILESTONE() {
		return MILESTONE;
	}



	public void setMILESTONE(String mILESTONE) {
		MILESTONE = mILESTONE;
	}



	public String getLOCTYPE() {
		return LOCTYPE;
	}



	public void setLOCTYPE(String lOCTYPE) {
		LOCTYPE = lOCTYPE;
	}



	public String getLOCID1() {
		return LOCID1;
	}



	public void setLOCID1(String lOCID1) {
		LOCID1 = lOCID1;
	}



	public String getLOCID2() {
		return LOCID2;
	}



	public void setLOCID2(String lOCID2) {
		LOCID2 = lOCID2;
	}



	public String getMSG_EXP_DATETIME() {
		return MSG_EXP_DATETIME;
	}



	public void setMSG_EXP_DATETIME(String mSG_EXP_DATETIME) {
		MSG_EXP_DATETIME = mSG_EXP_DATETIME;
	}



	public String getMSG_ER_EXP_DTIME() {
		return MSG_ER_EXP_DTIME;
	}



	public void setMSG_ER_EXP_DTIME(String mSG_ER_EXP_DTIME) {
		MSG_ER_EXP_DTIME = mSG_ER_EXP_DTIME;
	}



	public String getMSG_LT_EXP_DTIME() {
		return MSG_LT_EXP_DTIME;
	}



	public void setMSG_LT_EXP_DTIME(String mSG_LT_EXP_DTIME) {
		MSG_LT_EXP_DTIME = mSG_LT_EXP_DTIME;
	}



	public String getEVT_EXP_DATETIME() {
		return EVT_EXP_DATETIME;
	}



	public void setEVT_EXP_DATETIME(String eVT_EXP_DATETIME) {
		EVT_EXP_DATETIME = eVT_EXP_DATETIME;
	}



	public String getEVT_ER_EXP_DTIME() {
		return EVT_ER_EXP_DTIME;
	}



	public void setEVT_ER_EXP_DTIME(String eVT_ER_EXP_DTIME) {
		EVT_ER_EXP_DTIME = eVT_ER_EXP_DTIME;
	}



	public String getEVT_LT_EXP_DTIME() {
		return EVT_LT_EXP_DTIME;
	}



	public void setEVT_LT_EXP_DTIME(String eVT_LT_EXP_DTIME) {
		EVT_LT_EXP_DTIME = eVT_LT_EXP_DTIME;
	}



	public String getEVT_EXP_TZONE() {
		return EVT_EXP_TZONE;
	}



	public void setEVT_EXP_TZONE(String eVT_EXP_TZONE) {
		EVT_EXP_TZONE = eVT_EXP_TZONE;
	}



	@Override
	public String toString() {
		return "PlannedEventsDto [MILESTONENUM=" + MILESTONENUM + ", MILESTONE=" + MILESTONE + ", LOCTYPE=" + LOCTYPE
				+ ", LOCID1=" + LOCID1 + ", LOCID2=" + LOCID2 + ", MSG_EXP_DATETIME=" + MSG_EXP_DATETIME
				+ ", MSG_ER_EXP_DTIME=" + MSG_ER_EXP_DTIME + ", MSG_LT_EXP_DTIME=" + MSG_LT_EXP_DTIME
				+ ", EVT_EXP_DATETIME=" + EVT_EXP_DATETIME + ", EVT_ER_EXP_DTIME=" + EVT_ER_EXP_DTIME
				+ ", EVT_LT_EXP_DTIME=" + EVT_LT_EXP_DTIME + ", EVT_EXP_TZONE=" + EVT_EXP_TZONE + "]";
	}
	
	
	
	
	
	
}
